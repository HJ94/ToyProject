package Bank;

import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.*;
//import java.util.Vector;
//import java.util.Enumeration;
//import java.util.Iterator;

public class BankMenu {

	public Scanner scanner;
	int menuNum, userNum;
	boolean re = true;
	// Member members[];
	List list = new Vector();
	// int[] balance_arr = new int[2];
	boolean run;

	public BankMenu() {

		// members = new Member[2];
		run = true;
		scanner = new Scanner(System.in);

	}

	public Scanner input() {
		return scanner;
	}

	// 정수 입력장치
	public int inputNum() {
		int num = new java.util.Scanner(System.in).nextInt();
		return num;
	}

	// 문자열 입력장치
	public static String inputStr() {
		return new java.util.Scanner(System.in).next();
	}

	// 회원가입
	public void createUser() {
		System.out.println("-----------------------");
		System.out.println("	 회원가입          ");
		System.out.println("-----------------------");
		System.out.print("ID  : ");
		String id = input().next();
		System.out.print("PW  : ");
		String pw = inputStr();

		System.out.print("회원이름 : ");
		String name = inputStr();

		System.out.print("이메일 : ");
		String email = inputStr();
		String regExp = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		boolean result = Pattern.matches(regExp, email);
		;
		while (result == false) {
			if (result == true) {
				result = true;
				break;
			} else {
				System.out.println("이메일 형식이 올바르지 않습니다. ex)abcde@naver.com");
				System.out.println();
				System.out.print("이메일을 다시 입력해주세요 : ");
				email = inputStr();
				System.out.println();
				break;
			}

		}
		System.out.print("전화번호 :");
		String phone = inputStr();
		regExp = "(02|010)-\\d{3,4}-\\d{4}";
		result = Pattern.matches(regExp, phone);
		while (result == false) {
			if (result == true) {
				result = true;
				break;
			} else {
				System.out.println("전화번호 형식이 올바르지 않습니다. \n ex)010-1111-1111 or 02-222-2222");
				System.out.println();
				System.out.print("전화번호를 다시 입력해주세요 : ");
				phone = inputStr();
				System.out.println();
				break;
			}
		}

		int balance = 0;
		System.out.println();
		System.out.println("회원가입 되었습니다!");
		System.out.println("------------------");

		list.add(new Member(name, id, pw, email, phone, balance));

//		System.out.println(list.size());
//		for(int i=0; i<list.size(); i++) {
//			System.out.println()
//		}
//		Member member = new Member(name, id, pw, email, phone, balance);
//		members[idx++] = member;

	}

	// 로그인
	Member member;

	public boolean login() {
		System.out.print("ID : ");
		String id = inputStr();
		System.out.print("PW : ");
		String pw = inputStr();

		boolean result = false;

		for (int i = 0; i < list.size(); i++) {
//			String str = (String) list.get(i);

			if (list.get(i) == null)
				break;

			if (id.equals(CreateUser.list.get(i).getId()) && pw.equals(CreateUser.list.get(i).getPw())) {
				System.out.println(CreateUser.list.get(i).getName() + "님 반갑습니다.");
				CreateUser.list.get(i);
				// member = members[i];
				return true;
			} else {
				System.out.println("ID와 PW가 일치하지 않습니다.");
				return false;
			}
		}
		return result;
	}

	public void findUser() {
		new CreateUser();

		System.out.print("아이디를 입력하세요 : ");
		String id = inputStr();

		for (int i = 0; i < list.size(); i++) {
			Object obj = list.get(i);
			Member member = (Member) obj;

			if (list.get(i) == null)
				break;
			if (id.equals(member.id)) {
				System.out.println("조회하신 비밀번호는 " + member.pw + " 입니다.");
				// member = members[i];
			}
		}
	}

	// 회원 정보 출력 기능(비밀번호 찾기)
	public void memberList() {
		for (int i = 0; i < list.size(); i++) {
			Object obj = list.get(i);
			Member member = (Member) obj;
			System.out.println(member.id);
			System.out.println(member.pw);
			System.out.println(member.name);
			System.out.println(member.email);
			System.out.println(member.phone);
			System.out.println(member.balance);
		}
	}

	// 회원 탈퇴 기능
	public void deleteUser() {
		System.out.print("아이디를 입력하세요 : ");
		String id = inputStr();

		for (int i = 0; i < list.size(); i++) {
			Object obj = list.get(i);
			Member member = (Member) obj;
			if (list.get(i) == null)
				break;
			if (id.equals(member.id)) {
				list.remove(i);
				System.out.println("탈퇴되었습니다.");
			}

		}
	}

	// 입금
	public void deposit() {

	}

	// 메뉴 출력 기능
	public void menu() {
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println(" -------------------------------------------------------------------------");
			System.out.println("| 1.회원가입  | 2.로그인   | 3.예금   | 4.출금   | 5.잔고  |  6. PW찾기  |   7. 회원 탈퇴   |");
			System.out.println(" -------------------------------------------------------------------------");
			System.out.print("메뉴를 선택하세요 => ");
			menuNum = inputNum();
//			System.out.print("사용자 선택 : (0 or 1) => ");
//			userNum = inputNum();

			switch (menuNum) {

			case 1:
				createUser();
				break;

			case 2:
				login();
				break;

			case 3:
				System.out.print("예금액 : ");
				// int balance = tf[0].getText;

				break;

			case 4:
				System.out.print("출금액 : ");

				// Member member1 = members[userNum];
				// member1.setBalance(member1.getBalance() - inputNum());
				break;

			case 5:
				memberList();
				break;

			case 6:
				findUser();
				break;

			case 7:
				deleteUser();
			default:
				System.out.println();

			}

		} while (run);
	}

	public static void main(String[] args) {

		BankMenu bank = new BankMenu();
		bank.menu();
	}
}
