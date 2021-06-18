package top.meethigher.demo02.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * BeanFactory
 * 工厂模式创建Bean对象
 * Bean：在计算机英语中，有可重用组件的含义。
 * JavaBean：java语言编写的可重用组件
 * javabean>实体类
 *
 * BeanFactory用于创建我们的service和dao对象的
 * 1.需要一个配置文件来配置我们的service和dao
 * 2.通过读取配置文件中配置的内容，反射创建对象
 *
 * 配置文件应该包含
 * 唯一标识=全限定类名（key=value）
 * 配置文件可以使xml也可以是properties
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/24
 */
public class BeanFactory {
    //定义一个Properties对象
    private static Properties props;

    //定义一个Map,用于存放我们要创建的对象。我们把它称之为容器
    private static Map<String,Object> beans;

    //使用静态代码块为Properties对象赋值
    static {
        System.out.println("静态代码块执行..");
        try {
            props = new Properties();
            InputStream is = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
            props.load(is);
            //实例化容器
            beans = new HashMap<String,Object>();
            //取出配置文件中所有的Key
            Enumeration<Object> keys = props.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                String beanPath = props.getProperty(key);
//                Object value = Class.forName(beanPath).newInstance();
                //jdk9以后的实例化推荐写法
                Object value = Class.forName(beanPath).getDeclaredConstructor().newInstance();
                beans.put(key,value);
            }
        }catch(Exception e){
            throw new ExceptionInInitializerError("初始化properties失败！");
        }
        System.out.println("静态代码块执行完毕!");
    }

    /**
     * 根据bean的名称获取对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        Object o = beans.get(beanName);
        System.out.println("获取"+beanName+"..此时beans的大小："+beans.size()+"..此时要获取的内容："+o.toString());
        return o;
    }

}
