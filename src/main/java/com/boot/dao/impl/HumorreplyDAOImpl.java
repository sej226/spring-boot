package com.boot.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boot.dao.HumorreplyDAO;
import com.boot.vo.Humorreply;

@Repository
public class HumorreplyDAOImpl implements HumorreplyDAO{
	
	private String ns ="com.boot.dao.HumorreplyDAO.";
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public boolean addHumorReply(Humorreply humorreply) {
		int rows = sqlSession.insert(ns+"addHumorReply", humorreply);
		if(rows <= 0) return false;
		return true;
	}

	@Override
	public boolean deleteHumorReply(int humorReplyPK) {
		int rows = sqlSession.delete(ns+"deleteHumorReply", humorReplyPK);
		if(rows <= 0) return false;
		return true;
	}

	@Override
	public boolean updateHumorReply(Humorreply humorreply) {
		int rows = sqlSession.update(ns+"updateHumorReply", humorreply);
		if(rows <= 0) return false;
		return true;
	}

	@Override
	public List<Humorreply> selectAllHumorReply() {
		return sqlSession.selectList(ns+"selectAllHumorReply");
	}
}
