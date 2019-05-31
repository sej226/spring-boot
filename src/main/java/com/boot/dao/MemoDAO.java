package com.boot.dao;

import java.util.List;

import com.boot.vo.Memo;

public interface MemoDAO {
	public boolean sendMemo(Memo memo); // 메시지 보내기
	public boolean deleteMemo(int memoPK);  // 보고 닫는 순간 삭제
	public List<Memo> selectMemoByReceiverID(String id); // 수신인으로 검색
	public Memo selectMemoByMemoPK(int memoPK); // PK로 검색
}
