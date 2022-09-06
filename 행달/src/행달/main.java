package 행달;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class main {

	public static void main(String[] args) {
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
			String sql = "insert into story_table values(02,'1234','한대찬',)";

			PreparedStatement psmt = conn.prepareStatement(sql);
			int cnt = psmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("insert 성공");
			} else {
				System.out.println("insert 실패");
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
