package negocio;

import java.sql.SQLException;
import java.util.Collection;

import modelo.Colega;

public interface NegocioColegasInterfaz1 {

	public void altaColega(Colega colega) throws SQLException;
	public void bajaColega(int id) throws SQLException ;
	public Colega consultaPorId(int id) throws SQLException;    
	public Collection<Colega> consultaTodos() throws SQLException;
	public void actualizar(Colega colega) throws SQLException;
	

}
