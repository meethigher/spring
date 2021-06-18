package top.meethigher.demo18.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * TransactionManager
 * 事务管理相关的工具类，他包含了开启事务、提交事务、回滚事务和释放连接
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/3/7
 */
@Component("tsManager")
@Aspect
public class TransactionManager {
    @Autowired
    private ConnectionUtils connectionUtils;
    @Pointcut("execution(* top.meethigher.demo18.service.impl.*.*(..))")
    private void pt(){}

    /**
     * 开启手动提交事务
     */
    @Before("pt()")
    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
            System.out.println("开启手动提交事务");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    @AfterReturning("pt()")
    public void commitTransaction(){
        try {
            connectionUtils.getThreadConnection().commit();
            System.out.println("提交事务");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    @AfterThrowing("pt()")
    public void rollbackTransaction(){
        try {
            connectionUtils.getThreadConnection().rollback();
            System.out.println("回滚事务");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
    @After("pt()")
    public void release(){
        try {
            connectionUtils.getThreadConnection().close();//归还连接
            System.out.println("归还连接");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
