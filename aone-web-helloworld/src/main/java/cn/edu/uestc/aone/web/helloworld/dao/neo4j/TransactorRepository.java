package cn.edu.uestc.aone.web.helloworld.dao.neo4j;

import cn.edu.uestc.aone.web.helloworld.model.po.neo4j.Transactor;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 处理Transactor数据的Neo4j Repository
 * Created by Carter Peng 2018/10/14
 */
@Repository
@Transactional
public interface TransactorRepository extends Neo4jRepository<Transactor, Long> {

	/**
	 * 查询关联某个Item的Transactor
	 * @param itemId
	 * @return List<Transactor>
	 */
	// 查询语句（可选）
	@Query("MATCH (:Item {rid: {itemId}})-[:START]->(:Step)-[:NEXT*0..]->(:Step)<-[:TRANSACT]-(transactor:Transactor)\n" +
			"RETURN transactor")
	List<Transactor> getTransactorByItemId(@Param("itemId") Long itemId);
}
