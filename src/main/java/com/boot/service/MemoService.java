package com.boot.service;

import java.util.List;

import com.boot.vo.Memo;

public interface MemoService {
	public boolean sendMemo(Memo memo) throws Exception; // 메시지 보내기
	public boolean deleteMemo(int memoPK) throws Exception;  // 보고 닫는 순간 삭제
	public List<Memo> selectMemoByReceiverID(String id) throws Exception; // 수신인으로 검색
	public Memo selectMemoByMemoPK(int memoPK) throws Exception; // PK로 검색
}
