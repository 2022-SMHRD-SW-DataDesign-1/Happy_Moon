package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SummaryDAO {
	String[] summary ;
	
	Connection conn;
	PreparedStatement psmt = null;
	ResultSet rs;
	boolean result;
	String sum;
	
	protected void connect() {
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
	
	public void initSummary(String[] summary) {
		
		connect();
		
		try {
			String sql = "select count(*) from story_table;";
			psmt = conn.prepareStatement(sql);
			
			rs = psmt.executeQuery();
			summary = new String[rs.getInt("count(*)")];
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
	}
	
	
	
	
	//======== summary 출력용 in ending============
	
	public void setSummary(int index, String summary) {
		this.summary[index] = summary;
	}
	
	public String getSummary(String id) {
		connect();
		try {
			String sql = "SELECT summary from user_table where id = ?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,id);
			
			rs = psmt.executeQuery();
			
			return rs.getString("summary");
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
//	public String sumSummary() {
//		
//	}
	
	
	
	//저장한 String을 합쳐서
	public void insertDB(String sum) {
		connect();
	
		try {
			String sql = "insert into user_table (summary) valuse (?)";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,sum);
			
			rs = psmt.executeQuery();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}
	
	
	
}
