package com.boot.dao;

import java.util.List;

import com.boot.vo.Humor;

public interface HumorDAO {
	public boolean addHumor(Humor humor);
	public boolean deleteHumor(int humorPK);
	public boolean updateHumor(Humor humor);
	public List<Humor> selectAllHumor(); // 전체 검색
	public List<Humor> selectHumorByID(String id); // 아이디로 검색
	public List<Humor> selectHumorByTitle(String title); // 제목으로 검색
	public List<Humor> selectHumorByContent(String content); // 내용으로 검색
	public Humor selectHumorByNum(int humorPK);	// 게시글 번호로 검색, 세부사항
	public List<Humor> selectHumorByToday(); // 오늘 작성된 게시글 검색
	public List<Humor> selectHumorByRank(); // 조회수 높은 게시글
}
