package top.meethigher.demo20.jdbctemplate;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.meethigher.demo20.dao.impl.AccountDaoImpl;

/**
 * JdbcTemplateDemo03
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/5
 */
public class JdbcTemplateDemo03 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext aac = new ClassPathXmlApplicationContext("spring.xml");
        AccountDaoImpl accoundDao = aac.getBean("accountDao", AccountDaoImpl.class);
        System.out.println(accoundDao.findAccountById(1));
//        System.out.println(accoundDao.findAccountByName("水冰儿"));
        System.out.println(accoundDao.findAccountByName("小舞"));
    }
}
