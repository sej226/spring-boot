package com.boot.vo;

import java.sql.Date;

public class trans {
	private int transPK;
	private int DW;
	private String moeny;
	private Date transDate;
	
	public trans() {}
	
	public trans(int transPK, int dW, String moeny, Date transDate) {
		super();
		this.transPK = transPK;
		DW = dW;
		this.moeny = moeny;
		this.transDate = transDate;
	}
	
	public int getTransPK() {
		return transPK;
	}
	public void setTransPK(int transPK) {
		this.transPK = transPK;
	}
	public int getDW() {
		return DW;
	}
	public void setDW(int dW) {
		DW = dW;
	}
	public String getMoeny() {
		return moeny;
	}
	public void setMoeny(String moeny) {
		this.moeny = moeny;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	@Override
	public String toString() {
		return "trans [transPK=" + transPK + ", DW=" + DW + ", moeny=" + moeny + ", transDate=" + transDate + "]";
	}
	
	
}
