package ���;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class signIn {

	
	Scanner sc = new Scanner(System.in);

	public void signIn() {
//DB�����ڵ�
//		
//		try {
//			// 1. JDBC ���� �ε�
//			// �����ε��� ���� �޼ҵ带 �ҷ��;���
//			Class.forName("oracle.jdbc.driver.OracleDriver");
//			// 2. �����ͺ��̽� ����
//			String url = "jdbc:oracle:thin:@localhost:1521:xe";
//			String id = "hr";
//			String pw = "hr";
//
//			Connection conn = DriverManager.getConnection(url, id, pw);
//
//			if (conn != null) {
//				System.out.println("���� ����");
//				System.out.println(conn);
//			} else {
//				System.out.println("���� ����");
//			}
//			// 3. SQL�� �ۼ�/����
//			String sql = "insert into member values('chan','1234','�Ѵ���',25)";
//
//			PreparedStatement psmt = conn.prepareStatement(sql);
//			int cnt = psmt.executeUpdate();
//			if (cnt > 0) {
//				System.out.println("insert ����");
//			} else {
//				System.out.println("insert ����");
//			}
//
//			// 4. ���� - CLOSE();
//			if (psmt != null) {
//				psmt.close();
//			}
//			if (conn != null) {
//				conn.close();
//			}
//
//		} catch (ClassNotFoundException e) {
//			System.out.println("�����ε� ����");
//		} catch (SQLException e) {
//			System.out.println("DB ���� ����");
//		}
//===================================================
		boolean isSign = false;
		System.out.print("�̸��� �Է��Ͻÿ� >>");
		String name = sc.next();
		while (!isSign) {
			System.out.print("������ id�� �Է��Ͻÿ� >>");
			String id = sc.next();
			for (int i = 0; i < user.size(); i++) {
				if (user.get(i).getId().equals(id)) {
					System.out.println("���̵� �ߺ��˴ϴ�.");
				}
			}
			isSign = true;
		}
		System.out.print("������ pw�� �Է��Ͻÿ� >>");
		String pw = sc.next();
		

	}
}
