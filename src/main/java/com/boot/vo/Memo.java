package com.boot.vo;

import java.sql.Date;

public class Memo {
	private String memoPK;
	private String receiverID;
	private String senderID;
	private String memoTitle;
	private String memoContent;
	private Date memoDate;
	
	public Memo() {}
	
	public Memo(String memoPK, String receiverID, String senderID, String memoTitle, String memoContent,
			Date memoDate) {
		super();
		this.memoPK = memoPK;
		this.receiverID = receiverID;
		this.senderID = senderID;
		this.memoTitle = memoTitle;
		this.memoContent = memoContent;
		this.memoDate = memoDate;
	}

	public String getMemoPK() {
		return memoPK;
	}

	public void setMemoPK(String memoPK) {
		this.memoPK = memoPK;
	}

	public String getReceiverID() {
		return receiverID;
	}

	public void setReceiverID(String receiverID) {
		this.receiverID = receiverID;
	}

	public String getSenderID() {
		return senderID;
	}

	public void setSenderID(String senderID) {
		this.senderID = senderID;
	}

	public String getMemoTitle() {
		return memoTitle;
	}

	public void setMemoTitle(String memoTitle) {
		this.memoTitle = memoTitle;
	}

	public String getMemoContent() {
		return memoContent;
	}

	public void setMemoContent(String memoContent) {
		this.memoContent = memoContent;
	}

	public Date getMemoDate() {
		return memoDate;
	}

	public void setMemoDate(Date memoDate) {
		this.memoDate = memoDate;
	}

	@Override
	public String toString() {
		return "memo [memoPK=" + memoPK + ", receiverID=" + receiverID + ", senderID=" + senderID + ", memoTitle="
				+ memoTitle + ", memoContent=" + memoContent + ", memoDate=" + memoDate + "]";
	}
	
	
}
