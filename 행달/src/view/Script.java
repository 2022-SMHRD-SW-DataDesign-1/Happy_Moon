package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;


import model.UserDAO;

public class Script {
	Connection conn;
	PreparedStatement psmt = null;
	ResultSet rs;
	UserDAO dao = new UserDAO();

	public void loadScript(int num) {
		
		
		dao.connect();
		
		try {
			String sql = "select story from story_table where story_num = ?";
			
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
		
			
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				String story = rs.getString(1);
				System.out.printf(story);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
