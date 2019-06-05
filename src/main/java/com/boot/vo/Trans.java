package com.boot.vo;

import java.sql.Date;

public class Trans {
	private int transPK;
	private int dw;
	private String money;
	private Date transDate;
	private int sum;
	
	public Trans() {}
	
	public Trans(int transPK, int dw, String moeny, int sum) {
		super();
		this.transPK = transPK;
		this.dw = dw;
		this.money = moeny;
		this.sum = sum;
	}
	
	public Trans(int transPK, int dw, String moeny, Date transDate, int sum) {
		super();
		this.transPK = transPK;
		this.dw = dw;
		this.money = moeny;
		this.transDate = transDate;
		this.sum = sum;
	}
	
	public int getTransPK() {
		return transPK;
	}
	public void setTransPK(int transPK) {
		this.transPK = transPK;
	}
	public int getDw() {
		return dw;
	}
	public void setDw(int dw) {
		this.dw = dw;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public Date getTransDate() {
		return transDate;
	}
	public void setTransDate(Date transDate) {
		this.transDate = transDate;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	@Override
	public String toString() {
		return "trans [transPK=" + transPK + ", dw=" + dw + ", money=" + money + ", transDate=" + transDate + "]";
	}
	
	
}
