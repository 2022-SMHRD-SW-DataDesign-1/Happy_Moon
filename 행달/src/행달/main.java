package ���;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class main {

	public static void main(String[] args) {
		try {
			// 1. JDBC ���� �ε�
			// �����ε��� ���� �޼ҵ带 �ҷ��;���
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. �����ͺ��̽� ����
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_g_0830_6";
			String db_pw = "smhrd6";
				

			Connection conn = DriverManager.getConnection(url, db_id, db_pw);

			if (conn != null) {
				System.out.println("���� ����");
				
			} else {
				System.out.println("���� ����");
			}
			// 3. SQL�� �ۼ�/����
			String sql = "insert into story_table values(02,'1234','�Ѵ���',)";

			PreparedStatement psmt = conn.prepareStatement(sql);
			int cnt = psmt.executeUpdate();
			if (cnt > 0) {
				System.out.println("insert ����");
			} else {
				System.out.println("insert ����");
			}

			// 4. ���� - CLOSE();
			if (psmt != null) {
				psmt.close();
			}
			if (conn != null) {
				conn.close();
			}

		} catch (ClassNotFoundException e) {
			System.out.println("�����ε� ����");
		} catch (SQLException e) {
			System.out.println("DB ���� ����");
		}

	}

}
