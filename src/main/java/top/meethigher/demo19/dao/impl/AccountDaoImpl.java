package top.meethigher.demo19.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Component;
import top.meethigher.demo19.dao.IAccountDao;
import top.meethigher.demo19.domain.Account;

import java.util.List;

/**
 * AccountDaoImpl
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/5
 */
@Component("accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public Account findAccountById(Integer accountId) {
        List<Account> query = jdbcTemplate.query("select * from account where id=?", new BeanPropertyRowMapper<>(Account.class), accountId);
        if(query.isEmpty()){
            return null;
        }
        return query.get(0);
    }

    @Override
    public Account findAccountByName(String name) {
        List<Account> query = jdbcTemplate.query("select * from account where name=?", new BeanPropertyRowMapper<>(Account.class), name);
        if(query.isEmpty()){
            return null;
        }
        if(query.size()>1){
            throw new RuntimeException("结果不唯一");
        }
        return query.get(0);
    }

    @Override
    public void updateAccount(Account account) {
        jdbcTemplate.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }
}
