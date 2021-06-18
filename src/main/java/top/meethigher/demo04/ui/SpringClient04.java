package top.meethigher.demo04.ui;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import top.meethigher.demo04.service.AccountService;

/**
 * Client
 * 模拟表现层，用于调用业务层
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/24
 */
public class SpringClient04 {
    /**
     * 获取Spring的ioc核心容器，并根据id获取对象
     *
     * @param
     *
     */
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        AccountService accountService = (AccountService) ac.getBean("accountService");
        System.out.println(accountService);

        //手动关闭容器，如果此处使用ApplicationContext是没有close方法的，原因是父类无法调用子类特有的方法
        ac.close();
    }
}
