package com.boot.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boot.dao.MemoDAO;
import com.boot.vo.Memo;

@Repository
public class MemoDAOImpl implements MemoDAO{
	
	private String ns ="com.boot.dao.MemoDAO.";
	
	@Autowired
	SqlSession sqlSession;

	@Override
	public boolean sendMemo(Memo memo) throws Exception{
		int rows = sqlSession.insert(ns+"sendMemo", memo);
		if(rows <= 0) return false;
		return true;
	}

	@Override
	public boolean deleteMemo(int memoPK) throws Exception{
		int rows = sqlSession.delete(ns+"deleteMemo", memoPK);
		if(rows <= 0) return false;
		return true;
	}

	@Override
	public List<Memo> selectMemoByReceiverID(String id) throws Exception{
		return sqlSession.selectList(ns+"selectMemoByReceiverID", id);
	}

	@Override
	public Memo selectMemoByMemoPK(int memoPK) throws Exception{
		return sqlSession.selectOne(ns+"selectMemoByMemoPK", memoPK);
	}
}
