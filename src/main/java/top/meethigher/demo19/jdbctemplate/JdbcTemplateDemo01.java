package top.meethigher.demo19.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

/**
 * JdbcTemplate的基本用法
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/4/5
 */
public class JdbcTemplateDemo01 {
    public static void main(String[] args) {
        //准备数据源：Spring的内置数据源
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/spring?useSSL=false&useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai");
        ds.setUsername("root");
        ds.setPassword("1050121804");
        //1.创建JdbcTemplate对象
        JdbcTemplate jt=new JdbcTemplate();
        jt.setDataSource(ds);
        //2. 执行操作
        jt.execute("insert into account(name,money)values('ccc',1000)");
    }
}
