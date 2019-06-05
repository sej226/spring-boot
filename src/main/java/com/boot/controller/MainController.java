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
import com.boot.vo.BoolResult;
import com.boot.vo.Humor;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@Controller
@RequestMapping("/api")
public class MainController {
   public static final Logger logger = LoggerFactory.getLogger(MainController.class);
   
   @Autowired
   private HumorService  humorService;

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
   
   @RequestMapping(value = "/selectHumorByID/{id}", method =  RequestMethod.GET)
   public ResponseEntity<List<Humor>> selectHumorByID(@PathVariable String id) throws Exception {
      logger.info("-------------selectHumorByID-------------"+new Date());
      List<Humor> humors = humorService.selectHumorByID(id);
      System.out.println(humors);
      if (humors.isEmpty()) {
         return new ResponseEntity(HttpStatus.NO_CONTENT);
      }
      return new ResponseEntity<List<Humor>>(humors, HttpStatus.OK);
   }
}