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
import me.light.domain.BoardVO;
import me.light.domain.Criteria;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class BoardServiceTests {
	
	@Autowired
	private BoardService service; 
	
	@Test
	@Ignore
	public void registerTest() {
		BoardVO boardVO = new BoardVO();
		boardVO.setTitle("BoardService Test Title");
		boardVO.setContent("BoardService Test Contents");
		boardVO.setWriter("ServiceTester");
		service.register(boardVO);
	}

	@Test
	@Ignore
	public void getTest() {
		BoardVO boardVO = service.get(6L);
		log.info(boardVO);
	}
	
	@Test
	@Ignore
	public void modifyTest() {
		BoardVO boardVO = service.get(6L);
		boardVO.setTitle("BoardService Modify Test Title");
		boardVO.setContent("BoardService Modify Test Contents");
		boardVO.setWriter("ModifyTest");
		boolean doModify = service.modify(boardVO);
		log.info("Service Modify Test : " + doModify);
	}

	@Test
	@Ignore
	public void removeTest() {
		boolean doRemove =  service.remove(6L);
		log.info("Service Remove Test : " + doRemove);
	}

	@Test
	@Ignore
	public void getListTest() {
		List<BoardVO> list = service.getList(new Criteria(1,15));
		list.forEach(article -> System.out.println(article));
	}
	
	@Test
	public void getTotalTest() {
		int total = service.getTotal(new Criteria()); 
		log.info("전체 게수물 수 : " + total);
	}
}
