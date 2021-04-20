package me.light.mapper;

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
public class ReplyMapperTests {
	
	@Autowired
	private ReplyMapper mapper; 
	
	@Test
	@Ignore
	public void testCreate() {
		ReplyVO vo = new ReplyVO(); 
		vo.setBno(767L);
		vo.setReply("reply test content");
		vo.setReplyer("replyerTester");
		int isSucess =  mapper.insert(vo);
		log.info(" inser reply test : " + isSucess);
	}
	
	@Test
	@Ignore
	public void testReadOne() {
		ReplyVO vo = new ReplyVO(); 
		vo = mapper.read(1L);
		log.info("ReplyMapper read Test" + vo);
	}
	
	@Test
	@Ignore
	public void testReadAll() {
		List<ReplyVO> replyList = mapper.getListWithPaging(new Criteria(), 767L); 
		log.info("Reply List Test");
	}
	
	@Test
	@Ignore
	public void testUpdate() {
		ReplyVO vo = mapper.read(2L);  
		vo.setBno(767L);
		vo.setReply("reply !!update!! test content");
		int isSucess = mapper.update(vo); 
		log.info(" Update reply test : " + isSucess);
	}
	
	@Test
	public void testDelete() {
		int isSucess = mapper.delete(2L);
		log.info(" delete reply test : " + isSucess);
	}
}
