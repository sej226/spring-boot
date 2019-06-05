package com.boot.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boot.service.TransService;
import com.boot.vo.BoolResult;
import com.boot.vo.Trans;

@Controller
@RequestMapping(value = "/trans")
public class TransController {
	public static final Logger logger = LoggerFactory.getLogger(TransController.class);
	
	@Autowired
	private TransService transService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ResponseEntity<BoolResult> addTrans(@RequestBody Trans trans) throws Exception{
		logger.info("1. -------------addTrans-------------"+trans+" : "+new Date());
		
		boolean total = transService.addTrans(trans);
		BoolResult nr = new BoolResult();
		nr.setCount(total);
		nr.setName("addTrans");
		nr.setState("success");
		if(!total) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
	}
	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String test() throws Exception{
		logger.info("1. -------------test------------- : "+new Date());
		return "test2";
	}
}

/*
 * public boolean addTrans(Trans trans) throws Exception;
	public boolean deleteTrans(int transPK) throws Exception;
	public List<Trans> selectAllTrans() throws Exception;
	public List<Trans> selectTransByDeposit(boolean DW) throws Exception; // 입금으로 검색
	public List<Trans> selectTransByWithdraw(boolean DW) throws Exception; // 출금으로 검색
 */