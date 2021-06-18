package top.meethigher.demo04.service.impl;


import top.meethigher.demo04.service.AccountService;

/**
 * AccountServiceImpl
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/24
 */
public class AccountServiceImpl implements AccountService {

    public AccountServiceImpl() {
        System.out.println("AccountService对象已经创建了！");
    }

    public void saveAccount() {
        System.out.println("service中的saveAccount方法执行");
    }

    public void init() {
        System.out.println("对象初始化");
    }

    public void destroy() {
        System.out.println("对象销毁");
    }
}
