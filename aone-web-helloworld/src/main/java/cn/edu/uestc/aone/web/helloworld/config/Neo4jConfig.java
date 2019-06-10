package cn.edu.uestc.aone.web.helloworld.config;

import org.neo4j.ogm.session.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.transaction.Neo4jTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Neo4j配置
 * Created by Carter Peng 2018/10/14
 */
@Configuration
// Repository包目录，SDN会扫描这个包
@EnableNeo4jRepositories(basePackages = "cn.edu.uestc.aone.web.helloworld.dao.neo4j")
// 打开Neo4j事务
@EnableTransactionManagement
public class Neo4jConfig {
	// URI
	@Value("#{configure['neo4j.uri']}")
	private String uri;

	// 用户名
	@Value("#{configure['neo4j.username']}")
	private String username;

	// 密码
	@Value("#{configure['neo4j.password']}")
	private String password;

	// Neo4j持久化对象所在的包
	@Value("#{configure['neo4j.packages']}")
	private String packages;

	/**
	 * SessionFactory配置
	 * @return SessionFactory
	 */
	@Bean
	public SessionFactory sessionFactory() {
		return new SessionFactory(configuration(), this.packages);
	}

	/**
	 * 基本的配置项，包括URI（地址、端口）、用户名和密码等
	 * @return
	 */
	@Bean
	public org.neo4j.ogm.config.Configuration configuration() {
		org.neo4j.ogm.config.Configuration configuration = new org.neo4j.ogm.config.Configuration.Builder()
				.uri(this.uri).credentials(this.username, this.password).build();
		return configuration;
	}

	/**
	 * 配置Neo4jTransactionManager
	 * @return Neo4jTransactionManager
	 */
	@Bean
	public Neo4jTransactionManager transactionManager() {
		return new Neo4jTransactionManager(sessionFactory());
	}
}
