package me.light.boardMapperTest;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import me.light.config.RootConfig;
import me.light.domain.BoardVO;
import me.light.mapper.BoardMapper;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	@Ignore
	public void getListTest() { // Select All
		boardMapper.getList().forEach(board -> log.info(board));
	}
	
	@Test
	@Ignore
	public void insertTest() {	// insert 
		BoardVO boardVO = new BoardVO(); 
		boardVO.setTitle("title Junit Title");
		boardVO.setContent("test Junit Content");
		boardVO.setWriter("TestUser01");
		boardMapper.insert(boardVO);
		
		log.info("insertTest() : success");
	}
	
	@Test
	@Ignore
	public void insertSelectKeyTest() { // insert by SelectKey
		BoardVO boardVO = new BoardVO(); 
		boardVO.setTitle("title Junit Title2");
		boardVO.setContent("test Junit Content2");
		boardVO.setWriter("TestUser02");
		boardMapper.insertSelectKey(boardVO);
		log.info("insertSelectKeyTest() : success");
	}
	
	@Test
	@Ignore
	public void readTest() { // Select One
		BoardVO boardVO = boardMapper.read(1L); // exists article
		log.info(boardVO);
	}
	
	
	@Test
	@Ignore
	public void deleteTest() {
		int deletedNumber =  boardMapper.delete(1L); // exists article
		log.info("Deleted Article Number : " + deletedNumber);
	}
	
	
	@Test
	@Ignore
	public void updateTest() {
		BoardVO boardVO = boardMapper.read(2L);
		boardVO.setTitle("Updated Board Title ...");
		boardVO.setContent("Updated Board Contents ...");
		boardVO.setWriter("UpdatedTestUser");
		int updated = boardMapper.update(boardVO); 
		log.info("Updated Article Number : " + updated);
	}
	
}
