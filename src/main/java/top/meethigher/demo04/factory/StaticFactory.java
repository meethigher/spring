package top.meethigher.demo04.factory;

import top.meethigher.demo04.service.AccountService;
import top.meethigher.demo04.service.impl.AccountServiceImpl;

/**
 * StaticFactory
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/26
 */
public class StaticFactory {
    public static AccountService getAccountService(){
        return new AccountServiceImpl();
    }
}
