package com.boot.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boot.dao.MemberDAO;
import com.boot.vo.Member;

@Repository
public class MemberDAOImpl implements MemberDAO{

	private String ns ="com.boot.dao.MemberDAO.";
	
	@Autowired
	private SqlSession sqlSession;
	
	
	@Override
	public boolean addMember(Member member) throws Exception{
		int rows = sqlSession.insert(ns+"addMember", member);
		if(rows <= 0) return false;
		return true;
	}

	@Override
	public boolean deleteMember(String id) throws Exception{
		int rows = sqlSession.delete(ns+"deleteMember", id);
		if(rows <= 0) return false;
		return true;
	}

	@Override
	public boolean updateMember(Member member) throws Exception{
		int rows = sqlSession.update(ns+"updateMember", member);
		if(rows <= 0) return false;
		return true;
	}

	@Override
	public List<Member> selectAllMember() throws Exception{
		return sqlSession.selectList(ns+"selectAllMember");
	}

	@Override
	public Member selectMemberByID(String id) throws Exception{
		return sqlSession.selectOne(ns+"selectMemberByID", id);
	}

	@Override
	public List<Member> selectHumorByName(String name) throws Exception{
		return sqlSession.selectList(ns+"selectHumorByName", name);
	}

	@Override
	public List<Member> selectHumorByGrade(String grade) throws Exception{
		return sqlSession.selectList(ns+"selectHumorByGrade", grade);
	}

}
