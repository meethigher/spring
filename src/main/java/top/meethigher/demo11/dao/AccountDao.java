package top.meethigher.demo11.dao;

import top.meethigher.demo11.domain.Account;

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

    /**
     * 根据名称查询账户
     * @param name
     * @return 如果有唯一的一个结果就返回，如果没有结果就返回null
     *  如果结果集超过一个就抛出异常
     */
    Account findByName(String name);
}
