package org.amigo.app.model;

import java.util.*;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao {

	@Autowired
	SqlSessionTemplate template;
	
	public boolean JoinAdd(Map map) {
		template.insert("join.add", map);
		template.insert("join.add2", map);
		return true;
	}
	
	public HashMap readOne(Map map) {
		return template.selectOne("join.checkByIdmailandPass", map);
	}
	
	public Map checkId(String id) {
		
		return template.selectOne("join.checkId", id);
	}
	
	public Map checkEmail(String email) {
		
		return template.selectOne("join.checkEmail", email);
	}
}
