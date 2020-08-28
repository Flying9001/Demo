## 各种 java 测试 Demo  

​    
`java` 开发过程中技术测试用例,包括Java类的书写规范,java工具类,Spring的配置,  

mybatis 的配置应用, shiro 的配置应用, Maven 项目的搭建等      

### 1 一个标准的 java bean 写法  

可参考: [com.ljq.demo.bean.JavaBeanDemo](src/main/java/com/ljq/demo/bean/JavaBeanDemo.java)  
​        
### 2 标准的 Java 工具类(util)写法  

可参考: [com.ljq.demo.util.JavaUtilDemo](src/main/java/com/ljq/demo/util/JavaUtilDemo.java)  

### 3 单例模式(线程安全)  

可参考: [com.ljq.demo.mode.SingletonModeDemo](src/main/java/com/ljq/demo/mode/SingletonModeDemo.java)  

### 4 jackson 解析复杂 json  

已知所有节点Key

```
./src/main/java/com/ljq/demo/util/LogisticsUtils.java
./src/test/java/com/ljq/demo/util/LogisticsUtilsTest.java
```

已知 Json 结构，但未知子节点 Key

```
./src/main/java/com/ljq/demo/bean/FormAreaInfo.java
./src/main/java/com/ljq/demo/constant/FormConst.java
./src/main/java/com/ljq/demo/util/JsonUtil.java
./src/test/java/com/ljq/demo/util/JsonUtilTest.java
```

### 5 java validation 参数校验  

[参数校验-1-validation注解--2018-12-16](doc/1.参数校验-1-validation注解.md "doc/1.参数校验-1-validation注解.md")  

[参数校验-2-自定义注解--2018-12-16](doc/2.参数校验-2-自定义注解.md "doc/2.参数校验-2-自定义注解.md")  

### 6 java 分页查询工具---2018-11-29    

[com.ljq.demo.util.QueryUtil](src/main/java/com/ljq/demo/util/QueryUtil.java "src/main/java/com/ljq/demo/util/QueryUtil.java")  

[com.ljq.demo.util.PageUtil](src/main/java/com/ljq/demo/util/PageUtil.java "src/main/java/com/ljq/demo/util/PageUtil.java")  

### 7 java 防止 SQL 注入工具类---2018-11-29  

[com.ljq.demo.util.SqlCheckUtil](src/main/java/com/ljq/demo/util/SqlCheckUtil.java "src/main/java/com/ljq/demo/util/SqlCheckUtil.java")  

### 8 mybatis mapper 文件模板与规范---2018-11-29    

[src/main/resources/IntegralGoodsDao.xml](src/main/resources/IntegralGoodsDao.xml "src/main/resources/IntegralGoodsDao.xml")  

### 9 对象创建规范 --- 2019-06-30  

#### 9.1 静态工厂方法  

```
./src/main/java/com/ljq/demo/object/StaticMethodDemo.java
./src/test/java/com/ljq/demo/object/StaticMethodDemoTest.java
```

#### 9.2 构建器  

```
./src/main/java/com/ljq/demo/object/BuilderUserDemo.java
./src/test/java/com/ljq/demo/object/BuilderUserDemoTest.java

./src/main/java/com/ljq/demo/object/BuilderPizzaDemo.java
./src/main/java/com/ljq/demo/object/BuilderSweetPizzaDemo.java
./src/test/java/com/ljq/demo/object/BuilderSweetPizzaDemoTest.java
```

### 10  java bean 对象复制  

```
./src/test/java/com/ljq/demo/bean/JavaBeanDemoTest.java
```

### 11 基础 DAO  

```
./src/main/java/com/ljq/demo/base/BaseDao.java
```

### 12 java 多线程

#### 12.1 抢票程序与测试   

```
./src/main/java/com/ljq/demo/concurrentWorkPiao.java
./src/main/java/com/ljq/demo/concurrent/PiaoDemo.java
./src/test/java/com/ljq/demo/concurrent/WorkPiaoTest.java
```

#### 12.2 多个线程等待一个线程 CountDownLatch  

```
./src/main/java/com/ljq/demo/concurrent/Worker.java
./src/main/java/com/ljq/demo/concurrent/CountDownLatchDemo.java
```

#### 12.3 模拟多线程操作共享变量  

```
./src/main/java/com/ljq/demo/concurrent/WorkCalculate.java
./src/main/java/com/ljq/demo/concurrent/CalculateDemo.java
```

### 13 批量插入大量测试数据  

```
./src/main/java/com/ljq/demo/util/DataSourceUtil.java
./src/test/java/com/ljq/demo/util/DataSourceUtilTest.java
```

### 14 java JWT example  

```
./src/main/java/com/ljq/demo/util/JwtUtil.java
./src/test/java/com/ljq/demo/util/JwtUtilTest.java
```

### 15 Java 8 遍历迭代器  

```
./src/test/java/com/ljq/demo/util/IteratorTest.java
```

[Java 8 遍历迭代器 Iterator](https://blog.csdn.net/mrqiang9001/article/details/108275318 "https://blog.csdn.net/mrqiang9001/article/details/108275318")  

### 16 手动获取 Spring Bean  

```
./src/main/java/com/ljq/demo/util/SpringBeanUtil.java
```

注意事项: 需要 Spring 扫描到对应的包才能装载  

### 17 数据库操作工具类  

多种数据库自动识别与操作  

```
./src/main/java/com/ljq/demo/bean/Column.java
./src/main/java/com/ljq/demo/bean/Table.java
./src/main/java/com/ljq/demo/constant/DbTypeConst.java
./src/main/java/com/ljq/demo/enums/ColumnType.java

./src/main/java/com/ljq/demo/util/db/AbstractDbOperator.java
./src/main/java/com/ljq/demo/util/db/MySqlOperator.java
./src/main/java/com/ljq/demo/util/db/OracleOperator.java
./src/main/java/com/ljq/demo/util/db/SqlServerOperator.java
./src/main/java/com/ljq/demo/util/db/DbOperatorFactory.java
```















