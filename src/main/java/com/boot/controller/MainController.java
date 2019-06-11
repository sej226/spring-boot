package com.boot.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
import com.boot.service.HumorreplyService;
import com.boot.service.MemberService;
import com.boot.vo.BoolResult;
import com.boot.vo.Humor;
import com.boot.vo.Humorreply;
import com.boot.vo.Member;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@Controller
@RequestMapping("/api")
public class MainController {
   public static final Logger logger = LoggerFactory.getLogger(MainController.class);
   
   @Autowired
   private HumorService  humorService;
   
   @Autowired
   private HumorreplyService humorreplyService;
   
   @Autowired
   private MemberService memberService;

   @RequestMapping(value = "/selectAllHumor", method =  RequestMethod.GET)
   public ResponseEntity<List<Humor>> selectAllHumor() throws Exception {
      logger.info("-------------selectAllHumor-------------"+new Date());
      List<Humor> humors = humorService.selectAllHumor();
      System.out.println(humors);
      
      if (humors.isEmpty()) {
         return new ResponseEntity(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<List<Humor>>(humors, HttpStatus.OK);
   }
   
   @RequestMapping(value = "/selectHumorByNum/{humorPK}", method = RequestMethod.GET)
   public ResponseEntity<Humor> selectHumorByNum(@PathVariable int humorPK) throws Exception{
      logger.info("-------------selectHumorByNum!-------------"+new Date());
      Humor humor = humorService.selectHumorByNum(humorPK);
      System.out.println(humorPK);
      System.out.println("클린한고임 " + humor);
      if(humor == null) {
         return new ResponseEntity(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<Humor>(humor, HttpStatus.OK);
   }
   
   @RequestMapping(value = "/updateHumor", method = RequestMethod.POST)
   public void updateHumor(@RequestBody Humor humor) throws Exception{
      logger.info("-------------updateHumor-------------" + new Date());
      Humor h = humorService.selectHumorByNum(humor.getHumorPK());
      System.out.println(h);
      System.out.println(humor);
      boolean flag = humorService.updateHumor(humor);
      System.out.println(humor);
      if(!flag) {
         System.out.println("Empty!!!");
      }
   }
   
   @RequestMapping(value = "/deleteHumor/{humorPK}", method = RequestMethod.DELETE)
   public void deleteH(@PathVariable int humorPK) throws Exception {
      logger.info("-------------deleteHumor-----------------------------"+new Date());
      
      boolean flag = humorService.deleteHumor(humorPK);
      System.out.println(flag + "삭제 결과!");
   }
   
   @RequestMapping(value = "/createHumor", method = RequestMethod.POST)
   public void createA(@RequestBody Humor humor, HttpServletRequest request) throws Exception {
      logger.info("-------------create-----------------------------"+new Date());
      System.out.println(humor);
      /*if(humor.isAnonymous()) {
    	 humor.setHumorID(""); 
      }*/
      /*SimpleDateFormat format = new SimpleDateFormat ("yyyy-MM-dd");
      Date time = new Date();
      String time1 = format.format(time);
      System.out.println(time1);*/
//      humor.setHumorDate(Date);
      //
      HttpSession session = request.getSession();;
      Member member = (Member) session.getAttribute("member");
      System.out.println("@@@@@@@@@@@@@@@@@@@@");
      System.out.println(member);
      humor.setHumorID(member.getId());
      boolean flag= humorService.addHumor(humor);
   }
   
   @RequestMapping(value = "/selectHumor/{selected}", method =  RequestMethod.GET)
   public ResponseEntity<List<Humor>> selectHumor(@PathVariable String selected) throws Exception {
      logger.info("-------------selectHumor-------------"+new Date());
      System.out.println(selected + " 선택한거!");
      String[] select = selected.split("&");
//      for(int i = 0; i < select.length; i++)
//    	  System.out.println(select[i]);
      
      String[] inputStr = select[1].split("=");
//      for(int i = 0; i < inputStr.length; i++)
//    	  System.out.println(inputStr[i]);
      
      List<Humor> humors = null;
      if(select[0].equals("ID")) {
    	  humors = humorService.selectHumorByID(inputStr[1]);
    	  System.out.println(humors);
      }else  if(select[0].equals("TITLE"))  {
    	  humors = humorService.selectHumorByTitle(inputStr[1]);
    	  System.out.println(humors);
      }else if(select[0].equals("CONTENT")) {
    	  humors = humorService.selectHumorByContent(inputStr[1]);
      }
      
      if (humors.isEmpty()) {
         return new ResponseEntity(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<List<Humor>>(humors, HttpStatus.OK);
   }
   
   /*@RequestMapping(value = "/selectAllHumorReply", method =  RequestMethod.GET)
   public ResponseEntity<List<Humorreply>> selectAllHumorReply() throws Exception {
      logger.info("-------------selectAllHumorReply-------------"+new Date());
      List<Humorreply> humorReply = humorreplyService.selectAllHumorReply();
      System.out.println(humorReply);
      if (humorReply.isEmpty()) {
         return new ResponseEntity(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<List<Humorreply>>(humorReply, HttpStatus.OK);
   }*/
   
   @RequestMapping(value = "/selectAllHumorReplyByNum/{pk}", method =  RequestMethod.GET)
   public ResponseEntity<List<Humorreply>> selectAllHumorReplyByNum(@PathVariable int pk) throws Exception {
      logger.info("-------------selectAllHumorReplyByNum-------------"+new Date());
      List<Humorreply> humorReply = humorreplyService.selectAllHumorReplyByNum(pk);
      System.out.println(humorReply);
      if (humorReply.isEmpty()) {
         return new ResponseEntity(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<List<Humorreply>>(humorReply, HttpStatus.OK);
   }
   
   @RequestMapping(value = "/createReply", method = RequestMethod.POST)
   public void createReply(@RequestBody Humorreply humorreply, HttpServletRequest request) throws Exception {
      logger.info("-------------createReply-----------------------------"+new Date());
      System.out.println(humorreply);
      System.out.println(humorreply.getHumorReplyContent());
      HttpSession session = request.getSession();;
      Member member = (Member) session.getAttribute("member");
//      System.out.println("@@@@@@@@@@@@@@@@@@@@");
//      System.out.println(member);
      humorreply.setHumorReplyID(member.getId());
      boolean flag= humorreplyService.addHumorReply(humorreply);
   }
   
   @RequestMapping(value = "/updateHumorReply", method = RequestMethod.POST)
   public void updateHumorReply(@RequestBody Humorreply humorreply) throws Exception{
      logger.info("-------------updateHumorReply-------------" + new Date());
      System.out.println(humorreply);
      boolean flag = humorreplyService.updateHumorReply(humorreply);
      if(!flag) {
         System.out.println("Empty!!!");
      }
   }
   
   @RequestMapping(value = "/deleteHumorReply/{humorReplyPK}", method = RequestMethod.DELETE)
   public void deleteHumorReply(@PathVariable int humorReplyPK) throws Exception {
      logger.info("-------------deleteHumorReply-----------------------------"+new Date());
      
      boolean flag = humorreplyService.deleteHumorReply(humorReplyPK);
      System.out.println(flag + "삭제 결과!");
   }
   
   @RequestMapping(value = "/selectOneHumorReply/{humorReplyPK}", method = RequestMethod.GET)
   public ResponseEntity<Humorreply> selectOneHumorReply(@PathVariable int humorReplyPK) throws Exception{
      logger.info("-------------selectOneHumorReply-------------"+new Date());
      Humorreply humorreply = humorreplyService.selectOneHumorReply(humorReplyPK);
      if(humorreply == null) {
         return new ResponseEntity(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<Humorreply>(humorreply, HttpStatus.OK);
   }
   

   @RequestMapping(value = "/selectAllMember", method =  RequestMethod.GET)
   public ResponseEntity<List<Member>> selectAllMember() throws Exception {
      logger.info("-------------selectAllMember-------------"+new Date());
      List<Member> members = memberService.selectAllMember();
      System.out.println(members + " 관리자가 조회한 정보");
      if (members.isEmpty()) {
         return new ResponseEntity(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<List<Member>>(members, HttpStatus.OK);
   }
   
   @RequestMapping(value = "/selectMemberByID/{id}", method =  RequestMethod.GET)
   public ResponseEntity<Member> selectMemberByID(@PathVariable String id) throws Exception {
      logger.info("-------------selectMemberByID-------------"+new Date());
      Member member = memberService.selectMemberByID(id);
      System.out.println(member + " id로 조회한 정보");
      if (member == null) {
         return new ResponseEntity(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<Member>(member, HttpStatus.OK);
   }
   
   @RequestMapping(value = "/updateMember", method = RequestMethod.POST)
   public void updateMember(@RequestBody Member member) throws Exception{
      logger.info("-------------updateMember-------------" + new Date());
      Member mem = memberService.selectMemberByID(member.getId());
      System.out.println(member);
      boolean flag = memberService.updateMember(member);
      if(!flag) {
         System.out.println("Fail!!!");
      }
   }
   
   @RequestMapping(value = "/deleteMember/{id}", method = RequestMethod.DELETE)
   public void deleteMember(@PathVariable String id) throws Exception {
      logger.info("-------------deleteMember-----------------------------"+new Date());
      id += ".com";
      boolean flag = memberService.deleteMember(id);
      System.out.println(flag + "삭제 결과!");
   }
}