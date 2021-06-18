package top.meethigher.demo13.service.impl;

import top.meethigher.demo13.dao.AccountDao;
import top.meethigher.demo13.domain.Account;
import top.meethigher.demo13.service.AccountService;
import top.meethigher.demo13.utils.TransactionManager;

import java.util.List;

/**
 * AccountServiceImpl
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/28
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {
        return accountDao.findAll();
    }

    @Override
    public Account findById(Integer id) {
        return accountDao.findById(id);
    }

    @Override
    public void saveAccount(Account account) {
        accountDao.saveAccount(account);
    }

    @Override
    public void updateAccount(Account account) {
        accountDao.updateAccount(account);

    }

    @Override
    public void deleteAccount(Integer id) {
        accountDao.deleteAccount(id);
    }

    @Override
    public int findCount() {
        return accountDao.findCount();

    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        //1.根据名称查询转出账户、转入账户
        Account source = accountDao.findByName(sourceName);
        Account target = accountDao.findByName(targetName);
        //2.转出账户减钱，转入账户加钱
        source.setMoney(source.getMoney() - money);
        target.setMoney(target.getMoney() + money);
        //3.更新转出账户、转入账户
        accountDao.updateAccount(source);

        //用来模拟问题
        int i = 2 / 0;

        accountDao.updateAccount(target);
    }
}
