package controller;

import model.UserDAO;
import model.UserDTO;

public class SigninController {
		
		UserDAO dao = new UserDAO();
		
		UserDTO dto; // = new MemberDTO(id, pw); 
		

		
		
		
		
		//메인에서 로그인기능 할때 dao기능 호출 성공 실패 여부 반환
		public boolean LoginCon(String id, String pw) {
			boolean result = dao.login(id, pw);
			
			if(result) {
				System.out.println("로그인 성공");
			}else {
				System.out.println("로그인 실패");
			}
			
			return result;
		}
		
		
		
		// 회원가입이요
		public void InsertCon(String id, String pw, String name) {
			dto = new UserDTO(id, pw, name);
			
			int cnt = dao.insert(dto); //회원가입
			
			if(cnt > 0) {
				System.out.println("회원 가입 성공");
			}else {
				System.out.println("회원 가입 실패");
			}
		}

		public void UpdateCon(String id, String pw) {
			
			dto = new UserDTO(id, pw); // 2
			int cnt = dao.update(dto); // 1
			
			if(cnt > 0) {
				System.out.println("정보 수정");
			}else {
				System.out.println("정보 수정 실패");
			}		
		}

		
		public void SelectCon(String id) {

			dao.select(id);	
		}
		
		public void DeleteCon(String id) {
			int cnt = dao.delete(id);
			if(cnt > 0) {
				System.out.println("회원 삭제");
			}else {
				System.out.println("삭제 실패");
			}
		}
}
