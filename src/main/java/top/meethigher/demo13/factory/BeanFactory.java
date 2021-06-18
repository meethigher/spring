package top.meethigher.demo13.factory;

import top.meethigher.demo13.service.AccountService;
import top.meethigher.demo13.utils.TransactionManager;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * BeanFactory
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/3
 */
public class BeanFactory {
    private AccountService accountService;
    private TransactionManager tsManager;

    public final void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public void setTsManager(TransactionManager tsManager) {
        this.tsManager = tsManager;
    }

    public AccountService getAccountService() {
        return (AccountService) Proxy.newProxyInstance(
                accountService.getClass().getClassLoader(),
                accountService.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object rtVale = null;
                        try {
                            tsManager.beginTransaction();
                            Object invoke = method.invoke(accountService, args);
                            System.out.println("提交事务...");
                            tsManager.commitTransaction();
                            return invoke;
                        } catch (Exception e) {
                            System.out.println("出现异常,回滚事务...");
                            tsManager.rollbackTransaction();
                            throw new RuntimeException(e);
                        } finally {
                            System.out.println("释放连接...");
                            tsManager.release();
                        }
                    }
                });
    }
}
