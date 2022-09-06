package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {


// DAO : Data Access Object
		// Member Table�� data�� �ְ� �޴� ��ɵ��� ��Ƶ� Ŭ����, ��ü
		// ȸ�����԰� �α��� �뵵�� insert�� select�� ����!! 
		Connection conn;
		PreparedStatement psmt = null;
		ResultSet rs;
		boolean result;
		
		private void connect() {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				String url = "jdbc:oracle:thin:@project-db-stu.ddns.net:1524:xe";
				String db_id = "campus_g_0830_6";
				String db_pw = "smhrd6";
					
				conn = DriverManager.getConnection(url, db_id, db_pw);
				
			} catch (ClassNotFoundException e) {
				System.out.println("�ε�����");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("DB���� ����");
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	
		public boolean login(String id, String pw) { // boolean -> int (cnt)
			
			// boolean result; ���������� ����
			
			connect();
			
			
			try {
				String sql = "select * From member where id = ? and pw = ?";
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
	
		// insert()	
		
		// �ܺο��� �������ؼ� �� �޼ҵ带 ȣ���ؼ� ���Ŵ� String id, String pw, String name, int age 
		// �׷��� �� 4���� ������ �ѹ��� ���� �� �ִ�.MemberDTO
		public int insert(UserDTO dto) { // void -> int
			int cnt = 0;// �ʹݿ�(insert�� ���� ���� ���� int Ÿ������ �� ����)
			
			// 1. �����ε�(�����۾� �ʿ�)
			connect();
			
			try {
				String id = dto.getId();   
				String pw = dto.getPw();
				String name = dto.getName();
				String save = dto.getAge();
				
				String sql = "insert into member values(?, ?, ?, ?)"; // ������ 'juhui', '5850', '������', 20
				psmt = conn.prepareStatement(sql);
				
				psmt.setString(1, id);
				psmt.setString(2, pw);
				psmt.setString(3, name);
				psmt.setString(4, save);
				
				cnt = psmt.executeUpdate(); // ���� �� Login View���� ����� �Ǵ��� �ڵ� �ۼ� �� ����
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			try {
//				Class.forName("oracle.jdbc.driver.OracleDriver");
//				
//				String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
//				String db_id = "hr";
//				String db_pw = "hr";
//					
//				conn = DriverManager.getConnection(url, db_id, db_pw);
//				
//			} catch (ClassNotFoundException e) {
//				System.out.println("�ε�����");
//				e.printStackTrace();
//			} catch (SQLException e) {
//				System.out.println("DB���� ����");
//				e.printStackTrace();
//			}                                                  -> �޼ҵ� ����
			
			
			return cnt;	// �ʹݿ�		
		}
		
		public int update(UserDTO dto) {
			int cnt = 0; // �굵 ���������� ����� ������
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

		// ��üȸ�� ��ȸ�ϴ� ���
		public void selestAll() {
 			connect();
			
			try {
				String sql = "select * from member";
				
				psmt = conn.prepareStatement(sql);
				
				rs = psmt.executeQuery();
				
				// rs�� Ŀ���� �������� ������ �����Ͱ� �ִ��� ������ Ȯ��
				System.out.println("ID\tPW\tNAME\tAGE");
				while(rs.next()) {
					String id = rs.getString(1);
					String pw = rs.getString(2);
					String name = rs.getString(3);
					int age = rs.getInt(4);
					
					System.out.printf("%s\t%s\t%s\t%d\n", id, pw, name, age);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		// Ư�� ȸ����ȸ���
		public void select(String id) {
			connect();
			
			try {
				String sql = "select * from member where id = ?";
				psmt = conn.prepareStatement(sql);				
				psmt.setString(1, id);
				
				rs = psmt.executeQuery();
				
				System.out.println("ID\tPW\tNAME\tAGE");
				while(rs.next()) {
					String id2 = rs.getString(1);
					String pw = rs.getString(2);
					String name = rs.getString(3);
					String save = rs.getString(4);
					
					System.out.printf("%s\t%s\t%s\t%d\n", id2, pw, name, save);
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		
		//ȸ��Ż��
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
		
		
		// select()
		
		
		
		
		
		// 2. DB����
		// 3. SQL ����
		// 4. ����(���� ����)
		
	}

