package com.boot.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boot.dao.TransDAO;
import com.boot.vo.Trans;

@Repository
public class TransDAOImpl implements TransDAO{
	
	private String ns ="com.boot.dao.TransDAO.";
	
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public boolean addTrans(Trans trans) {
		int rows = sqlSession.insert(ns+"addTrans", trans);
		if(rows <= 0) return false;
		return true;
	}

	@Override
	public boolean deleteTrans(int transPK) {
		int rows = sqlSession.delete(ns+"deleteTrans", transPK);
		if(rows <= 0) return false;
		return true;
	}

	@Override
	public List<Trans> selectAllTrans() {
		return sqlSession.selectList(ns+"selectAllTrans");
	}

	@Override
	public List<Trans> selectTransByDeposit(boolean DW) {
		return sqlSession.selectList(ns+"selectTransByDeposit", DW);
	}

	@Override
	public List<Trans> selectTransByWithdraw(boolean DW) {
		return sqlSession.selectList(ns+"selectTransByWithdraw", DW);
	}

}
