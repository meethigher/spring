package top.meethigher.demo08.service;

import top.meethigher.demo08.domain.Account;

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
}
