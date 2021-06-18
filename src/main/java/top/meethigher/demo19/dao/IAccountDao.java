package top.meethigher.demo19.dao;

import top.meethigher.demo19.domain.Account;

/**
 * IAccountDao
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/5
 */
public interface IAccountDao {
    Account findAccountById(Integer accountId);

    Account findAccountByName(String name);

    void updateAccount(Account account);

}
