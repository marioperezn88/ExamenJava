package dao;


	
	import java.sql.SQLException;
import java.util.Collection;



import modelo.Colega;

public interface ColegaDao1 {
	
		void Insercion (Colega colega) throws SQLException;
		
		void Borrado(int id) throws SQLException;
		
		Colega visualizarPorId(int id) throws SQLException;
		
		Collection<Colega> visualizar() throws SQLException;
		
		void modificar(Colega colega) throws SQLException;
		
	
}
