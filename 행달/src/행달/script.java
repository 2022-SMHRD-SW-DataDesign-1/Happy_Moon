package 행달;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class script {
	
	Connection conn;
	PreparedStatement psmt = null;
	ResultSet rs;
	boolean result;
	
	
	
	public void showStory(int number) {
		connect();
		
		try {
			String sql = "select story from story_table where story_num= ? ";
			
			psmt = conn.prepareStatement(sql);
			
			psmt.setInt(1, number*10);
			rs = psmt.executeQuery();
			if(rs.next()) {
				System.out.println(rs.getString(1));
			}else{
				System.out.println("END");
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	

	
	
	
	
	
	
	private void connect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_g_0830_6";
			String db_pw = "smhrd6";
				
			conn = DriverManager.getConnection(url, db_id, db_pw);
			
		} catch (ClassNotFoundException e) {
			System.out.println("로딩실패");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("DB연결 실패");
			e.printStackTrace();
		}
	}
	
	
	
}
