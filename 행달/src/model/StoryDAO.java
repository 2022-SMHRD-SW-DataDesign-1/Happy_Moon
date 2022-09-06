package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoryDAO {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. jdbc 동적로딩
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 데이터베이스 연결
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_g_0830_6";
			String db_pw = "smhrd6";
			conn = DriverManager.getConnection(url, db_id, db_pw);
			// 3. sql문 작성
			
			String sql = "select * from story_table";
			psmt = conn.prepareStatement(sql);

			// CRUD : Create, Read, Update, Delete
			// 생성 읽기,조회 갱신,수정 삭제
			// insert, update, delete -> executeUpdate();
			// select -> executeQuery();

			rs = psmt.executeQuery();

			
		
			while (rs.next()) {

			
				System.out.printf("%s\t%s\t%s\t%d\n", id, pw, name, age);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("동적로딩 실패");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4. 종료
			try {
				if(rs != null) {
					rs.close();
				}
				if(psmt != null) {
					psmt.close();
				}
				if(conn != null) {
					conn.close();
				}
				
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}
	
}
