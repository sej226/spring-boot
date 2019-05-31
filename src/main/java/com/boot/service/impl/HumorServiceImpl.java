package com.boot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.boot.dao.HumorDAO;
import com.boot.dao.impl.HumorDAOImpl;
import com.boot.service.HumorService;
import com.boot.vo.Humor;

@Service
public class HumorServiceImpl implements HumorService {

	@Autowired
	HumorDAO  humorDAO ;
	
	@Override
	public boolean addHumor(Humor humor) throws Exception{
		return humorDAO.addHumor(humor);
	}

	@Override
	public boolean deleteHumor(int humorPK) throws Exception{
		return humorDAO.deleteHumor(humorPK);
	}

	@Override
	public boolean updateHumor(Humor humor) throws Exception{
		return humorDAO.updateHumor(humor);
	}

	@Override
	public List<Humor> selectAllHumor() throws Exception{
		return humorDAO.selectAllHumor();
	}

	@Override
	public List<Humor> selectHumorByID(String id) throws Exception{
		return humorDAO.selectHumorByID(id);
	}

	@Override
	public List<Humor> selectHumorByTitle(String title) throws Exception{
		return humorDAO.selectHumorByTitle(title);
	}

	@Override
	public List<Humor> selectHumorByContent(String content) throws Exception{
		return humorDAO.selectHumorByContent(content);
	}

	@Override
	public Humor selectHumorByNum(int humorPK) throws Exception{
		return humorDAO.selectHumorByNum(humorPK);
	}

	@Override
	public List<Humor> selectHumorByToday() throws Exception{
		return humorDAO.selectHumorByToday();
	}

	@Override
	public List<Humor> selectHumorByRank() throws Exception{
		return humorDAO.selectHumorByRank();
	}

}
