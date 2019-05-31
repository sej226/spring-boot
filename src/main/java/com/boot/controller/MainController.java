package com.boot.controller;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.boot.service.HumorService;
import com.boot.vo.BoolResult;
import com.boot.vo.Humor;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@Controller
@RequestMapping("/api")
public class MainController {
	public static final Logger logger = LoggerFactory.getLogger(MainController.class);
	
	@Autowired
	private HumorService  humorService;

	@RequestMapping(value = "/addHumor", method = RequestMethod.POST)
	public ResponseEntity<BoolResult> addHumor(@RequestBody Humor humor) throws Exception {
		logger.info("1. -------------addHumor-------------"+humor+" : "+new Date());

		boolean total = humorService.addHumor(humor);
		BoolResult nr = new BoolResult();
		nr.setCount(total);
		nr.setName("addHumor");
		nr.setState("success");
		if (!total) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/selectAllHumor", method = RequestMethod.GET)
	public ResponseEntity<List<Humor>> selectAllHumor() throws Exception {
		logger.info("1.-------------selectAllHumor-------------"+new Date());
		List<Humor> humors = humorService.selectAllHumor();
		if (humors.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Humor>>(humors, HttpStatus.OK);
	}
	
	/*
	@RequestMapping(value = "/deleteQnA/{qnaPK}/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<BoolResult> deleteQnA(@PathVariable int qnaPK, @PathVariable String id) throws Exception {
		logger.info("1. -------------deleteQnA-----------------------------"+new Date());
		logger.info("1. -------------deleteQnA-----------------------------"+qnaPK);
		logger.info("1. -------------deleteQnA-----------------------------"+id);
		QnA qna = qnaService.findQnAByPk(qnaPK);
		System.out.println(qna);
		boolean total = true;
		BoolResult nr = new BoolResult();
		if(qna.getId().equals(id) && id.equals("admin")) {
			total = qnaService.deleteQnA(qnaPK);
			nr.setCount(total);
			nr.setName("deleteQnA");
			nr.setState("succ");
		}else {
			nr.setCount(total);
			nr.setName("deleteQnA");
			nr.setState("false");
		}
		
		if (!total) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findAllQnA", method = RequestMethod.GET)
	public ResponseEntity<List<QnA>> findAllQnA() throws Exception {
		logger.info("1.-------------findAllQnA-----------------------------"+new Date());
		List<QnA> QnAs = qnaService.findAllQnA();
		if (QnAs.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<QnA>>(QnAs, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findQnAById/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<QnA>> findQnAById(@PathVariable String id) throws Exception {
		logger.info("1.-------------findQnAById-----------------------------"+new Date());
		List<QnA> QnAs = qnaService.findQnAById(id);
		if (QnAs.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<QnA>>(QnAs, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/findQnAByContentAndTitle/{keyword}", method = RequestMethod.GET)
	public ResponseEntity<List<QnA>> findQnAByContentAndTitle(@PathVariable String keyword) throws Exception {
		logger.info("1.-------------findQnAByContentAndTitle-----------------------------"+new Date());
		logger.info("1.-------------findQnAByContentAndTitle-----------------------------"+keyword);
		List<QnA> QnAs = qnaService.findQnAByContentAndTitle(keyword);
		System.out.println(keyword);
		if (QnAs.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<QnA>>(QnAs, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addAnswer", method = RequestMethod.PUT)
	public ResponseEntity<BoolResult> addAnswer(@RequestBody QnA qna) throws Exception {
		logger.info("1.-------------addAnswer-----------------------------"+new Date());
		logger.info("1.-------------addAnswer-----------------------------"+qna);
		boolean total = qnaService.addAnswer(qna);
		BoolResult nr = new BoolResult();
		nr.setCount(total);
		nr.setName("addAnswer");
		nr.setState("succ");
		if (!total) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/deleteAnswer", method = RequestMethod.PUT)
	public ResponseEntity<BoolResult> deleteAnswer(@RequestBody QnA qna) throws Exception {
		logger.info("1.-------------deleteAnswer-----------------------------"+new Date());
		boolean total = qnaService.deleteAnswer(qna);
		BoolResult nr = new BoolResult();
		nr.setCount(total);
		nr.setName("deleteAnswer");
		nr.setState("succ");
		if (!total) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<BoolResult>(nr, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/countQnA", method = RequestMethod.GET)
	public ResponseEntity<Integer> countQnA() throws Exception {
		logger.info("1.-------------countQnA-----------------------------"+new Date());
		Integer count = null;
		count = qnaService.countQnA();
		if (count == null) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Integer>(count, HttpStatus.OK);
	}*/
}
