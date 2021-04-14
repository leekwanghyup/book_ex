package me.light.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
import me.light.config.RootConfig;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class TimeMapperTests {	
	
	@Autowired
	private TimeMapper timeMapper; 
	
	@Test
	public void testGetTime() {
		log.info(timeMapper.getTime());
		log.info(timeMapper.getTime2());
	}	
}
