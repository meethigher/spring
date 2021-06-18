package top.meethigher.demo15;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.meethigher.demo15.service.AccountService;

/**
 * SpringAopTest15
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/4
 */
public class SpringAopTest15 {
    public static void main(String[] args) {
        ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
        AccountService as = (AccountService) ac.getBean("accountService");
        as.saveAccount();
    }
}
