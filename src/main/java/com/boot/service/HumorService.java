package com.boot.service;

import java.util.List;

import com.boot.vo.Humor;

public interface HumorService {
	public boolean addHumor(Humor humor) throws Exception;
	public boolean deleteHumor(int humorPK) throws Exception;
	public boolean updateHumor(Humor humor) throws Exception;
	public List<Humor> selectAllHumor() throws Exception; // 전체 검색
	public List<Humor> selectHumorByID(String id) throws Exception; // 아이디로 검색
	public List<Humor> selectHumorByTitle(String title) throws Exception; // 제목으로 검색
	public List<Humor> selectHumorByContent(String content) throws Exception; // 내용으로 검색
	public Humor selectHumorByNum(int humorPK) throws Exception;	// 게시글 번호로 검색, 세부사항
	public List<Humor> selectHumorByToday() throws Exception; // 오늘 작성된 게시글 검색
	public List<Humor> selectHumorByRank() throws Exception; // 조회수 높은 게시글
}
