package top.meethigher.demo18.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * SpringConfiguration
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/5
 */
@Configuration
@ComponentScan("top.meethigher.demo18")
@EnableAspectJAutoProxy
public class SpringConfiguration {
    @Bean("ds")
    public DataSource createDataSource(){
        ComboPooledDataSource ds = null;
        try {
            ds = new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.cj.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://localhost:3306/spring?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useSSL=false");
            ds.setUser("root");
            ds.setPassword("1050121804");
        } catch (PropertyVetoException e) {
            throw new RuntimeException(e);
        }
        return ds;
    }
    @Bean("runner")
    @Scope("prototype")
    public QueryRunner createRunner(@Qualifier("ds") DataSource ds){
        return new QueryRunner(ds);
    }
}
