package top.meethigher.demo02.service.impl;


import top.meethigher.demo02.dao.AccountDao;
import top.meethigher.demo02.dao.impl.AccountDaoImpl;
import top.meethigher.demo02.factory.BeanFactory;
import top.meethigher.demo02.service.AccountService;

/**
 * AccountServiceImpl
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/24
 */
public class AccountServiceImpl implements AccountService {
    //    private AccountDao accountDao=new AccountDaoImpl();
    //直接在后面实例化，或者在默认构造方法中，进行实例化，会出现问题。具体原因为啥，咱不清楚。
    private AccountDao accountDao;

    @Override
    public void saveAccount() {
        accountDao = (AccountDaoImpl) BeanFactory.getBean("accountDao");
        accountDao.saveAccount();
    }
}
