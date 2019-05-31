package com.boot.dao;

import com.boot.vo.Member;

public interface MemberDAO {
	public void addMember(Member member);
	public void deleteMember();
	public void updateMember(Member member);
	public void selectAllMember(); // 전체 검색
	public void selectMemberByID(String id); // 아이디로 검색
	public void selectHumorByName(String name); // 이름으로 검색
	public void selectHumorByGrade(String grade); // 등급으로 검색
}
