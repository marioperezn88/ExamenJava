import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;



import dao.MySqlColegaDao;
import modelo.Colega;



public class TestMySqlColegaDao {

	@Test
	public void test() {
		
		
		
		
				Colega colega = new Colega(12345, "Mario", "Madrid", new Date());
				
				
				new java.sql.Date(0);
				
				BasicDataSource ds = new BasicDataSource();
				ds.setUrl("jdbc:mysql://localhost:3306/colegajdbc");
				ds.setUsername("root");
				ds.setPassword("rootroot");
				ds.setDriverClassName("com.mysql.jdbc.Driver");
			
				
				MySqlColegaDao sut = new MySqlColegaDao(ds);
	
				
				try {
				sut.Insercion(colega);
				
				Colega colegaObtenido = sut.visualizarPorId(colega.getId());
				assertEquals(colega, colegaObtenido);
				} catch (SQLException e) {
					e.printStackTrace();
					fail("Se introduce  un SQLExeception, y no debería: "+ e.getMessage());
				}
				
				
				
				
				

			
		fail("Not yet implemented");
	

}
}