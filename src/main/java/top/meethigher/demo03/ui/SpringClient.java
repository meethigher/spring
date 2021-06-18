package top.meethigher.demo03.ui;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import top.meethigher.demo03.dao.AccountDao;
import top.meethigher.demo03.dao.impl.AccountDaoImpl;
import top.meethigher.demo03.service.AccountService;
import top.meethigher.demo03.service.impl.AccountServiceImpl;

/**
 * Client
 * 模拟表现层，用于调用业务层
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/24
 */
public class SpringClient {
    /**
     * 获取Spring的ioc核心容器，并根据id获取对象
     * @param args
     */
    public static void main(String[] args) {
        //=====ApplicationContext
        //1.获取核心容器对象
//        ApplicationContext ac=new ClassPathXmlApplicationContext("spring.xml");
////        ApplicationContext ac = new FileSystemXmlApplicationContext("D:\\Develop\\JavaDev\\Spring-notes\\src\\main\\resources\\spring.xml");
//        //2.根据id获取bean对象
//        AccountServiceImpl accountService = (AccountServiceImpl) ac.getBean("accountService");
//
//
//        System.out.println(accountService);


        //=====BeanFactory，延迟加载
        Resource resource=new ClassPathResource("spring.xml");
        BeanFactory factory = new XmlBeanFactory(resource);
        AccountService accountService = (AccountService) factory.getBean("accountService");
        System.out.println(accountService);
    }
}
