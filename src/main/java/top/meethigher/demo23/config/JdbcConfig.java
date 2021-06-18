package top.meethigher.demo23.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.DriverManager;

/**
 * JdbcConfig
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/21
 */
@Configuration
@PropertySource("classpath:jdbc.properties")
public class JdbcConfig {
    @Value("${u}")
    private String USER;
    @Value("${pw}")
    private String PASS;
    @Value("${driver}")
    private String DRIVER;
    @Value("${url}")
    private String URL;
    @Bean("jdbcTemplate")
    public JdbcTemplate createJdbcTemplate(@Qualifier("ds") DataSource ds){
        return new JdbcTemplate(ds);
    }
    @Bean("ds")
    public DataSource createDataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUsername(USER);
        ds.setPassword(PASS);
        ds.setDriverClassName(DRIVER);
        ds.setUrl(URL);
        return ds;
    }
}
