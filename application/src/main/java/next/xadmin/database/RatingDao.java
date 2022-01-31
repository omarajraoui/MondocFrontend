package next.xadmin.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.Member;
import next.xadmin.bean.LoginBean;
import next.xadmin.bean.Rating;

public class RatingDao {
	
	
	public boolean validate(Rating rate)
	{
		boolean status = false;
		
		DBConnection dbConnection=new DBConnection();
		Connection con = dbConnection.getConnection();
		
		String sql = "insert into rating (review,rating,docName) values(?,?,?)";
		PreparedStatement ps;
		try {
		ps = con.prepareStatement(sql);
		ps.setString(1, rate.getReview());
		ps.setInt(2, rate.getRatingNumber());
		ps.setString(3, rate.getDoctorName());
		
		ps.executeUpdate();
		
		status=true;
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			status=false;
		}
		return status;
	}
}

