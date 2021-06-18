package top.meethigher.demo06.dao.impl;

import org.springframework.stereotype.Component;
import top.meethigher.demo06.dao.AccountDao;

/**
 * AccountDaoImpl1
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/28
 */
@Component("accountDao1")
public class AccountDaoImpl1 implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存数据1");
    }
}
