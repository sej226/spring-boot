package com.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.HumorDAO;
import com.boot.dao.HumorreplyDAO;
import com.boot.service.HumorService;
import com.boot.service.HumorreplyService;
import com.boot.vo.Humorreply;

@Service
public class HumorreplyServiceImpl implements HumorreplyService {
	@Autowired
	HumorreplyDAO humorreplyDAO; 
	
	@Override
	public boolean addHumorReply(Humorreply humorreply) throws Exception{
		return humorreplyDAO.addHumorReply(humorreply);
	}

	@Override
	public boolean deleteHumorReply(int humorReplyPK) throws Exception{
		return humorreplyDAO.deleteHumorReply(humorReplyPK);
	}

	@Override
	public boolean updateHumorReply(Humorreply humorreply) throws Exception{
		return humorreplyDAO.updateHumorReply(humorreply);
	}

	@Override
	public List<Humorreply> selectAllHumorReply() throws Exception{
		return humorreplyDAO.selectAllHumorReply();
	}

	@Override
	public List<Humorreply> selectAllHumorReplyByNum(int pk) throws Exception {
		return humorreplyDAO.selectAllHumorReplyByNum(pk);
	}

	@Override
	public Humorreply selectOneHumorReply(int humorReplyPK) throws Exception {
		return humorreplyDAO.selectOneHumorReply(humorReplyPK);
	}

}
