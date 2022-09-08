package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {


// DAO : Data Access Object
		Connection conn;
		PreparedStatement psmt = null;
		ResultSet rs;
		boolean result;
		
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
		
	public void getClose() {
		
			try {
				if(rs!=null) {
					rs.close();
				}
				if(psmt!=null) {
				psmt.close();
				}
				if(conn!= null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
	}
	
		public boolean login(String id, String pw) { // boolean -> int (cnt)
			
			
			connect();
			
			try {
				String sql = "select * From User_table where id = ? and pw = ?";
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, id);
				psmt.setString(2, pw);
				
				
				rs = psmt.executeQuery();
				
				if(rs.next()) {					
					result = true; // cnt = 1;
				}else {
					result = false; // cnt = 0
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			return result; // result -> cnt
		}
	
		
		//회원가입
		public int insert(UserDTO dto) { 
			int cnt = 0;
			
			connect();
			
			try {
				String id = dto.getId();   
				String pw = dto.getPw();
				String name = dto.getName();
				int save = dto.getSave();
			
				
				String sql = "insert into user_table(user_number,id,pw,name) values(user_id.nextval,?, ?, ?)"; 
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, id);
				psmt.setString(2, pw);
				psmt.setString(3, name);
				
				cnt = psmt.executeUpdate(); 
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			
			return cnt;		
		}
		
		
		//정보 수정
		public int update(UserDTO dto) {
			int cnt = 0; 
			connect();
			
			try {
				String id = dto.getId();
				String pw = dto.getPw();
				
				String sql = "update member set pw = ? where id = ?";
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, pw);
				psmt.setString(2, id);
				
				cnt = psmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				getClose();
			}
			return cnt;
		}

		// 사용자 다보기
		public void selestAll() {
 			connect();
			
			try {
				String sql = "select * from user_table";
				
				psmt = conn.prepareStatement(sql);
				
				rs = psmt.executeQuery();
				
				while(rs.next()) {
					String id = rs.getString(1);
					String pw = rs.getString(2);
					String name = rs.getString(3);
					
					System.out.printf("%s\t%s\t%s\t%d\n", id, pw, name);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// id로 정보찾기
		public void select(String id) {
			connect();
			
			try {
				String sql = "select * from member where id = ?";
				psmt = conn.prepareStatement(sql);				
				psmt.setString(1, id);
				
				rs = psmt.executeQuery();
				
				System.out.println("ID\tPW\tNAME\tStory");
				while(rs.next()) {
					String id2 = rs.getString(2);
					String pw = rs.getString(3);
					String name = rs.getString(4);
					String save = rs.getString(5);
					
					System.out.printf("%s\t%s\t%s\t%d\n", id2, pw, name, save);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		//회원 탈퇴
		public int delete(String id) {
			int cnt = 0;
			connect();
			
			try {
				String sql = "delete from member where id = ?";
				psmt = conn.prepareStatement(sql);				
				psmt.setString(1, id);
				
				cnt = psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return cnt;
		}
		
		
		
		
		//중복확인
		public boolean isOverlapped(String id) {
			connect();
			try {
				String isOverlap = "select * from user_table where id = ?";
				psmt = conn.prepareStatement(isOverlap);
				psmt.setString(1, id);
				rs = psmt.executeQuery();
				if(rs.next()) {
					return true;
				}else {
					return false;
				}
			} catch (SQLException e) {
				System.out.println("DB sql 문법 오 류");
				e.printStackTrace();
				return false;
			}
		}
		
		//세이브 값 불러오기
		public int loadData(String id) {
			connect();
			try {
				String isOverlap = "select save from user_table where id = ?";
				psmt = conn.prepareStatement(isOverlap);
				psmt.setString(1, id);
				rs = psmt.executeQuery();
				if(rs.next()) {
					return rs.getInt("save");
				}else {
					return 1;
				}
			} catch (SQLException e) {
				System.out.println("DB sql 문법 오 류");
				e.printStackTrace();
				return 1;
			}
		}
		
		public void saveData(int save, String id) {
			connect();
			try {
				String sql = "update user_table set save= ? where id = ?";
				psmt = conn.prepareStatement(sql);				
				psmt.setInt(1, save);
				psmt.setString(2, id);
				
				int cnt = psmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		
		
		
	}

