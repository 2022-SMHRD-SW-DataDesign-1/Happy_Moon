package ���;

import java.util.Scanner;

import controller.SigninController;
import model.UserDAO;
import model.UserDTO;

public class main {

	public static void main(String[] args) {
		view();
	}
	
	
	
	
	
	
	
	
	
	
	
	public static void view() {
		dotArt art = new dotArt();
		UserDAO dao = new UserDAO();  // ���߿� �ø���
		UserDTO dto = null;
		
		// controller�� ������ �� �ִ� ��ü ����
		SigninController lm = new SigninController();
		
		Scanner sc= new Scanner(System.in);
		boolean flag = true;
		
		//� ���·� ȭ���� ������ ���ΰ�?
		art.init();
		System.out.println("======�ƹ�ư ���������̿�======");
		while(flag) {
			System.out.println();
			//�޴� ���
			System.out.println("[1]�α��� [2]ȸ������ [3]����");
			//�α��� -> select, ȸ������->insert, �������� ->update, ��ȸ->select , ȸ�� Ż��->delete.4
			
			System.out.print("�޴��� ���� ���ּ��� >>");
			String menu = sc.next();
			
			if(menu.equals("3")) {
				flag=false;
			}else if(menu.equals("2")) {//ȸ������
				System.out.print("���̵� �Է� : ");
				String id = sc.next();
				System.out.print("��й�ȣ �Է� : ");
				String pw = sc.next();
				System.out.print("�̸� �Է� : ");
				String name = sc.next();
				lm.InsertCon(id, pw, name);
				
				
			}else if(menu.equals("1")) {//�α���
				System.out.print("���̵� �Է� : ");
				String id = sc.next();
				System.out.print("��й�ȣ �Է� : ");
				String pw = sc.next();
				lm.LoginCon(id, pw);
				
				
			}else {
				System.out.println("���� 1~3 -> ���� �����ϼ̽��ϴ�.");
			}
			
		}
		
		System.out.println("�� �� �� �� ����������");
	}

}
