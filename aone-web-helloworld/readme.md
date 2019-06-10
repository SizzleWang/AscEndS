#### 开发环境
+ JDK1.8
+ Maven3.5
+ Tomcat9
+ MySQL8
+ Neo4j3.3.6
+ Elasticsearch6.3.1

开发工具推荐：
+ Intellij IDEA
+ Chrome应用Postman

#### 基本配置
+ Neo4j，配置configure.properties的Neo4j部分，以及Neo4jConfig.java中的Repository包路径
+ Elasticsearch，配置configure.properties的Elasticsearch部分
+ JDBC与C3P0，修改spring.xml及jdbc.properties
+ MyBatis，在spring.xml配置sqlSessionFactory和MapperScannerConfigurer中mapperLocations、typeAliasesPackage、basePackage等参数
+ MyBatis代码自动生成器，在需要生成代码时修改generatorConfig.xml，并在pom.xml同级目录下运行命令：
`mvn -Dmybatis.generator.overwrite=false mybatis-generator:generate`

#### 目录/包结构
+ pom.xml maven配置文件
+ src 项目源文件
+ src/test 项目测试代码
+ src/main 项目源代码
+ src/main/resources 项目配置文件、资源文件
+ src/main/resources/configure.properties 一些基本配置项
+ src/main/resources/generatorConfig.xml MyBatis代码自动生成的插件配置文件
+ src/main/resources/jdbc.properties JDBC配置
+ src/main/resources/log4j2.xml log4j日志配置
+ src/main/resources/spring.xml Spring配置
+ src/main/resources/spring-mvc.xml SpringMVC相关配置
+ src/main/resources/spring-mybatis.xml MyBatis相关配置
+ src/main/java java源代码
+ src/main/java/cn.edu.uestc.aone java源代码都在这个包下，与pom.xml中groupId对应，唯一标识项目组构建的java程序
+ src/main/java/cn.edu.uestc.aone.web 项目组的web应用代码
+ src/main/java/cn.edu.uestc.aone.web.helloworld web应用helloworld示例
+ src/main/java/cn.edu.uestc.aone.web.helloworld.config 读取src/main/resources/configure.properties配置文件，对程序做部分初始化
+ src/main/java/cn.edu.uestc.aone.web.helloworld.controller SpringMVC中Controller模块，往往需要调用service模块完成业务
+ src/main/java/cn.edu.uestc.aone.web.helloworld.service service模块接口与实现
+ src/main/java/cn.edu.uestc.aone.web.helloworld.service.impl 业务逻辑的实现，往往需要从持久化层取数据
+ src/main/java/cn.edu.uestc.aone.web.helloworld.dao 持久化层，负责与数据库交互
+ src/main/java/cn.edu.uestc.aone.web.helloworld.dao.es 与ElasticSearch交互
+ src/main/java/cn.edu.uestc.aone.web.helloworld.dao.neo4j 与Neo4j交互
+ src/main/java/cn.edu.uestc.aone.web.helloworld.dao.rdb 与关系数据库交互，本项目配置的是MySQL，采用MyBatis框架。包含Mapper接口及配置
+ src/main/java/cn.edu.uestc.aone.web.helloworld.dao.rdb.impl MyBatis的Mapper实现，是xml配置文件
+ src/main/java/cn.edu.uestc.aone.web.helloworld.model SpringMVC中Model模块，数据的载体，包含POJO对象
+ src/main/java/cn.edu.uestc.aone.web.helloworld.model.po 持久化对象，对应数据库中的实体
+ src/main/java/cn.edu.uestc.aone.web.helloworld.model.po.es ElasticSearch持久化对象
+ src/main/java/cn.edu.uestc.aone.web.helloworld.model.po.neo4j Neo4j持久化对象
+ src/main/java/cn.edu.uestc.aone.web.helloworld.model.po.rdb 关系数据库持久化对象
+ src/main/java/cn.edu.uestc.aone.web.helloworld.model.vo 视图对象，传递给视图的数据载体
+ src/main/webapp web应用主目录
+ src/main/webapp/css css代码
+ src/main/webapp/html html代码
+ src/main/webapp/img 图片
+ src/main/webapp/js JavaScript代码
+ src/main/webapp/static 静态资源
+ src/main/webapp/WEB-INF java编译代码及依赖包，编译代码在classes目录下
+ src/main/webapp/WEB-INF/lib java依赖包
