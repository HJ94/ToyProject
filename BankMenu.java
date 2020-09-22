package Bank;

import java.util.Scanner;
import java.util.regex.Pattern;

public class BankMenu {

	public Scanner scanner;
	int menuNum, userNum;
	boolean re = true;
	Member members[];

	int[] balance_arr = new int[2];
	boolean run;

	public BankMenu() {
		members = new Member[2];
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
	int idx;

	public void createUser() {
		System.out.println("------------------");
		System.out.println("	    회원가입          ");
		System.out.println("------------------");
		System.out.print("ID  : "); 
		String id = input().next();
		
		System.out.print("PW  : ");
		String pw = inputStr();
		
		System.out.print("회원이름 : ");
		String name = inputStr();
		
		System.out.print("이메일 : ");
		String email = inputStr();
		String regExp = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		boolean result = Pattern.matches(regExp, inputStr());;
		while(result == false) {
			if(result==true) {
				result = true;
				break;
			}else {
				System.out.println("이메일 형식이 올바르지 않습니다. ex)abcde@naver.com");
				System.out.println();
				System.out.print("이메일을 다시 입력해주세요 : ");
				email = inputStr();
				System.out.println();

			}
				
		}
		
		
		System.out.print("전화번호 :");
		String phone = inputStr();
		regExp = "(02|010)-\\d{3,4}-\\d{4}";  
		result = Pattern.matches(regExp, inputStr());
	
			if(result) {
				result = true;
			}else {
				System.out.println("전화번호 형식이 올바르지 않습니다. \n ex)010-1111-1111 or 02-222-2222");
				result = false;
			}
	
		
//		if(result) {
//			result = true;
//		}else {
//			System.out.println("이메일 형식이 올바르지 않습니다. \n ex)abcde@naver.com");
//			result = false;
//		}
		
		
		
		int balance = 0;
		System.out.println();
		System.out.println("회원가입 되었습니다!");
		System.out.println("------------------");

		Member member = new Member(name, id, pw, email, phone, balance);
		members[idx++] = member;

	}

	// 로그인
	Member member;

	public boolean login() {
		System.out.print("ID : ");
		String id = inputStr();
		System.out.print("PW : ");
		String pw = inputStr();

		boolean result = false;

		for (int i = 0; i < members.length; i++) {
			if (members[i] == null)
				break;

			if (id.equals(members[i].getId()) && pw.equals(members[i].getPw())) {
				System.out.println(members[i].getName() + "님 반갑습니다.");
				member = members[i];
				return true;
			} else {
				System.out.println("ID와 PW가 일치하지 않습니다.");
				return false;
			}
		}
		return result;
	}

	
	public void findUser() {
		System.out.print("아이디를 입력하세요 : ");
		String id = inputStr();
		
		
		for(int i = 0; i < members.length; i++) {
			if(members[i] == null)
				break;
			if(id.equals(members[i].getId())) {
				System.out.println("조회하신 비밀번호는 " + members[i].getPw()+ " 입니다.");
				member = members[i];
			}
		}
	}
	

	// 회원 정보 출력 기능
	public void memberList() {
		for (Member member : members) {

			if (member != null) {
				System.out.println("회원이름 : " + member.getName());
				System.out.println("아이디    : " + member.getId());
				System.out.println("비밀번호 : " + member.getPw());
				System.out.println("이메일 : " + member.getEmail());
				System.out.println("전화번호 : " + member.getPhone());
				System.out.println("잔고      : " + member.getBalance());
			}
			System.out.println();
		}
	}

	// 메뉴 출력 기능
	public void menu() {
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println(" --------------------------------------------------------");
			System.out.println("| 1.회원가입  | 2.로그인   | 3.예금   | 4.출금   | 5.잔고  |  6. PW찾기     |");
			
			System.out.println(" --------------------------------------------------------");
			System.out.print("메뉴를 선택하세요 => ");
			menuNum = inputNum();
			System.out.print("사용자 선택 : (0 or 1) => ");
			userNum = inputNum();

			switch (menuNum) {

			case 1:
				createUser();
				break;

			case 2:
				login();
				break;

			case 3:
				System.out.print("예금액 : ");
				Member member = members[userNum];
				member.setBalance(member.getBalance() + inputNum());
				break;

			case 4:
				System.out.print("출금액 : ");

				Member member1 = members[userNum];
				member1.setBalance(member1.getBalance() - inputNum());
				break;

			case 5:
				memberList();
				break;
			
			case 6:
				findUser();
				break;
				
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
