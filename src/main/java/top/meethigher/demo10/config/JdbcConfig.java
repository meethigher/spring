package top.meethigher.demo10.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * JdbcConfig
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/3/6
 */

public class JdbcConfig {
    @Value("${driver}")
    private String driver;
    @Value("${url}")
    private String url;
    @Value("${u}")
    private String username;
    @Value("${pw}")
    private String password;

    /**
     * 用于创建QueryRunner
     *
     * @param ds
     * @return
     */
    @Bean("runner")
    @Scope("prototype")
    public QueryRunner createQueryRunner(@Qualifier("ds1") DataSource ds) {
        return new QueryRunner(ds);
    }

    @Bean("ds1")
    public DataSource createDataSource() {
        ComboPooledDataSource ds = null;
        System.out.println("1执行");
        try {
            ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        return ds;
    }

    @Bean("ds2")
    public DataSource createDataSource1() {
        ComboPooledDataSource ds = null;
        System.out.println("2执行");
        try {
            ds = new ComboPooledDataSource();
            ds.setDriverClass(driver);
            ds.setJdbcUrl(url);
            ds.setUser(username);
            ds.setPassword(password);
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        return ds;
    }
}