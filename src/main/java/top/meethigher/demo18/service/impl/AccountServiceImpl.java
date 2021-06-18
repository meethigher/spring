package top.meethigher.demo18.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.meethigher.demo18.dao.AccountDao;
import top.meethigher.demo18.domain.Account;
import top.meethigher.demo18.service.AccountService;

import java.util.List;

/**
 * AccountServiceImpl
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/28
 */
@Component("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;


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
//        int i = 2 / 0;

        accountDao.updateAccount(target);
    }
}
