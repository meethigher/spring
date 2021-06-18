package top.meethigher.demo21;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.PlatformTransactionManager;
import top.meethigher.demo21.service.AccountService;

/**
 * Test21
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/19
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class Test21 {
    @Autowired
    private AccountService accountService;

    @Test
    public void testTransfer() {
        accountService.transfer("白沉香","小舞",500f);
    }
}
