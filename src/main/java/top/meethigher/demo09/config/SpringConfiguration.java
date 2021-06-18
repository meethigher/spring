package top.meethigher.demo09.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * SpringConfiguration
 * 该类是一个配置类，他的作用和spring.xml是一样的
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/3/6
 */
@Configuration
@ComponentScan("top.meethigher.demo09")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {

}
