package com.boot.service;

import java.util.List;

import com.boot.vo.Humorreply;

public interface HumorreplyService {
	public boolean addHumorReply(Humorreply humorreply)throws Exception;
	public boolean deleteHumorReply(int humorReplyPK) throws Exception;
	public boolean updateHumorReply(Humorreply humorreply) throws Exception;
	public List<Humorreply> selectAllHumorReply() throws Exception;
	public List<Humorreply> selectAllHumorReplyByNum(int pk) throws Exception;
	public Humorreply selectOneHumorReply(int humorReplyPK) throws Exception;
}
