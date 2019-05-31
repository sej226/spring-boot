package com.boot.dao;

import java.util.List;

import com.boot.vo.Trans;

public interface TransDAO {
	public boolean addTrans(Trans trans);
	public boolean deleteTrans(int transPK);
	public List<Trans> selectAllTrans();
	public List<Trans> selectTransByDeposit(boolean DW); // 입금으로 검색
	public List<Trans> selectTransByWithdraw(boolean DW); // 출금으로 검색
}
