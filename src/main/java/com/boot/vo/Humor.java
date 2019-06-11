package com.boot.vo;

import java.sql.Date;

public class Humor {
	private int humorPK;
	private String humorID;
	private String humorTitle;
	private String humorContent;
	private Date humorDate;
	private int humorCount;
	private String humorImgURL;
	private boolean anonymous;
	
	public Humor() {}
	
	public Humor(int humorPK, String humorID, String humorTitle, String humorContent,int humorCount,
			String humorImgURL) {
		super();
		this.humorPK = humorPK;
		this.humorID = humorID;
		this.humorTitle = humorTitle;
		this.humorContent = humorContent;
		this.humorCount = humorCount;
		this.humorImgURL = humorImgURL;
	}
	
 
	public Humor(int humorPK, String humorID, String humorTitle, String humorContent, Date humorDate, int humorCount,
			String humorImgURL, boolean anonymous) {
		super();
		this.humorPK = humorPK;
		this.humorID = humorID;
		this.humorTitle = humorTitle;
		this.humorContent = humorContent;
		this.humorDate = humorDate;
		this.humorCount = humorCount;
		this.humorImgURL = humorImgURL;
		this.anonymous = anonymous;
	}

	public int getHumorPK() {
		return humorPK;
	}


	public void setHumorPK(int humorPK) {
		this.humorPK = humorPK;
	}


	public String getHumorID() {
		return humorID;
	}


	public void setHumorID(String humorID) {
		this.humorID = humorID;
	}


	public String getHumorTitle() {
		return humorTitle;
	}


	public void setHumorTitle(String humorTitle) {
		this.humorTitle = humorTitle;
	}


	public String getHumorContent() {
		return humorContent;
	}


	public void setHumorContent(String humorContent) {
		this.humorContent = humorContent;
	}


	public Date getHumorDate() {
		return humorDate;
	}


	public void setHumorDate(Date humorDate) {
		this.humorDate = humorDate;
	}


	public int getHumorCount() {
		return humorCount;
	}


	public void setHumorCount(int humorCount) {
		this.humorCount = humorCount;
	}


	public String getHumorImgURL() {
		return humorImgURL;
	}
	

	public void setHumorImgURL(String humorImgURL) {
		this.humorImgURL = humorImgURL;
	}

	public boolean isAnonymous() {
		return anonymous;
	}

	
	 
	public void setAnonymous(boolean anonymous) {
		this.anonymous = anonymous;
	}

	@Override
	public String toString() {
		return "Humor [humorPK=" + humorPK + ", humorID=" + humorID + ", humorTitle=" + humorTitle + ", humorContent="
				+ humorContent + ", humorDate=" + humorDate + ", humorCount=" + humorCount + ", humorImgURL="
				+ humorImgURL + ", anonymous=" + anonymous + "]";
	}
	
	
}


