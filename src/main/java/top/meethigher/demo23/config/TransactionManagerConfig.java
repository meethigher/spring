package top.meethigher.demo23.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * TransactionManagerConfig
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/21
 */
@Configuration
public class TransactionManagerConfig {
    @Bean("transactionManager")
    public PlatformTransactionManager createTransactionManager(@Qualifier("ds") DataSource ds){
        return new DataSourceTransactionManager(ds);
    }
}
