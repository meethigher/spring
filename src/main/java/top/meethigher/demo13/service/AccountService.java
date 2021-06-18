package top.meethigher.demo13.service;

import top.meethigher.demo13.domain.Account;

import java.util.List;

/**
 * AccountService
 * 账户业务层接口
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/28
 */
public interface AccountService {
    List<Account> findAll();

    Account findById(Integer id);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer id);

    int findCount();

    /**
     * 转账
     * @param sourceName 转出账户名称
     * @param targetName 转入账户名称
     * @param money 转账金额
     */
    void transfer(String sourceName, String targetName, Float money);
}
