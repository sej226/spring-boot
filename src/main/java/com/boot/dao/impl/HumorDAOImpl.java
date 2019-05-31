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
	private SqlSession sqlSession;
	
	@Override
	public boolean addHumor(Humor humor) throws Exception{
		int rows = sqlSession.insert(ns+"addHumor", humor);
		if(rows <= 0) return false;
		return true;
	}

	@Override
	public boolean deleteHumor(int humorPK) throws Exception{
		int rows = sqlSession.delete(ns+"deleteHumor", humorPK);
		if(rows <= 0) return false;
		return true;
	}

	@Override
	public boolean updateHumor(Humor humor) throws Exception{
		int rows = sqlSession.update(ns+"updateHumor", humor);
		if(rows <= 0) return false;
		return true;
	}

	@Override
	public List<Humor> selectAllHumor() throws Exception{
		return sqlSession.selectList(ns + "selectAllHumor");
	}

	@Override
	public List<Humor> selectHumorByID(String id) throws Exception{
		return sqlSession.selectList(ns+"selectHumorByID", id);
	}

	@Override
	public List<Humor> selectHumorByTitle(String title) throws Exception{
		return sqlSession.selectList(ns+"selectHumorByTitle", title);
	}

	@Override
	public List<Humor> selectHumorByContent(String content) throws Exception{
		return sqlSession.selectList(ns+"selectHumorByContent", content);
	}

	@Override
	public Humor selectHumorByNum(int humorPK) throws Exception{
		return sqlSession.selectOne(ns+"selectHumorByNum", humorPK);
	}

	@Override
	public List<Humor> selectHumorByToday() throws Exception{
		return sqlSession.selectList(ns+"selectHumorByToday");
	}

	@Override
	public List<Humor> selectHumorByRank() throws Exception{
		return sqlSession.selectList(ns+"selectHumorByRank");
	}

}
