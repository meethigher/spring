demo01：简单演示类之间的耦合关系

demo02：演示传统开发过程中的耦合问题，表现层、服务层、持久层，有一层出现依赖缺失关系，就无法编译。通过工厂模式读取配置文件来创建bean对象来解决问题。这个demo下也遇到了静态代码块加载顺序的问题，可以去[b站](https://www.bilibili.com/video/BV1TU4y1W7qn?p=4)看

demo03：spring入门案例，并且演示spring创建bean对象的时机，立即与延迟

demo04：创建bean对象的细节，时机、三种方式、作用范围、生命周期

demo05：依赖注入中的构造函数注入、set方法注入

demo06：常用的注解

demo07：基于xml的crud

demo08：基于注解（不能完全使用注解，外部项目还需要部分xml）的crud

demo09：使用完全注解crud，不依赖xml

demo10：Spring整合Junit进行测试，不依赖xml

demo11：事务控制案例（转账）

demo12：动态代理学习，基于接口（JDK官方提供）、子类（CGLib提供）的动态代理

demo13：事务控制案例（通过动态代理进行转账的优化）

demo14：基于XML的Spring AOP：切入点表达式

demo15：基于XML的Spring AOP：四种通知类型和环绕通知

demo16：基于XML与注解的Spring AOP

demo17：基于完全注解的Spring AOP

demo18：SpringAOP完全注解实现事务转账案例

demo19：基于完全注解的JdbcTemplate增删改查

demo20：基于xml的JdbcTemplate增删改查

demo21：spring中基于xml的声明式事务，使用JdbcTemplate实现转账

demo22：spring中基于xml+注解的声明式事务，使用JdbcTemplate实现转账

demo23：spring中基于注解的声明式事务，使用JdbcTemplate实现转账

demo24：spring中编程式事务