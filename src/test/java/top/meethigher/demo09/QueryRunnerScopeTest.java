package top.meethigher.demo09;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import top.meethigher.demo09.config.SpringConfiguration;

/**
 * QueryRunnerScopeTest
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/3/6
 */
public class QueryRunnerScopeTest {
    @Test
    public void test() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        for(int i=0;i<4;i++){
            System.out.println( ac.getBean("runner", QueryRunner.class));
        }
    }
}
