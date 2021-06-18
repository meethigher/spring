package top.meethigher.demo16;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.meethigher.demo16.service.AccountService;

/**
 * SpringAopTest16
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/4
 */
public class SpringAopTest16 {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
        AccountService as = (AccountService) ac.getBean("accountService");
        as.saveAccount();
    }
}
