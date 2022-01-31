package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import next.xadmin.database.DBConnection;

public class RegisterDao {

	public String insert(Member member) {
		
		DBConnection dbConnection=new DBConnection();
		Connection con = dbConnection.getConnection();
		
		String result = "Data entered successfully";
		String sql = "insert into register (lastname,email,password,name) values(?,?,?,?)";
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, member.getLastname());
		ps.setString(2, member.getEmail());
		ps.setString(3, member.getPassword());
		ps.setString(4, member.getFirstname());
	
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data not entered";
		}
		return result;
	}
}

