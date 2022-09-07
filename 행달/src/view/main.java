package view;


import java.util.Scanner;

import controller.Choice;
import controller.SigninController;
import model.StoryDAO;
import model.UserDAO;
import model.UserDTO;
import controller.Choice;

public class main {

	public static void main(String[] args) {
	
		view();
	
		
		
	}
	
	
	
	public static int choice() {
		 Choice user_cho = new Choice();
		if( == 1) {
		Choice user_cho1 = new Choice(1);
		} else if(num == 2) {
			Choice user_cho = new Choice(2);
		} else System.out.println("잘못입력하셨습니다.");
		
		
		return user_cho.getNext();
		
	}
	
	
	
	
	
	
	
	public static void view() {
		dotArt art = new dotArt();
		UserDAO dao = new UserDAO(); 
		UserDTO dto = null;
		
		
		
		

		SigninController lm = new SigninController();
		
		Scanner sc= new Scanner(System.in);
		boolean flag = true;
		
		art.init();
		System.out.println("======아무튼 공포 게임======");
		while(flag) {
			System.out.println();
			System.out.println("[1]로그인 [2]회원 가입 [3]종료");
			
			System.out.print("메뉴를 선택해 주세요 >>");
			String menu = sc.next();
			
			if(menu.equals("3")) {
				flag=false;
			}else if(menu.equals("2")) {//회원 가입
				System.out.print("아이디를 입력해 주세요 : ");
				String id = sc.next();
				while(dao.isOverlapped(id)) {
						System.out.print("\n중복된 아이디 입니다!\n다른 아이디를 입력해 주세요>>");
						id = sc.next();
						if(!dao.isOverlapped(id)) {
							System.out.println("사용 가능한 아이디 입니다!");
							break;
						}
				}
				System.out.print("비밀번호를 입력해 주세요 : ");
				String pw = sc.next();
				System.out.print("이름을 입력해 주세요 : ");
				String name = sc.next();
				lm.InsertCon(id, pw, name);
				
				
			}else if(menu.equals("1")) {
				System.out.print("아이디를 입력해 주세요 : ");
				String id = sc.next();
				System.out.print("비밀번호를 입력해 주세요 : ");
				String pw = sc.next();
				lm.LoginCon(id, pw);
				
				while(flag) {
					System.out.println("[1]게임 시작  [2]새로하기  [3] 이어하기");
					String menu2 = sc.next();
					if(menu2.equals("1")) {
						
					}else if(menu2.equals("2")) {
						
					}else if(menu2.equals("3")) {
						
					}else {
						System.out.println("어허 1~3");
					}
				}
				
				
				
				
			}else {
				System.out.println("어허");
			}
			
		}
		
		System.out.println("끝ㅋㅋ");

	}
	
	

}
