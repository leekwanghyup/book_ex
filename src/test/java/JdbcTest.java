import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class JdbcTest {
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 	
	}
	
	@Test
	public void testConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
		try (Connection con = DriverManager.getConnection(url,"book_ex","book_ex")){
			log.info(con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
