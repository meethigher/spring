package top.meethigher.demo15.utils;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Logger
 * 用于记录日志的工具类，它里面提供了公共的代码
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/4
 */
public class Logger {
    /**
     * 前置通知
     */
    public void beforePrintLog(){
        System.out.println("Logger类中的--前置通知--开始记录日志！");
    }
    /**
     * 后置通知
     */
    public void afterReturningPrintLog(){
        System.out.println("Logger类中的--后置通知--开始记录日志！");
    }

    /**
     * 异常通知
     */
    public void afterThrowingPrintLog(){
        System.out.println("Logger类中的--异常通知--开始记录日志！");
    }

    /**
     * 最终通知
     */
    public void afterPrintLog(){
        System.out.println("Logger类中的--最终通知--开始记录日志！");
    }

    /**
     * 环绕通知
     */
    public Object aroundPrintLog(ProceedingJoinPoint proceedingJoinPoint){
        Object rtValue=null;
        try{
            Object[] args=proceedingJoinPoint.getArgs();
            //日志写在这里算前置通知
            rtValue= proceedingJoinPoint.proceed(args);
            //日志写在这里算后置通知
            System.out.println("Logger类中的--环绕通知--开始记录日志！");
            return rtValue;
        }catch (Throwable t){
            //日志写在这里算异常通知
            throw new RuntimeException(t);
        }finally {
            //日志写在这里算最终通知
        }

    }
}
