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

import com.boot.service.MemberService;
import com.boot.service.MemoService;
import com.boot.vo.BoolResult;
import com.boot.vo.Humor;
import com.boot.vo.Member;
import com.boot.vo.Memo;

@Controller
@RequestMapping("/memo")
public class MemoController {
public static final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemoService  memoService;
	
	@RequestMapping(value = "/memo", method = RequestMethod.GET)
	public String memo() throws Exception {
		return "memoForm";
	}
	
	@RequestMapping(value = "/mymemo", method = RequestMethod.GET)
	public String mymemo() throws Exception {
		return "MyMemo";
	}
	
	@RequestMapping(value = "/send", method = RequestMethod.POST)
	public ResponseEntity<BoolResult> sendMemo(@RequestBody Memo memo, HttpSession session) throws Exception {
		logger.info("1. -------------sendMemo-------------"+memo+" : "+new Date());

		Member member = (Member) session.getAttribute("member");
		memo.setSenderID(member.getId());  
		boolean total = memoService.sendMemo(memo);
		BoolResult nr = new BoolResult();
		nr.setCount(total);
		nr.setName("sendMemo");
		nr.setState("succ");
		if (!total) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{memoPK}", method = RequestMethod.DELETE)
	public ResponseEntity<BoolResult> deleteMemo(@PathVariable int memoPK) throws Exception {
		logger.info("1. -------------deleteMemo-------------"+memoPK+" : "+new Date());

		boolean total = memoService.deleteMemo(memoPK);
		BoolResult nr = new BoolResult();
		nr.setCount(total);
		nr.setName("deleteMemo");
		nr.setState("succ");
		if (!total) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
	}

	@RequestMapping(value = "/selectID", method = RequestMethod.GET)
	public ResponseEntity<List<Memo>> selectID(HttpSession session) throws Exception {
		logger.info("1. -------------selectID------------- : "+new Date());
		Member member = (Member) session.getAttribute("member");
		List<Memo> memos = memoService.selectMemoByReceiverID(member.getId());

	      if (memos.isEmpty()) {
	         return new ResponseEntity(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<List<Memo>>(memos, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/selectID/{memoPK}", method = RequestMethod.GET)
	public ResponseEntity<Memo> selectPK(@PathVariable int memoPK) throws Exception {
		logger.info("1. -------------selectPK-------------"+memoPK+" : "+new Date());
		Memo memo = memoService.selectMemoByMemoPK(memoPK);
		if (memo == null) {
	         return new ResponseEntity(HttpStatus.NO_CONTENT);
	      }
	      return new ResponseEntity<Memo>(memo, HttpStatus.OK);
	}
}
