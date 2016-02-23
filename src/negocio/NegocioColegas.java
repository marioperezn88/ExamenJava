package negocio;

import java.sql.SQLException;
import java.util.Collection;

import dao.ColegaDao1;
import modelo.Colega;

public class NegocioColegas implements NegocioColegasInterfaz1 {
	
	private ColegaDao1 colegaDao;
	
	

	public NegocioColegas(ColegaDao1 colegaDao) {
		super();
		this.colegaDao = colegaDao;
	}



	@Override
	public void altaColega(Colega colega) throws SQLException {
		colegaDao.Insercion(colega);	
	}



	@Override
	public void bajaColega(int id) throws SQLException {
		colegaDao.Borrado(id);
		
	}



	@Override
	public Colega consultaPorId(int id) throws SQLException {
		
		
		Colega colega = colegaDao.visualizarPorId(id);
		return colega;
		
	}



	@Override
	public Collection<Colega> consultaTodos() throws SQLException {
		
	    Collection<Colega> colegas = colegaDao.visualizar();
		
		return colegas;
	}



	@Override
	public void actualizar(Colega colega) throws SQLException {
		
		colegaDao.modificar(colega);
		
	}

	
}
