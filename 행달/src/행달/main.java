package 행달;

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
		UserDAO dao = new UserDAO();  // 나중에 올리기
		UserDTO dto = null;
		
		// controller에 접근할 수 있는 객체 생성
		SigninController lm = new SigninController();
		
		Scanner sc= new Scanner(System.in);
		boolean flag = true;
		
		//어떤 형태로 화면을 구성할 것인가?
		art.init();
		System.out.println("======아무튼 공포게임이여======");
		while(flag) {
			System.out.println();
			//메뉴 출력
			System.out.println("[1]로그인 [2]회원가입 [3]종료");
			//로그인 -> select, 회원가입->insert, 정보수정 ->update, 조회->select , 회원 탈퇴->delete.4
			
			System.out.print("메뉴를 선택 해주세요 >>");
			String menu = sc.next();
			
			if(menu.equals("3")) {
				flag=false;
			}else if(menu.equals("2")) {//회원가입
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();
				System.out.print("이름 입력 : ");
				String name = sc.next();
				lm.InsertCon(id, pw, name);
				
				
			}else if(menu.equals("1")) {//로그인
				System.out.print("아이디 입력 : ");
				String id = sc.next();
				System.out.print("비밀번호 입력 : ");
				String pw = sc.next();
				lm.LoginCon(id, pw);
				
				
			}else {
				System.out.println("어허 1~3 -> 조금 오만하셨습니다.");
			}
			
		}
		
		System.out.println("종 료 오 오 오오오오오");
	}

}
