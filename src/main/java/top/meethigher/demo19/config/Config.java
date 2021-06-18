package top.meethigher.demo19.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Config
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/5
 */
@Configuration
@ComponentScan("top.meethigher.demo19")
@EnableAspectJAutoProxy
public class Config {
    @Bean("ds")
    public DataSource createDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
        ds.setUsername("root");
        ds.setPassword("1050121804");
        return ds;
    }
    @Bean("jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(@Qualifier("ds") DataSource ds){
        return new JdbcTemplate(ds);
    }
}
