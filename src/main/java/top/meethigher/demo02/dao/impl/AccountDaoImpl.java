package top.meethigher.demo02.dao.impl;


import top.meethigher.demo02.dao.AccountDao;

/**
 * AccountDaoImpl
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/24
 */
public class AccountDaoImpl implements AccountDao {
    private int i=1;
    @Override
    public void saveAccount() {
        i++;
        System.out.println("保存数据"+i);
    }
}
