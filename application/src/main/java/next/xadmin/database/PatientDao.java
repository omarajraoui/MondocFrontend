package next.xadmin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import next.xadmin.bean.Patient;

public class PatientDao {
	private String dbUrl = "jdbc:mysql://localhost:3306/mondoc";
	private String dbUname = "root";
	//private String dbPassword = "mysql2020";
	private String dbPassword = "";
	private static final String INSERT_USERS_SQL = "INSERT INTO patient" + "  (firstname, lastname, docname, speciality, rapport) VALUES "
			+ " (?,?,?,?,?);";

	private static final String SELECT_USER_BY_ID = "select id,firstname, lastname, docname, speciality,rapport from patient where id =?";
	private static final String SELECT_ALL_USERS = "select * from patient";
	private static final String DELETE_USERS_SQL = "delete from patient where id = ?;";
	private static final String UPDATE_USERS_SQL = "update patient set firstname = ?,lastname= ?,docname = ?,speciality = ?,rapport = ?   where id = ?;";
	
	protected Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection(dbUrl, dbUname, dbPassword);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	//insertUser
	public void insertPatient(Patient patient) throws SQLException {
		System.out.println(INSERT_USERS_SQL);
		// try-with-resource statement will auto close the connection.
		try (Connection connection = getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
			preparedStatement.setString(1, patient.getFirstname());
			preparedStatement.setString(2, patient.getLastname());
			preparedStatement.setString(3, patient.getDocname());
			preparedStatement.setString(4, patient.getSpeciality());
			preparedStatement.setString(5, patient.getRapport());
			System.out.println(preparedStatement);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			printSQLException(e);
		}
	}
	public Patient selectPatient(int id) {
		Patient patient = null;
		try (Connection connection = getConnection();
				PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			System.out.println(preparedStatement);
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String docname = rs.getString("docname");
				String speciality = rs.getString("speciality");
				String rapport = rs.getString("rapport");
				patient = new Patient(id,firstname, lastname, docname, speciality,rapport);
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return patient;
	}
	public List<Patient> selectAllPatients() {

		// using try-with-resources to avoid closing resources (boiler plate code)
		List<Patient> patients = new ArrayList<>();
		// Step 1: Establishing a Connection
		try (Connection connection = getConnection();

				// Step 2:Create a statement using connection object
			PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_USERS);) {
			System.out.println(preparedStatement);
			// Step 3: Execute the query or update query
			ResultSet rs = preparedStatement.executeQuery();

			// Step 4: Process the ResultSet object.
			while (rs.next()) {
				int id = rs.getInt("id");
				String firstname = rs.getString("firstname");
				String lastname = rs.getString("lastname");
				String docname = rs.getString("docname");
				String speciality = rs.getString("speciality");
				String rapport = rs.getString("rapport");
				patients.add(new Patient(id,firstname, lastname, docname, speciality,rapport));
			}
		} catch (SQLException e) {
			printSQLException(e);
		}
		return patients;
	} 
	
	public boolean deletePatient(int id) throws SQLException {
		boolean rowDeleted;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(DELETE_USERS_SQL);) {
			statement.setInt(1, id);
			rowDeleted = statement.executeUpdate() > 0;
		}
		return rowDeleted;
	}
	public boolean updatePatient(Patient patient) throws SQLException {
		boolean rowUpdated;
		try (Connection connection = getConnection();
				PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
			System.out.println("updated Patient:"+statement);
		
			statement.setString(1, patient.getFirstname());
			statement.setString(2, patient.getLastname());
			statement.setString(3, patient.getDocname());
			statement.setString(4, patient.getSpeciality());
			statement.setString(5, patient.getRapport());
			statement.setInt(6, patient.getId());

			rowUpdated = statement.executeUpdate() > 0;
		}
		return rowUpdated;
	}

	
	
	private void printSQLException(SQLException ex) {
		for (Throwable e : ex) {
			if (e instanceof SQLException) {
				e.printStackTrace(System.err);
				System.err.println("SQLState: " + ((SQLException) e).getSQLState());
				System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
				System.err.println("Message: " + e.getMessage());
				Throwable t = ex.getCause();
				while (t != null) {
					System.out.println("Cause: " + t);
					t = t.getCause();
				}
			}
		}
	}

}