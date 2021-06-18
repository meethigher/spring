package top.meethigher.demo17.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * SpringConfiguration
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/5
 */
@Configuration
@ComponentScan("top.meethigher.demo17")
@EnableAspectJAutoProxy
public class SpringConfiguration {
}
