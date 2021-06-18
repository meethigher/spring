package top.meethigher.demo14.utils;

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
     * 用于打印日志，计划让其在切入点方法执行之前执行(切入点方法就是业务层方法)
     */
    public void printLog(){
        System.out.println("Logger类中的printLog开始记录日志！");
    }
}
