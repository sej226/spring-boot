package com.boot.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boot.dao.HumorDAO;
import com.boot.vo.Humor;

@Repository
public class HumorDAOImpl implements HumorDAO{
	
	private String ns ="com.boot.dao.HumorDAO.";
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public boolean addHumor(Humor humor) {
		int rows = sqlSession.insert(ns+"addHumor", humor);
		if(rows <= 0) return false;
		return true;
	}

	@Override
	public boolean deleteHumor(int humorPK) {
		int rows = sqlSession.delete(ns+"deleteHumor", humorPK);
		if(rows <= 0) return false;
		return true;
	}

	@Override
	public boolean updateHumor(Humor humor) {
		int rows = sqlSession.update(ns+"updateHumor", humor);
		if(rows <= 0) return false;
		return true;
	}

	@Override
	public List<Humor> selectAllHumor() {
		return sqlSession.selectList(ns + "selectAllHumor");
	}

	@Override
	public List<Humor> selectHumorByID(String id) {
		return sqlSession.selectList(ns+"selectHumorByID", id);
	}

	@Override
	public List<Humor> selectHumorByTitle(String title) {
		return sqlSession.selectList(ns+"selectHumorByTitle", title);
	}

	@Override
	public List<Humor> selectHumorByContent(String content) {
		return sqlSession.selectList(ns+"selectHumorByContent", content);
	}

	@Override
	public Humor selectHumorByNum(int humorPK) {
		return sqlSession.selectOne(ns+"selectHumorByNum", humorPK);
	}

	@Override
	public List<Humor> selectHumorByToday() {
		return sqlSession.selectList(ns+"selectHumorByToday");
	}

	@Override
	public List<Humor> selectHumorByRank() {
		return sqlSession.selectList(ns+"selectHumorByRank");
	}

}
