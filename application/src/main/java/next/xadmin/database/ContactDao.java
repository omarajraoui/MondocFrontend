package next.xadmin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import next.xadmin.bean.Contact;

public class ContactDao {
	
	public String insert(Contact contact) {
		
		DBConnection dbConnection=new DBConnection();
		Connection con = dbConnection.getConnection();
		
		String result = "Contact entered successfully";
		String sql = "insert into contact values(?,?,?,?)";
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, contact.getFirstname());
		ps.setString(2, contact.getEmail());
		ps.setString(3, contact.getNumero());
		ps.setString(4, contact.getMessage());
		
		ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = "Data not entered";
		}
		return result;
	}
	
	
	
}