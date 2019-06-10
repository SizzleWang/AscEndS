package cn.edu.uestc.aone.web.helloworld.model.po.neo4j;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;


/**
 * Neo4j的节点实体类： Transactor
 * Created by Carter Peng 2018/10/14
 */
@NodeEntity
public class Transactor {

	@Id
	@GeneratedValue
	private Long id;

	private Long rid;

	private String name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
