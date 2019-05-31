package com.boot.dao;

import java.util.List;

import com.boot.vo.Trans;

public interface TransDAO {
	public boolean addTrans(Trans trans) throws Exception;
	public boolean deleteTrans(int transPK) throws Exception;
	public List<Trans> selectAllTrans() throws Exception;
	public List<Trans> selectTransByDeposit(boolean DW) throws Exception; // 입금으로 검색
	public List<Trans> selectTransByWithdraw(boolean DW) throws Exception; // 출금으로 검색
}
