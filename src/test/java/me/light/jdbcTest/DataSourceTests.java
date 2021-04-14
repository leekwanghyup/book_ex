package me.light.jdbcTest;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import lombok.extern.log4j.Log4j;
import me.light.config.RootConfig;

@Log4j
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {RootConfig.class})
public class DataSourceTests {
	
	@Autowired
	private DataSource dataSource; 
	
	@Test
	public void testConnection() {
		try (Connection con = dataSource.getConnection()){
			log.info(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
