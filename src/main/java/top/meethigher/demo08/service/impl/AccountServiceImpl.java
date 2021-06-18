package top.meethigher.demo08.service.impl;

import org.springframework.stereotype.Service;
import top.meethigher.demo08.dao.AccountDao;
import top.meethigher.demo08.domain.Account;
import top.meethigher.demo08.service.AccountService;

import javax.annotation.Resource;
import java.util.List;

/**
 * AccountServiceImpl
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/28
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource(name="accountDao")
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
}
