package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import modelo.Colega;

public class MySqlColegaDao implements ColegaDao1 {

	private static final String INSERT_COLEGA = "INSERT INTO colega (id,nombre,ciudad,fecha) " + "VALUES (?,?,?,?)";

	private static final String DELETE_COLEGA = "DELETE FROM colega " + "WHERE id=? ";

	private static final String SELECT_COLEGA = "SELECT* FROM colega";

	private static final String UPDATE_COLEGA = "UPDATE colega " + "SET nombre =?,ciudad=?, fecha=? " + "WHERE id=?";

	private static final String SELECT_COLEGA_BY_ID = null;

	private DataSource ds;

	public MySqlColegaDao(BasicDataSource ds2) {
		super();
		this.ds = ds;
	}

	@Override
	public void Insercion(Colega colega) throws SQLException {

		Connection connection = null;
		try {
			connection = ds.getConnection();

			PreparedStatement ps = connection.prepareStatement(INSERT_COLEGA);
			ps.setInt(1, colega.getId());
			ps.setString(2, colega.getNombre());
			ps.setString(3, colega.getCiudad());
			ps.setDate(4, new java.sql.Date(colega.getFecha().getTime()));

			ps.executeUpdate();

		} finally {

			if (connection != null) {
				connection.close();
			}

		}

	}

	@Override
	public void Borrado(int id) throws SQLException {

		Connection connection = null;
		try {
			connection = ds.getConnection();

			PreparedStatement ps = connection.prepareStatement(DELETE_COLEGA);
			ps.setInt(1, id);

			ps.executeUpdate();

		} finally {

			if (connection != null) {
				connection.close();
			}

		}
	}

	@Override
	public Collection<Colega> visualizar() throws SQLException {

		Collection<Colega> resultado = new HashSet<>();

		Connection connection = null;
		try {
			connection = ds.getConnection();

			PreparedStatement ps = connection.prepareStatement(SELECT_COLEGA);

			ResultSet rs = ps.executeQuery();

			if (rs.first()) {

				do {

					Colega colega = new Colega(

							rs.getInt("id"), rs.getString("nombre"), rs.getString("ciudad"), rs.getDate("fecha"));
					resultado.add(colega);

				} while (rs.next());

			}

			return resultado;

		} finally {

			if (connection != null) {
				connection.close();
			}

		}

	}

	@Override
	public void modificar(Colega colega) throws SQLException {

		Connection connection = null;
		try {
			connection = ds.getConnection();

			PreparedStatement ps = connection.prepareStatement(UPDATE_COLEGA);

			ps.setString(1, colega.getNombre());
			ps.setString(2, colega.getCiudad());
			ps.setDate(3, new java.sql.Date(colega.getFecha().getTime()));
			
			ps.setInt(4, colega.getId());

			ps.executeUpdate();

		} finally {

			if (connection != null) {
				connection.close();
			}
		}
	}

	@Override
	public Colega visualizarPorId(int id) throws SQLException {
		
		Connection connection = null;
		try {
			connection = ds.getConnection();
			
			PreparedStatement ps = connection.prepareStatement(SELECT_COLEGA_BY_ID);
			ps.setInt(1, id);

			
			ResultSet rs = ps.executeQuery();
		
			if (rs.first()) {
				return new Colega(id, rs.getString("nombre"), rs.getString("ciudad"), rs.getDate("fecha"));

			}
		} finally {
			
			if (connection != null) {
				connection.close();

			}

		}
		return null;
	}
}