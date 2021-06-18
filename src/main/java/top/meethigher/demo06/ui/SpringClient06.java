package top.meethigher.demo06.ui;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import top.meethigher.demo06.dao.AccountDao;
import top.meethigher.demo06.service.AccountService;
import top.meethigher.demo06.service.impl.AccountServiceImpl;

/**
 * Client
 * 模拟表现层，用于调用业务层
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/24
 */
public class SpringClient06 {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        AccountServiceImpl accountService = (AccountServiceImpl) ac.getBean("accountService");
        System.out.println(accountService);
        accountService.saveAccount();
        ac.close();//测试@PreDestroy注解
    }
}
