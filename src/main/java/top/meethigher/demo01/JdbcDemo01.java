package top.meethigher.demo01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * JdbcDemo01
 * 演示类之间的耦合
 *
 * @author kit chen
 * @github https://github.com/meethigher
 * @blog https://meethigher.top
 * @time 2021/2/18
 */
public class JdbcDemo01 {
    public static void main(String[] args) throws Exception {
        //1.注册驱动
        //这种写法算是一种优化，依赖的只是一个字符串，找不到就是没有
        //去掉依赖，编译仍然可以通过
        Class.forName("com.mysql.cj.jdbc.Driver");
        //这种写法存在解耦问题，依赖的是一个类文件，如果去掉依赖，编译不通过
//        DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        //2.获取连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/spring?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Shanghai&useSSL=false", "root", "1050121804");
        //3.获取操作数据库的预处理对象
        PreparedStatement ps = conn.prepareStatement("select * from account");
        //4.执行sql，得到结果集
        ResultSet rs = ps.executeQuery();
        //5.封装结果集
        while(rs.next()){
            System.out.println(rs.getString("name"));
        }
        //6.释放资源
        rs.close();
        ps.close();
        conn.close();
    }
}
