package top.meethigher.demo19.jdbctemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import top.meethigher.demo19.config.Config;
import top.meethigher.demo19.domain.Account;

import java.util.List;

/**
 * JdbcTemplateDemo02
 * 注解开发
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/5
 */
public class JdbcTemplateDemo02 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext aac = new AnnotationConfigApplicationContext(Config.class);
//        JdbcTemplate jdbcTemplate = (JdbcTemplate) aac.getBean("jdbcTemplate");
        JdbcTemplate jdbcTemplate = aac.getBean("jdbcTemplate", JdbcTemplate.class);
        //插入
//        jdbcTemplate.execute("insert into account(name,money)values('ddd',2222)");
        //修改
//        jdbcTemplate.update("update account set name=?,money=? where id=?","bbb",111,13);
        //删除
//        jdbcTemplate.update("delete from account where id=?",13);
        //查询所有
//        List<Account> query = jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<>(Account.class));
//        System.out.println(query);
        //查询一个
//        List<Account> query = jdbcTemplate.query("select * from account where id=?", new BeanPropertyRowMapper<>(Account.class), 1);
//        System.out.println(query.get(0));
        //查询总记录数
        Long aLong = jdbcTemplate.queryForObject("select count(*) from account where money>?", Long.class, 1000);
        System.out.println(aLong);
    }
}
