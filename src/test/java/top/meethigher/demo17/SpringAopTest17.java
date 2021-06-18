package top.meethigher.demo17;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.meethigher.demo17.service.AccountService;
import top.meethigher.demo17.config.SpringConfiguration;

/**
 * SpringAopTest16
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/4
 */
public class SpringAopTest17 {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        AccountService as = (AccountService) ac.getBean("accountService");
        as.saveAccount();
    }
}
