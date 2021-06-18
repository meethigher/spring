package top.meethigher.demo10.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

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
@ComponentScan("top.meethigher.demo10")
@Import(JdbcConfig.class)
@PropertySource("classpath:jdbc.properties")
public class SpringConfiguration {

}
