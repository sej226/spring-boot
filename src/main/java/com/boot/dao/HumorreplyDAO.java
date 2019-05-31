package com.boot.dao;

import java.util.List;

import com.boot.vo.Humorreply;

public interface HumorreplyDAO {
	public boolean addHumorReply(Humorreply humorreply);
	public boolean deleteHumorReply(int humorReplyPK);
	public boolean updateHumorReply(Humorreply humorreply);
	public List<Humorreply> selectAllHumorReply();
}
