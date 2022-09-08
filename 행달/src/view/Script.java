package view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Music;

import java.sql.DriverManager;

import model.UserDAO;

public class Script {
	Connection conn;
	PreparedStatement psmt = null;

	ResultSet rs;
	UserDAO dao = new UserDAO();

	public void loadScript(int num) {

		
		int i=0;
		Music player = new Music();
		dotArt art = new dotArt();
		int i =0;
		connect();
		try {
			String sql = "select story from story_table where story_num = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);

			rs = psmt.executeQuery();

			if (rs.next()) {
				String story = rs.getString(1);

					try {
						char[] forShow = story.toCharArray();
						for (char temp : forShow) {
							System.out.print(temp);
							Thread.sleep(0);						
							if(i==50&&num==30) 
								art.init();
							if(num == 46 && i == 110 )
								art.mask();
							
							
							i++;
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
					e.printStackTrace();				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String saveSummary(int num) {
		connect();
		try {
			String sql = "select summary from story_table where story_num = ?";

			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, num);
			rs = psmt.executeQuery();
			if(rs.next()) {
				return rs.getString("summary");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	
		
	}

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
	
	
	
	
	public String getSummary(String id) {
		connect();
		try {
			String sql = "SELECT story from user_table where id = ?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,id);
			rs = psmt.executeQuery();
			
			if(rs.next()) {
				return rs.getString("story");
			}
			
			
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	
	

	//저장한 String을 합쳐서
	public void insertDB(String sum, String id) {
		connect();
		try {
			String sql = "update user_table set story = ? where id = ?";
			psmt = conn.prepareStatement(sql);
			
			psmt.setString(1,sum);
			psmt.setString(2, id);
			
			rs = psmt.executeQuery();
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}
	
	public String sumSummary(String[] summary) {
		String sum ="";
		for(String temp : summary) {
			if(temp != null) {
				sum+=temp+" "; 
			}
		}
		
		return sum;
	
}
	
}
