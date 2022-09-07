package view;

import java.util.Scanner;

import controller.Choice;
import controller.Music;
import controller.SigninController;
import model.UserDAO;
import model.UserDTO;

public class main {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		view();

	}

	public static void gameStart(UserDTO dto) {
		Choice ch = new Choice();
		Script scr = new Script();
		UserDAO dao = new UserDAO();
		Music bgm = new Music();// 브금 재생용 객체 컨트롤러에 Music 클래스 있습니다.

		//
		String[] summary = new String[20];
		int index = 0;
		//

		//
		bgm.play(1);
		scr.loadScript(ch.getNext());
		summary[index] = scr.saveSummary(ch.getNext());
		//
		

		while (ch.getNext() <= 110) {
			System.out.println();
			System.out.print("당신의 선택은 >>");
			int i = sc.nextInt();

			scr.loadScript(ch.choice(i));
			dto.setSave(ch.getNext());

			dao.saveData(dto.getSave(), dto.getId());

			//
			index++;
			summary[index] = scr.saveSummary(ch.getNext());
			//

			// if문으로 감쌀꺼
			scr.insertDB(scr.sumSummary(summary), dto.getId());
			// 테스트출력
			System.out.println(scr.getSummary(dto.getId())); // <<== 이게 summary 출력용 코드 지우면 저거 없어짐

			if (ch.getNext() == 52 || ch.getNext() == 110) {
				scr.getSummary(dto.getId());

				scr.loadScript(ch.getNext());
				if (ch.getNext() == 52 || ch.getNext() == 110 || ch.getNext() == 319) {

					break;
				}
			}
		}
	}

	public static void gameStartFrom(int save, UserDTO dto) {
		Choice ch = new Choice();
		Script scr = new Script();
		UserDAO dao = new UserDAO();
		Music bgm = new Music();// 브금 재생용 객체 컨트롤러에 Music 클래스 있습니다.


		//
		bgm.play(1);
		String[] summary = new String[20];
		int index = 0;
		//

		summary[index] = scr.getSummary(dto.getId());
		index++;

		System.out.println("========== 지난 이야기를 불러옵니다 ==========\n");

		ch.setNext(save);
		scr.loadScript(ch.getNext());

		while (ch.getNext() <= 110) {

			while (true) {

				System.out.println();
				// System.out.println("전의 값" + ch.getNext());
				System.out.print("당신의 선택은 >>");
				int i = sc.nextInt();

				dto.setSave(ch.choice(i));
				dao.saveData(dto.getSave(), dto.getId());
				scr.loadScript(ch.getNext());

				//
				index++;
				summary[index] = scr.saveSummary(ch.getNext()); 
				//

				// if문으로 감쌀거?
				scr.insertDB(scr.sumSummary(summary), dto.getId());
				// 테스트출력
				System.out.println(scr.getSummary(dto.getId())); // <<== 이게 summary 출력용 코드 지우면 저거 없어짐
				

				if (ch.getNext() == 52 || ch.getNext() == 110) {
					break;
				}
				dto.setSave(ch.choice(sc.nextInt()));
				dao.saveData(dto.getSave(), dto.getId());

				scr.loadScript(ch.getNext());
				if (ch.getNext() == 52 || ch.getNext() == 110) {
					break;
				}
			}

		}
	}

	public static void view() {

		dotArt art = new dotArt();
		UserDAO dao = new UserDAO();
		UserDTO dto = null;

		SigninController lm = new SigninController();

		boolean flag = true;

//		art.init();
		System.out.println("======아무튼 공포 게임======");
		while (flag) {
			System.out.println();
			System.out.println("[1]로그인  [2]회원가입  [3]종료");

			System.out.print("메뉴를 선택해 주세요 >>");
			String menu = sc.next();

			if (menu.equals("3")) {
				flag = false;
			} else if (menu.equals("2")) {// 회원 가입
				System.out.print("아이디를 입력해 주세요 : ");
				String id = sc.next();
				if (!dao.isOverlapped(id)) {
					System.out.println("사용 가능한 아이디 입니다!");
				} else {
					while (dao.isOverlapped(id)) {
						System.out.print("\n중복된 아이디 입니다!\n다른 아이디를 입력해 주세요>>");
						id = sc.next();
					}
				}

				System.out.print("비밀번호를 입력해 주세요 : ");
				String pw = sc.next();
				System.out.print("이름을 입력해 주세요 : ");
				String name = sc.next();
				lm.InsertCon(id, pw, name);

			} else if (menu.equals("1")) {
				System.out.print("아이디를 입력해 주세요 : ");
				String id = sc.next();
				System.out.print("비밀번호를 입력해 주세요 : ");
				String pw = sc.next();
				dto = new UserDTO(id, pw);
				if (lm.LoginCon(id, pw)) {// 로그인 성공시

					while (flag) {
						System.out.println("\n[1]새로하기  [2]이어하기  [3]로그아웃");
						String menu2 = sc.next();
						if (menu2.equals("1")) {
							gameStart(dto);
						} else if (menu2.equals("2")) {
							if (dao.loadData(id) == 0) {
								System.out.println("지난 플레이 정보가 존재하지 않습니다.");
							} else {
								gameStartFrom(dao.loadData(id), dto);
							}

						} else if (menu2.equals("3")) {
							System.out.println("로그아웃 되었습니다.");
							break;

						} else {
							System.out.println("어허 1~3");
						}
					}
				}

			} else {
				System.out.println("어허 1~3");
			}

		}

		System.out.println("끝ㅋㅋ");
		dao.getClose();

	}

}
