package com.boot.controller;

import java.text.SimpleDateFormat;
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
import com.boot.service.HumorreplyService;
import com.boot.vo.BoolResult;
import com.boot.vo.Humor;
import com.boot.vo.Humorreply;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@Controller
@RequestMapping("/api")
public class MainController {
   public static final Logger logger = LoggerFactory.getLogger(MainController.class);
   
   @Autowired
   private HumorService  humorService;
   
   @Autowired
   private HumorreplyService humorreplyService;

  /* @RequestMapping(value = "/addHumor", method = RequestMethod.POST)
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
   }*/
   
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
      logger.info("-------------selectHumorByNum-------------"+new Date());
      Humor humor = humorService.selectHumorByNum(humorPK);
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
   public void createA(@RequestBody Humor humor) throws Exception {
      logger.info("-------------create-----------------------------"+new Date());
      System.out.println(humor);
      /*SimpleDateFormat format = new SimpleDateFormat ( "yyyy-MM-dd");
      Date time = new Date();
      String time1 = format.format(time);
      System.out.println(time1);*/
//      humor.setHumorDate(Date);
      //
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
   public void createReply(@RequestBody Humorreply humorreply) throws Exception {
      logger.info("-------------createReply-----------------------------"+new Date());
      System.out.println(humorreply);
      System.out.println(humorreply.getHumorReplyContent());
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
   
}