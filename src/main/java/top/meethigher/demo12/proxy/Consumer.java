package top.meethigher.demo12.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Consumer
 * 基于接口的动态代理
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/3/23
 */
public class Consumer {
    public static void main(String[] args) {
        final ProducerImpl producer = new ProducerImpl();
        /**
         * 动态代理
         * 特点：字节码随用随创建，随用随加载
         * 作用：不修改源码的基础上，对方法增强
         * 分类：
         * 基于接口的动态代理
         * 基于子类的动态代理
         * 基于接口的动态代理：
         * 涉及的类：Proxy
         * 提供者：JDK官方
         */
        Producer proxyProducer = (Producer) Proxy.newProxyInstance(ProducerImpl.class.getClassLoader(), producer.getClass().getInterfaces(), new InvocationHandler() {
            /**
             * 执行任何被代理对象的任何接口方法都会经过该方法，相当于拦截功能
             * @param proxy 代理对象的引用
             * @param method 当前执行的方法
             * @param args 当前执行方法所需的参数
             * @return 和被代理对象有相同的返回值
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return method.invoke(producer,args);//相当于什么也没做
                //进行增强
                Object returnValue=null;
                Float money = (Float) args[0];
                if("saleProduct".equals(method.getName())){
                    returnValue=method.invoke(producer,money*0.8f);
                }
                return returnValue;
            }
        });
        proxyProducer.saleProduct(10000f);
    }
}
