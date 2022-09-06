package controller;

import model.UserDAO;
import model.UserDTO;

public class SigninController {
		
		// DAO�� ������ �� �ִ� ��ü ����
		UserDAO dao = new UserDAO();
		
		// DTO�� ������ �� �ִ� ��ü ����
		UserDTO dto; // = new MemberDTO(id, pw); // ������ �޼ҵ����� -> �����ؾ��� , ��ü���� �Ű������� ������ ��ɿ� ���� �ٸ��� �ְٴ�
		

		// Main �޼ҵ忡�� �α����� ���� ��
		// ���̵�� ��й�ȣ�� �޾ƿ� DAO �� �������ִ� �޼ҵ� ����
		
		// ���μ��� DAO�� ����ڸ� �������ֱ� ���ؼ��� �޼ҵ�� �����ؾ���
		public void LoginCon(String id, String pw) {
			// DAO�� �ִ� login()
			boolean result = dao.login(id, pw);
			
			// �α��� ����� ���� ������ �ִ� member ���̺� 
			// id, pw�� �����ϰ� �� �ִ� ������ �ִ��� ������ Ȯ�� ��
			// ����� ��ȯ
			if(result) { // cnt�ε� �ٲ㺸��
				System.out.println("�α��� ����");
			}else {
				System.out.println("�α��� ����");
			}
		}
		
		public void InsertCon(String id, String pw, String name, String save) {
			dto = new UserDTO(id, pw, name,save); // ������ �޼ҵ�
			
			int cnt = dao.insert(dto); // sql�����
			
			if(cnt > 0) {
				System.out.println("ȸ������ ����");
			}else {
				System.out.println("ȸ������ ����");
			}
		}

		public void UpdateCon(String id, String pw) {
			
			dto = new UserDTO(id, pw); // 2
			int cnt = dao.update(dto); // 1
			
			if(cnt > 0) {
				System.out.println("ȸ������ �����Ϸ�");
			}else {
				System.out.println("ȸ������ ��������");
			}		
		}

		
		//Ư���ι� ���̵�� ã��
		public void SelectCon(String id) {

			dao.select(id);	
		}
		
		//ȸ�� ����
		public void DeleteCon(String id) {
			int cnt = dao.delete(id);
			if(cnt > 0) {
				System.out.println("Ż�� ����");
			}else {
				System.out.println("Ż�� ����");
			}
		}
}
