package top.meethigher.demo12.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Consumer1
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/3/23
 */
public class Consumer1 {
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
         * 涉及的类：Enhancer
         * 提供者：第三方cglib库
         */
        Producer proxyProducer = (Producer) Enhancer.create(producer.getClass(), new MethodInterceptor() {
            /**
             * 执行被代理对象任何方法，都会经过该方法
             * @param proxy 代理对象的引用
             * @param method 当前执行的方法
             * @param args 参数
             * @param methodProxy 当前执行方法的代理对象
             * @return
             * @throws Throwable
             */
            @Override
            public Object intercept(Object proxy, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                Object returnValue = null;
                Float money = (Float) args[0];
                if ("saleProduct".equals(method.getName())) {
                    returnValue = method.invoke(producer, money * 0.8f);
                }
                return returnValue;
            }
        });

        proxyProducer.saleProduct(10000f);
    }
}

