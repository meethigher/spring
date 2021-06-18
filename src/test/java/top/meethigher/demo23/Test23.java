package top.meethigher.demo23;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.meethigher.demo23.config.SpringConfig;
import top.meethigher.demo23.service.AccountService;

/**
 * Test23
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/21
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class Test23 {
    @Autowired
    private AccountService accountService;

    @Test
    public void testTransfer() {
        accountService.transfer("白沉香","小舞",500f);
    }
}
