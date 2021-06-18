package top.meethigher.demo21.dao.impl;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import top.meethigher.demo21.dao.AccountDao;
import top.meethigher.demo21.domain.Account;

import java.util.List;

/**
 * AccountDaoImpl
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/5
 */
public class AccountDaoImpl extends JdbcDaoSupport implements AccountDao {

    @Override
    public Account findAccountByName(String name) {
        List<Account> query = super.getJdbcTemplate().query(
                "select * from account where name=?",
                new BeanPropertyRowMapper<>(Account.class),
                name);
        if (!query.isEmpty()) {
            return query.get(0);
        }
        return null;
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        Account account1 = findAccountByName(sourceName);
        Account account2 = findAccountByName(targetName);
        account1.setMoney(account1.getMoney()-money);
        account2.setMoney(account2.getMoney()+money);
        update(account1);
        int a=2/0;
        update(account2);
    }

    @Override
    public void update(Account account) {
        super.getJdbcTemplate().update(
                "update account set money=? where id=?",
                account.getMoney(), account.getId()
        );
    }
}
