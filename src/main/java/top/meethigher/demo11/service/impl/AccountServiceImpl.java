package top.meethigher.demo11.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.meethigher.demo11.dao.AccountDao;
import top.meethigher.demo11.domain.Account;
import top.meethigher.demo11.service.AccountService;
import top.meethigher.demo11.utils.TransactionManager;

import java.util.List;

/**
 * AccountServiceImpl
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/28
 */
public class AccountServiceImpl implements AccountService {


    private AccountDao accountDao;
    private TransactionManager tManager;

    public void settManager(TransactionManager tManager) {
        this.tManager = tManager;
    }

    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }

    @Override
    public List<Account> findAll() {
        try {
            //1.开启事务
            tManager.beginTransaction();
            //2.执行操作
            List<Account> accounts = accountDao.findAll();
            //3.提交事务
            tManager.commitTransaction();
            //4.返回结果
            return accounts;
        } catch (Exception e) {
            //5.回滚操作
            tManager.rollbackTransaction();
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            tManager.release();
        }
    }

    @Override
    public Account findById(Integer id) {
        try {
            //1.开启事务
            tManager.beginTransaction();
            //2.执行操作
            Account byId = accountDao.findById(id);
            //3.提交事务
            tManager.commitTransaction();
            //4.返回结果
            return byId;
        } catch (Exception e) {
            //5.回滚操作
            tManager.rollbackTransaction();
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            tManager.release();
        }
    }

    @Override
    public void saveAccount(Account account) {
        try {
            //1.开启事务
            tManager.beginTransaction();
            //2.执行操作
            accountDao.saveAccount(account);
            //3.提交事务
            tManager.commitTransaction();
        } catch (Exception e) {
            //5.回滚操作
            tManager.rollbackTransaction();
        } finally {
            //6.释放连接
            tManager.release();
        }
    }

    @Override
    public void updateAccount(Account account) {
        try {
            //1.开启事务
            tManager.beginTransaction();
            //2.执行操作
            accountDao.updateAccount(account);
            //3.提交事务
            tManager.commitTransaction();
        } catch (Exception e) {
            //5.回滚操作
            tManager.rollbackTransaction();
        } finally {
            //6.释放连接
            tManager.release();
        }
    }

    @Override
    public void deleteAccount(Integer id) {
        try {
            //1.开启事务
            tManager.beginTransaction();
            //2.执行操作
            accountDao.deleteAccount(id);
            //3.提交事务
            tManager.commitTransaction();
        } catch (Exception e) {
            //5.回滚操作
            tManager.rollbackTransaction();
        } finally {
            //6.释放连接
            tManager.release();
        }
    }

    @Override
    public int findCount() {
        try {
            //1.开启事务
            tManager.beginTransaction();
            //2.执行操作
            int count = accountDao.findCount();
            //3.提交事务
            tManager.commitTransaction();
            //4.返回结果
            return count;
        } catch (Exception e) {
            //5.回滚操作
            tManager.rollbackTransaction();
            throw new RuntimeException(e);
        } finally {
            //6.释放连接
            tManager.release();
        }
    }

    @Override
    public void transfer(String sourceName, String targetName, Float money) {
        try {

            tManager.beginTransaction();

            //1.根据名称查询转出账户、转入账户
            Account source = accountDao.findByName(sourceName);
            Account target = accountDao.findByName(targetName);
            //2.转出账户减钱，转入账户加钱
            source.setMoney(source.getMoney() - money);
            target.setMoney(target.getMoney() + money);
            //3.更新转出账户、转入账户
            accountDao.updateAccount(source);

            //用来模拟问题
            int i = 2 / 0;

            accountDao.updateAccount(target);

            tManager.commitTransaction();

        } catch (Exception e) {
            System.out.println("转账失败！开始回滚");
            tManager.rollbackTransaction();
        } finally {
            tManager.release();
        }

    }
}
