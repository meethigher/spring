package top.meethigher.demo24.dao;

import top.meethigher.demo24.domain.Account;

/**
 * IAccountDao
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/5
 */
public interface AccountDao {
    Account findAccountByName(String name);

    /**
     * 转账
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money 转账金额
     */
    void transfer(String sourceName, String targetName, Float money);

    void update(Account account);

}
