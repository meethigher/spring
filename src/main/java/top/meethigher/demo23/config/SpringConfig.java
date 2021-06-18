package top.meethigher.demo23.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Config
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/21
 */
@Configuration
@ComponentScan(basePackages = "top.meethigher.demo23")
@Import({JdbcConfig.class,TransactionManagerConfig.class})
@EnableTransactionManagement//开启对事务的支持
public class SpringConfig {
}
