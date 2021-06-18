package top.meethigher.demo14.service.impl;

import top.meethigher.demo14.service.AccountService;

/**
 * AccountServiceImpl
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/4
 */
public class AccountServiceImpl implements AccountService {
    @Override
    public void saveAccount() {
        System.out.println("保存账户！");
    }

    @Override
    public void updateAccount(int i) {
        System.out.println("更新账户！");
    }

    @Override
    public int deleteAccount() {
        System.out.println("删除账户！");
        return 0;
    }
}
