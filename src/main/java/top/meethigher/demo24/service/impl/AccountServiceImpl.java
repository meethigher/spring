package top.meethigher.demo24.service.impl;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;
import top.meethigher.demo24.dao.AccountDao;
import top.meethigher.demo24.service.AccountService;

/**
 * AccountServiceImpl
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/19
 */
public class AccountServiceImpl implements AccountService {
    private TransactionTemplate transactionTemplate;
    private AccountDao accountDao;

    public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
        this.transactionTemplate = transactionTemplate;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public void transfer(String sourceName, String targetName, float money) {
        transactionTemplate.execute(new TransactionCallback<Object>() {
            @Override
            public Object doInTransaction(TransactionStatus transactionStatus) {
                accountDao.transfer(sourceName, targetName, money);
                return null;
            }
        });

    }
}
