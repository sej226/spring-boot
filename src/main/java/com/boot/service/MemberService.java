package com.boot.service;

import java.util.List;

import com.boot.vo.Member;

public interface MemberService {
	public boolean addMember(Member member) throws Exception;
	public boolean deleteMember(String id) throws Exception;
	public boolean updateMember(Member member) throws Exception;
	public List<Member> selectAllMember() throws Exception; // 전체 검색
	public Member selectMemberByID(String id) throws Exception; // 아이디로 검색
	public List<Member> selectHumorByName(String name) throws Exception; // 이름으로 검색
	public List<Member> selectHumorByGrade(String grade) throws Exception; // 등급으로 검색
}
