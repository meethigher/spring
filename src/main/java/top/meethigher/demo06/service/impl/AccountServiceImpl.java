package top.meethigher.demo06.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import top.meethigher.demo06.dao.AccountDao;
import top.meethigher.demo06.dao.impl.AccountDaoImpl;
import top.meethigher.demo06.service.AccountService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * AccountServiceImpl
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/24
 */
@Component(value = "accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    @Qualifier("accountDao1")
//    @Resource(name="accountDao1")，相当于以上两个，该注解由java提供，8以上需要自己引入
    private AccountDao accountDao;
    @Value("20")//spel表达式暂不演示
    private Integer num;

    public AccountServiceImpl() {
        System.out.println("对象已经创建了！" + "num=" + num + ",accountDao=" + accountDao);
    }

    @Override
    public void saveAccount() {
        accountDao.saveAccount();
        System.out.println(num);
    }

    @PostConstruct
    public void init() {
        System.out.println("初始化方法");
    }

    @PreDestroy
    public void destroy() {
        System.out.println("销毁方法");
    }
}
