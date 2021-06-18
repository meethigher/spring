package top.meethigher.demo23.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import top.meethigher.demo23.dao.AccountDao;
import top.meethigher.demo23.domain.Account;

import java.util.List;

/**
 * AccountDaoImpl
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/5
 */
@Repository("accountDao")
@Transactional(readOnly = true)//配置为只读事务，也就是查询
public class AccountDaoImpl implements AccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Account findAccountByName(String name) {
        List<Account> query = jdbcTemplate.query(
                "select * from account where name=?",
                new BeanPropertyRowMapper<>(Account.class),
                name);
        if (!query.isEmpty()) {
            return query.get(0);
        }
        return null;
    }

    @Transactional(readOnly = false)//修改为读写事务，也就是增删改
    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        Account account1 = findAccountByName(sourceName);
        Account account2 = findAccountByName(targetName);
        account1.setMoney(account1.getMoney()-money);
        account2.setMoney(account2.getMoney()+money);
        update(account1);
//        int a=2/0;
        update(account2);
    }

    @Override
    public void update(Account account) {
        jdbcTemplate.update(
                "update account set money=? where id=?",
                account.getMoney(), account.getId()
        );
    }
}
