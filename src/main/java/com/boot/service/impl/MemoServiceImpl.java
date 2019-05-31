package com.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.MemoDAO;
import com.boot.service.MemoService;
import com.boot.vo.Memo;

@Service
public class MemoServiceImpl implements MemoService {
	@Autowired
	MemoDAO memoDAO;
	
	@Override
	public boolean sendMemo(Memo memo) throws Exception{
		return memoDAO.sendMemo(memo);
	}

	@Override
	public boolean deleteMemo(int memoPK) throws Exception{
		return memoDAO.deleteMemo(memoPK);
	}

	@Override
	public List<Memo> selectMemoByReceiverID(String id) throws Exception{
		return memoDAO.selectMemoByReceiverID(id);
	}

	@Override
	public Memo selectMemoByMemoPK(int memoPK) throws Exception{
		return memoDAO.selectMemoByMemoPK(memoPK);
	}

}
