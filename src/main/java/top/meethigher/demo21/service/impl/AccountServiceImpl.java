package top.meethigher.demo21.service.impl;

import top.meethigher.demo21.dao.AccountDao;
import top.meethigher.demo21.service.AccountService;

/**
 * AccountServiceImpl
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/19
 */
public class AccountServiceImpl implements AccountService {
    private AccountDao accountDao;

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String sourceName, String targetName, float money) {
        accountDao.transfer(sourceName,targetName,money);
    }
}
