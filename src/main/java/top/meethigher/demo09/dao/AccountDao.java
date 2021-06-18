package top.meethigher.demo09.dao;

import top.meethigher.demo09.domain.Account;

import java.util.List;

/**
 * AccountDao
 * 账户持久层接口
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/28
 */

public interface AccountDao {
    List<Account> findAll();

    Account findById(Integer id);

    void saveAccount(Account account);

    void updateAccount(Account account);

    void deleteAccount(Integer id);

    int findCount();
}
