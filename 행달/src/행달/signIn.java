package 행달;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class signIn {

	
	Scanner sc = new Scanner(System.in);

	public void signIn() {
//DB참고코드
//		
//		try {
//			// 1. JDBC 동적 로딩
//			// 동적로딩을 위한 메소드를 불러와야함
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			// 2. 데이터베이스 연결
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			String id = "hr";
//			String pw = "hr";
//
//			Connection conn = DriverManager.getConnection(url, id, pw);
//
//			if (conn != null) {
//				System.out.println("연결 성공");
//				System.out.println(conn);
//			} else {
//				System.out.println("연결 실패");
//			}
//			// 3. SQL문 작성/전송
//			String sql = "insert into member values('chan','1234','한대찬',25)";
//
//			PreparedStatement psmt = conn.prepareStatement(sql);
//			int cnt = psmt.executeUpdate();
//			if (cnt > 0) {
//				System.out.println("insert 성공");
//			} else {
//				System.out.println("insert 실패");
//			}
//
//			// 4. 종료 - CLOSE();
//			if (psmt != null) {
//				psmt.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//
//		} catch (ClassNotFoundException e) {
//			System.out.println("동적로딩 실패");
//		} catch (SQLException e) {
//			System.out.println("DB 연결 실패");
//		}
//===================================================
		boolean isSign = false;
		System.out.print("이름을 입력하시오 >>");
		String name = sc.next();
		while (!isSign) {
			System.out.print("가입할 id를 입력하시오 >>");
			String id = sc.next();
			for (int i = 0; i < user.size(); i++) {
				if (user.get(i).getId().equals(id)) {
					System.out.println("아이디가 중복됩니다.");
				}
			}
			isSign = true;
		}
		System.out.print("가입할 pw를 입력하시오 >>");
		String pw = sc.next();
		

	}
}
