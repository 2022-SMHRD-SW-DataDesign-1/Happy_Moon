package controller;

import model.UserDAO;
import model.UserDTO;

public class SigninController {
		
		// DAO에 접근할 수 있는 객체 생성
		UserDAO dao = new UserDAO();
		
		// DTO에 접근할 수 있는 객체 생성
		UserDTO dto; // = new MemberDTO(id, pw); // 여러게 메소드있음 -> 선택해야함 , 구체적인 매개변수의 개수는 기능에 따라 다르게 주겟다
		

		// Main 메소드에서 로그인을 실행 시
		// 아이디와 비밀번호를 받아와 DAO 로 연결해주는 메소드 생성
		
		
		
		
		//dao랑 controller랑 주고받기 로그인은 성공하였는가
		public boolean LoginCon(String id, String pw) {
			// DAO에 있는 login()
			boolean result = dao.login(id, pw);
			
			// 로그인 기능은 현재 가지고 있는 member 테이블에 
			// id, pw와 동일하게 들어가 있는 내용이 있는지 없는지 확인 후
			// 결과값 반환
			if(result) { // cnt로도 바꿔보기
				System.out.println("로그인 성공");
			}else {
				System.out.println("로그인 실패");
			}
			
			return result;
		}
		
		
		//회원가입을할꺼여
		public void InsertCon(String id, String pw, String name) {
			dto = new UserDTO(id, pw, name); // 생성자 메소드
			
			int cnt = dao.insert(dto); // sql만들기
			
			if(cnt > 0) {
				System.out.println("회원가입 성공");
			}else {
				System.out.println("회원가입 실패");
			}
		}

		//회원정보 수정 ㅋㅋ~ id랑 패스워드 바꿈
		public void UpdateCon(String id, String pw) {
			
			dto = new UserDTO(id, pw); // 2
			int cnt = dao.update(dto); // 1
			
			if(cnt > 0) {
				System.out.println("회원정보 수정완료");
			}else {
				System.out.println("회원정보 수정실패");
			}		
		}

		
		//특정인물 아이디로 찾기
		public void SelectCon(String id) {

			dao.select(id);	
		}
		
		//회원 탈퇴
		public void DeleteCon(String id) {
			int cnt = dao.delete(id);
			if(cnt > 0) {
				System.out.println("탈퇴 성공");
			}else {
				System.out.println("탈퇴 실패");
			}
		}
}
