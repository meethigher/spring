package top.meethigher.demo13.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import top.meethigher.demo13.dao.AccountDao;
import top.meethigher.demo13.domain.Account;
import top.meethigher.demo13.utils.ConnectionUtils;

import java.sql.SQLException;
import java.util.List;

/**
 * AccountDaoImpl
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/28
 */
public class AccountDaoImpl implements AccountDao {
    private QueryRunner runner;
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    @Override
    public List<Account> findAll() {
        try {
            return runner.query(connectionUtils.getThreadConnection(),"select * from account", new BeanListHandler<Account>(Account.class));
        } catch (SQLException e) {
            //因为sqlexception是编译时期异常，必须处理。把他作为运行时异常，就可以不用处理了。
            throw new RuntimeException();
        }
    }

    @Override
    public Account findById(Integer id) {
        try {
            return runner.query(connectionUtils.getThreadConnection(),"select * from account where id=?", new BeanHandler<Account>(Account.class), id);
        } catch (SQLException e) {
            throw new RuntimeException();
        }
    }


    @Override
    public void updateAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"update account set name=?,money=? where id=?", account.getName(), account.getMoney(), account.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteAccount(Integer id) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"delete from account where id=?", id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 重点：保存并返回id
     * @param account
     */
    @Override
    public void saveAccount(Account account) {
        try {
            runner.update(connectionUtils.getThreadConnection(),"insert into account(name,money) values(?,?)", account.getName(), account.getMoney());
            //形参是对象时，实际传的是地址。改变形参会影响实参。
            account.setId(Integer.parseInt(runner.query("select last_insert_id() id",new MapHandler()).get("id").toString()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 重点：聚合查询
     * @return
     */
    @Override
    public int findCount() {
        try {
            // 法一
//            return Integer.parseInt(runner.query("select count(*) count from account", new MapHandler()).get("count").toString());
            // 法二
            return Integer.parseInt(runner.query(connectionUtils.getThreadConnection(),"select count(*) from account",new ScalarHandler<>(1)).toString());
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();

        }
    }

    @Override
    public Account findByName(String name) {
        try {
            List<Account> list = runner.query(connectionUtils.getThreadConnection(),"select * from account where name=?", new BeanListHandler<Account>(Account.class), name);
            if(list==null||list.size()==0){
                return null;
            }
            if(list.size()>1){
                throw new RuntimeException("结果集不唯一，数据有问题");
            }
            return list.get(0);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
