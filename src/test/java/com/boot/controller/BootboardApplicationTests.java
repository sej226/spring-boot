package com.boot.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.boot.dao.impl.HumorDAOImpl;
import com.boot.vo.Humor;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BootboardApplicationTests {
	@Autowired
	SqlSession session;
	
	@Test
	public void contextLoads() {
//		
//		session.insert("com.boot.dao.HumorDAO.addHumor", humor);
//		List<Humor> list = humor.selectAllHumor();
//		for(Humor h : list) {
//			System.out.println(h);
//		}
		
//		Humor humor = new Humor(0, "sej96226@gmail.com", "시험 공부 열심히 합시다.", "!그래 좋아", 0, "img01.jpg");
//		session.insert("com.boot.dao.HumorDAO.addHumor", humor);
		/*session.delete("com.boot.dao.HumorDAO.deleteHumor", 8);
		List<Humor> list = session.selectList("com.boot.dao.HumorDAO.selectAllHumor");
		for(Humor h : list) {
			System.out.println(h);
		}*/
		Humor humor = new Humor(0, null, "수정?", "!수정", 0, "img");
		session.update("com.boot.dao.HumorDAO.updateHumor", humor);
		System.out.println(humor);
		
	}

}
