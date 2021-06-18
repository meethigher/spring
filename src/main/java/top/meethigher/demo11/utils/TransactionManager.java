package top.meethigher.demo11.utils;

import java.sql.SQLException;

/**
 * TransactionManager
 * 事务管理相关的工具类，他包含了开启事务、提交事务、回滚事务和释放连接
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/3/7
 */
public class TransactionManager {
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    /**
     * 开启手动提交事务
     */
    public void beginTransaction(){
        try {
            connectionUtils.getThreadConnection().setAutoCommit(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 提交事务
     */
    public void commitTransaction(){
        try {
            connectionUtils.getThreadConnection().commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 回滚事务
     */
    public void rollbackTransaction(){
        try {
            connectionUtils.getThreadConnection().rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 释放连接
     */
    public void release(){
        try {
            connectionUtils.getThreadConnection().close();//归还连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
