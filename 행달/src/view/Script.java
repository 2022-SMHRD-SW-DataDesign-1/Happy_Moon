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

	
	public void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_g_0830_6";
			String db_pw = "smhrd6";
				
			conn = DriverManager.getConnection(url, db_id, db_pw);
			
		} catch (ClassNotFoundException e) {
			System.out.println("class not found 오류");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB연결 쿼리 오류");
			e.printStackTrace();
		}
	}
	public void loadScript(int num) {
		
		connect();		
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
			e.printStackTrace();
		}
	}
}
