package com.boot.dao;

import java.util.List;

import com.boot.vo.Member;

public interface MemberDAO {
	public boolean addMember(Member member);
	public boolean deleteMember(String id);
	public boolean updateMember(Member member);
	public List<Member> selectAllMember(); // 전체 검색
	public Member selectMemberByID(String id); // 아이디로 검색
	public List<Member> selectHumorByName(String name); // 이름으로 검색
	public List<Member> selectHumorByGrade(String grade); // 등급으로 검색
}
