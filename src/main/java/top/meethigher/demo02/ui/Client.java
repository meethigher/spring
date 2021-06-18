package top.meethigher.demo02.ui;


import top.meethigher.demo02.factory.BeanFactory;
import top.meethigher.demo02.service.AccountService;
import top.meethigher.demo02.service.impl.AccountServiceImpl;

/**
 * Client
 * 模拟表现层，用于调用业务层
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/24
 */
public class Client {
    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            AccountService as = (AccountServiceImpl) BeanFactory.getBean("accountService");
            as.saveAccount();
        }
    }
}
