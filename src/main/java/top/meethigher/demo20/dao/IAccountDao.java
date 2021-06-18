package top.meethigher.demo20.dao;

import top.meethigher.demo20.domain.Account;

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
