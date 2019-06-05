package com.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.TransDAO;
import com.boot.dao.impl.TransDAOImpl;
import com.boot.service.TransService;
import com.boot.vo.Trans;

@Service
public class TransServiceImpl implements TransService{
	@Autowired
	TransDAO transDAO;
	
	@Override
	public boolean addTrans(Trans trans) throws Exception{
		return transDAO.addTrans(trans);
	}

	@Override
	public boolean deleteTrans(int transPK) throws Exception{
		return transDAO.deleteTrans(transPK);
	}

	@Override
	public List<Trans> selectAllTrans() throws Exception{
		return transDAO.selectAllTrans();
	}

	@Override
	public List<Trans> selectTransByDeposit(int dw) throws Exception{
		return transDAO.selectTransByDeposit(dw);
	}

	@Override
	public List<Trans> selectTransByWithdraw(int dw) throws Exception{
		return transDAO.selectTransByWithdraw(dw);
	}

}
