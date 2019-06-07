package com.boot.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		int sum = 0;
		List<Trans> transList = transService.selectAllTrans();
		
		for(Trans money : transList) {
			if(money.getDw() == 0) { // 입금
				sum += Integer.parseInt(money.getMoney());
				System.out.println(sum+"0");
			}
			if(money.getDw() == 1) { // 출금
				sum -= Integer.parseInt(money.getMoney());
				System.out.println(sum+"1");
			}
		}
		logger.info("1. -------------addTrans-------------"+sum+" : "+new Date());
		BoolResult nr = new BoolResult();
		
		if(trans.getDw() == 1 && sum < Integer.parseInt(trans.getMoney())) { // 출금일때 출금금액이 가지고 있는 돈보다 크면 오류
			nr.setCount(false);
			nr.setName("addTrans");
			nr.setMessage("전체 금액보다 출금 금액이 더 많습니다.");
			nr.setState("fail");
			return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
		}
		
		boolean total = transService.addTrans(trans);
	
		nr.setCount(total);
		nr.setName("addTrans");
		nr.setState("succ");
		if(!total) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<Trans>> allTrans() throws Exception{
		logger.info("1. -------------allTrans------------- : "+new Date());
		
		List<Trans> trans = transService.selectAllTrans();
		int sum = 0;
		for(Trans money : trans) {
			if(money.getDw() == 0) { // 입금
				sum += Integer.parseInt(money.getMoney());
			}
			if(money.getDw() == 1) { // 출금
				sum -= Integer.parseInt(money.getMoney());
			}
		}
		
		for(int i = 0; i < trans.size(); i++) {
			trans.get(i).setSum(sum);
		}
		
		if (trans.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Trans>>(trans, HttpStatus.OK);
	}

	@RequestMapping(value = "/deposit", method = RequestMethod.GET)
	public ResponseEntity<List<Trans>> selectTransByDeposit() throws Exception{
		logger.info("1. -------------selectTransByDeposit------------- : "+new Date());
		
		List<Trans> trans = transService.selectTransByDeposit(0);
		int sum = 0;
		for(Trans money : trans) {
			if(money.getDw() == 0) { // 입금
				sum += Integer.parseInt(money.getMoney());
			}
		}
		
		for(int i = 0; i < trans.size(); i++) {
			trans.get(i).setSum(sum);
		}
		
		if (trans.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Trans>>(trans, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	public ResponseEntity<List<Trans>> selectTransByWithdraw() throws Exception{
		logger.info("1. -------------selectTransByWithdraw------------- : "+new Date());
		
		List<Trans> trans = transService.selectTransByWithdraw(1);
		int sum = 0;
		for(Trans money : trans) {
			if(money.getDw() == 1) { // 출금
				sum += Integer.parseInt(money.getMoney());
			}
		}
		
		for(int i = 0; i < trans.size(); i++) {
			trans.get(i).setSum(sum);
		}
		
		if (trans.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Trans>>(trans, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/delete/{transPK}", method = RequestMethod.DELETE)
	public ResponseEntity<BoolResult> deleteTrans(@PathVariable int transPK) throws Exception{
		logger.info("1. -------------deleteTrans------------- : "+transPK+" "+new Date());

		boolean total = transService.deleteTrans(transPK);

		BoolResult nr = new BoolResult();
	
		nr.setCount(total);
		nr.setName("deleteTrans");
		nr.setState("succ");
		if(!total) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public  String login(HttpSession session) throws Exception{
		logger.info("1. -------------login------------- : "+new Date());
		session.setAttribute("user", "hihi");
		return "testtest";
	}
	
}

/*
 * public boolean addTrans(Trans trans) throws Exception;
	public boolean deleteTrans(int transPK) throws Exception;
	public List<Trans> selectAllTrans() throws Exception;
	public List<Trans> selectTransByDeposit(boolean DW) throws Exception; // 입금으로 검색
	public List<Trans> selectTransByWithdraw(boolean DW) throws Exception; // 출금으로 검색
 */