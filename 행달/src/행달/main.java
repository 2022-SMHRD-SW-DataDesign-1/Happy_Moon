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
		int choice;
		
		// controller�� ������ �� �ִ� ��ü ����
		SigninController lm = new SigninController();
		
		Scanner sc= new Scanner(System.in);
		boolean flag = true;
		boolean play ;
		int count=1;
		
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
				play=lm.LoginCon(id, pw);
				
				while(play) {
					System.out.println("[1]�����ϱ� [2]�̾��ϱ� [3]����");
					String menu2 = sc.next();
					if(menu2.equals("1")) {
						while(flag) {
							System.out.println("=================================================");
							new script().showStory(count++);
							System.out.println("=================================================");
							System.out.print("����� ������? >>");
							choice = sc.nextInt();
						}
					}else if(menu2.equals("2")) {
						
					}else if(menu2.equals("3")) {
						flag = false;
					}else {
						System.out.println("����");
					}
				}
				
				
				
				
			}else {
				System.out.println("���� 1~3 -> ���� �����ϼ̽��ϴ�.");
			}
			
		}
		
		System.out.println("�� �� �� �� ����������");
	}
	
	

}
