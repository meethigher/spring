package top.meethigher.demo22.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import top.meethigher.demo22.dao.AccountDao;
import top.meethigher.demo22.service.AccountService;

/**
 * AccountServiceImpl
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/19
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountDao accountDao;

    @Override
    public void transfer(String sourceName, String targetName, float money) {
        accountDao.transfer(sourceName,targetName,money);
    }
}
