package com.boot.vo;

import java.sql.Date;

public class Humorreply {
	private int humorReplyPK;
	private int humorPK;
	private String humorReplyID;
	private String humorReplyContent;
	private Date humorReplyDate;
	
	public Humorreply() {}
	
	public Humorreply(int humorReplyPK, int humorPK, String humorReplyID, String humorReplyContent) {
		super();
		this.humorReplyPK = humorReplyPK;
		this.humorPK = humorPK;
		this.humorReplyID = humorReplyID;
		this.humorReplyContent = humorReplyContent;
	}
	
	public Humorreply(int humorReplyPK, int humorPK, String humorReplyID, String humorReplyContent,
			Date humorReplyDate) {
		super();
		this.humorReplyPK = humorReplyPK;
		this.humorPK = humorPK;
		this.humorReplyID = humorReplyID;
		this.humorReplyContent = humorReplyContent;
		this.humorReplyDate = humorReplyDate;
	}
	
	public int getHumorReplyPK() {
		return humorReplyPK;
	}
	
	public void setHumorReplyPK(int humorReplyPK) {
		this.humorReplyPK = humorReplyPK;
	}
	
	public int getHumorPK() {
		return humorPK;
	}
	public void setHumorPK(int humorPK) {
		this.humorPK = humorPK;
	}
	
	public String getHumorReplyID() {
		return humorReplyID;
	}
	
	public void setHumorReplyID(String humorReplyID) {
		this.humorReplyID = humorReplyID;
	}
	public String getHumorReplyContent() {
		return humorReplyContent;
	}
	
	public void setHumorReplyContent(String humorReplyContent) {
		this.humorReplyContent = humorReplyContent;
	}
	
	public Date getHumorReplyDate() {
		return humorReplyDate;
	}
	
	public void setHumorReplyDate(Date humorReplyDate) {
		this.humorReplyDate = humorReplyDate;
	}
	
	@Override
	public String toString() {
		return "humorreply [humorReplyPK=" + humorReplyPK + ", humorPK=" + humorPK + ", humorReplyID=" + humorReplyID
				+ ", humorReplyContent=" + humorReplyContent + ", humorReplyDate=" + humorReplyDate + "]";
	}
	
	
}
