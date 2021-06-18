package top.meethigher.demo03.service.impl;


import top.meethigher.demo03.dao.AccountDao;
import top.meethigher.demo03.dao.impl.AccountDaoImpl;
import top.meethigher.demo03.service.AccountService;

/**
 * AccountServiceImpl
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/24
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao = new AccountDaoImpl();

    public AccountServiceImpl(){
        System.out.println("对象已经创建了！");
    }

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
    }
}
