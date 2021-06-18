package top.meethigher.demo13.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * ConnectionUtils
 * 连接的工具类，用于从数据源中获取一个连接，并且实现和线程的绑定
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/3/7
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> tl=new ThreadLocal<>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 获取当前线程上的连接
     * @return
     */
    public Connection getThreadConnection(){
        //1.先从ThreadLocal上获取
        Connection conn = tl.get();
        try {
            //2.判断当前线程上是否有连接
            if (conn == null||conn.isClosed()) {
                //3.从数据源中获取一个连接，并且和线程绑定，存入ThreadLocal中
                conn = dataSource.getConnection();
                tl.set(conn);
            }
            //4.返回当前线程上的连接
            return conn;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    /**
     * 将线程与连接解绑
     */
    public void removeConnection(){
        tl.remove();
    }
}
