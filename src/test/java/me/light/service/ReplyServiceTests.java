package me.light.service;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import me.light.config.RootConfig;
import me.light.domain.Criteria;
import me.light.domain.ReplyVO;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class ReplyServiceTests {
	
	@Autowired
	private ReplyService sevice; 
	
	@Test
	@Ignore
	public void testCreate() {
		ReplyVO vo = new ReplyVO(); 
		vo.setBno(767L);
		vo.setReply("reply Serivce test content");
		vo.setReplyer("replyerTester");
		int isSucess =  sevice.register(vo); 
		log.info(" inser reply test : " + isSucess);
	}
	
	@Test
	@Ignore
	public void testReadOne() {
		ReplyVO vo = new ReplyVO(); 
		vo = sevice.get(1L); 
		log.info("ReplySerivce read Test" + vo);
	}
	
	@Test
	@Ignore
	public void testReadAll() {
		List<ReplyVO> replyList = sevice.getList(new Criteria(), 767L); 	 
		log.info("Reply List Service Test");
	}
	
	@Test
	@Ignore
	public void testUpdate() {
		ReplyVO vo = sevice.get(3L);  
		vo.setReply("reply !!update!! Service test content");
		int isSucess = sevice.modify(vo); 
		log.info(" Update reply Service test : " + isSucess);
	}
	
	@Test
	@Ignore
	public void testDelete() {
		int isSucess = sevice.remove(3L);
		log.info(" delete reply  Service test : " + isSucess);
	}
}
