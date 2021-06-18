package top.meethigher.demo11;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import top.meethigher.demo11.domain.Account;
import top.meethigher.demo11.service.AccountService;

import java.util.List;

/**
 * AnnotationClientTest09
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/3/6
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class SpringAndJunitTest11 {
    @Autowired
    @Qualifier("accountService")
    private AccountService accountService;

    @Test
    public void transfer() {
        accountService.transfer("白沉香","小舞",500f);
    }

    @Test
    public void testFindAll() {
        List<Account> all = accountService.findAll();
        System.out.println(all);
    }

    @Test
    public void testFindById() {
        Account byId = accountService.findById(1);
        System.out.println(byId);
    }

    @Test
    public void testUpdateAccount() {
        Account account = new Account();
        account.setId(4);
        account.setName("水冰儿");
        account.setMoney(7000f);
        accountService.updateAccount(account);
    }

    @Test
    public void testDeleteAccount() {
        accountService.deleteAccount(4);
    }

    /**
     * 重点：保存，并且返回自增的id
     */
    @Test
    public void testSaveAccount() {
        Account account = new Account();
        account.setName("水冰儿");
        account.setMoney(8000f);
        accountService.saveAccount(account);
        System.out.println(account);
    }

    /**
     * 重点：聚合查询
     */
    @Test
    public void testFindCount() {
        System.out.println(accountService.findCount());
    }

    /**
     * 测试传递对象（地址），形参改变，实参是否改变
     */
    @Test
    public void test() {
        Account account = new Account();
        m(account);
        System.out.println(account);
    }

    public void m(Account account) {
        account.setId(1);
    }

}
