package com.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.MemberDAO;
import com.boot.service.MemberService;
import com.boot.vo.Member;

@Service
public class MemberServiceImpl implements MemberService{
	@Autowired
	MemberDAO memberDAO;
	
	@Override
	public boolean addMember(Member member) throws Exception {
		return memberDAO.addMember(member);
	}

	@Override
	public boolean deleteMember(String id) throws Exception {
		return memberDAO.deleteMember(id);
	}

	@Override
	public boolean updateMember(Member member) throws Exception {
		return memberDAO.updateMember(member);
	}

	@Override
	public List<Member> selectAllMember() throws Exception {
		return memberDAO.selectAllMember();
	}

	@Override
	public Member selectMemberByID(String id) throws Exception {
		return memberDAO.selectMemberByID(id);
	}

	@Override
	public List<Member> selectHumorByName(String name) throws Exception {
		return memberDAO.selectHumorByName(name);
	}

	@Override
	public List<Member> selectHumorByGrade(String grade) throws Exception {
		return memberDAO.selectHumorByGrade(grade);
	}

}
