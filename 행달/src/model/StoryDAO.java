package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import controller.Choice;

public class StoryDAO {
	
	public void save_story() {
		

	}
	public void load_story(int seq)
	{
		ResultSet rs = null;
		try {
			// 1. JDBC 동적 로딩
			// 동적로딩을 위한 메소드를 불러와야함
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. 데이터베이스 연결
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_g_0830_6";
			String db_pw = "smhrd6";

			Connection conn = DriverManager.getConnection(url, db_id, db_pw);

			if (conn != null) {
				System.out.println("연결 성공");

			} else {
				System.out.println("연결 실패");
			}
			// 3. SQL문 작성/전송
			String sql = "select story from story_table where story_num = " + seq;

			PreparedStatement psmt = conn.prepareStatement(sql);
			rs= psmt.executeQuery();
			
			//System.out.println(rs.next());
			while (rs.next()) {
				String story = rs.getString(1);
			System.out.printf("%s",story);
			}

			// 4. 종료 - CLOSE();
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (ClassNotFoundException e) {
			System.out.println("동적로딩 실패");
		} catch (SQLException e) {
			System.out.println("DB 연결 실패");
		}

	}

}
