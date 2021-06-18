package top.meethigher.demo05.ui;


import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.meethigher.demo05.service.AccountService;

/**
 * Client
 * 模拟表现层，用于调用业务层
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/24
 */
public class SpringClient05 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");
        accountService.saveAccount();
    }
}
