package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StoryDAO {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. jdbc �����ε�
		Connection conn = null;
		PreparedStatement psmt = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 2. �����ͺ��̽� ����
			String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
			String db_id = "campus_g_0830_6";
			String db_pw = "smhrd6";
			conn = DriverManager.getConnection(url, db_id, db_pw);
			// 3. sql�� �ۼ�
			
			String sql = "select * from story_table";
			psmt = conn.prepareStatement(sql);

			// CRUD : Create, Read, Update, Delete
			// ���� �б�,��ȸ ����,���� ����
			// insert, update, delete -> executeUpdate();
			// select -> executeQuery();

			rs = psmt.executeQuery();

			
		
			while (rs.next()) {

			
				System.out.printf("%s\t%s\t%s\t%d\n", id, pw, name, age);
			}

		} catch (ClassNotFoundException e) {
			System.out.println("�����ε� ����");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 4. ����
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
