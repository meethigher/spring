package top.meethigher.demo06.dao.impl;


import org.springframework.stereotype.Component;
import top.meethigher.demo06.dao.AccountDao;

/**
 * AccountDaoImpl
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/24
 */
@Component("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存数据");
    }
}
