package appEx;

import java.util.Scanner;


public class BankMenu{
	
	Member members[];	
	boolean run;
	
	
	public BankMenu() {
		members = new Member[2];
		run = true;
	}
	
	
	
	//메뉴 선택(정수 입력장치)
	public int inputNum() {
		int num = new java.util.Scanner(System.in).nextInt();
		return num;
	}
	
	public static String inputStr(){
		return new java.util.Scanner(System.in).next();
	}
	
	
	//회원가입
	int idx;
	public void createUser(){
		System.out.println("------------------");
		System.out.println("회원가입");
		System.out.println("------------------");
		System.out.print("ID  : ");
		String id = inputStr(); 
		System.out.print("PW  : ");
		String pw = inputStr();
		System.out.print("회원이름 : ");
		String name = inputStr();
		System.out.print("회원이름 : ");
		int balance = inputNum();
		System.out.println("------------------");
		
		
		Member member = new Member(name, id, pw, balance);
		members[idx++] = member;
		
		
	}
	
	//로그인
	public boolean login() {
		System.out.print("ID : ");
		String id = inputStr();
		System.out.print("PW : ");
		String pw = inputStr();
		
		boolean result = false;
		
		for(int i =0; i < members.length; i++) {
			if(members[i] == null)break;
			if(id.equals(members[i].getId()) && pw.equals(members[i].getPw())) {
				System.out.println(members[i].getName() + "님 반갑습니다.");
				return true;
			}else {
				System.out.println("ID와 PW가 일치하지 않습니다.");
				return false;
			}
		}
		return true;
		
	}
	//입금
	public void deposit() {
		
	}
	
	//출금
	public void withdraw() {
			
	}
	
	
	
	
	

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int [] balance_arr = new int[2];
		
		int menuNum, price, price2, usernum, usernum2;
		boolean re = true;
		
		//int munuNum = new java.util.Scanner(System.in).nextInt();
		//int userNum = new java.util.Scanner(System.in).nextInt();
		
		
		
		/*System.out.print("사용할 회원 번호를 입력하세요 : ");
		usernum = scanner.nextInt();
		System.out.println(usernum + "님 반갑습니다.");
		*/
		BankMenu bank = new BankMenu();		
		
		do {

			System.out.println(" --------------------------------------------------------");
			System.out.println("| 1.회원가입  | 2.로그인   | 3.예금   | 4.출금   | 5.잔고 | 6.종료     |");
			System.out.println(" --------------------------------------------------------");
			System.out.print("메뉴를 선택하세요 => ");
			
			menuNum = bank.inputNum();
			//menuNum = scanner.nextInt();
			System.out.print("사용자 선택 : (0 or 1) => ");
			int userNum = bank.inputNum();
			
			
			
			if (menuNum == 1) {
				bank.createUser();
								

			} else if (menuNum == 2) {
				bank.login();

			} else if (menuNum == 3) {
				deposit();
				
//				System.out.println(balance_arr[userNum]);
//				re = true;
				
			} else if (menuNum == 4) {
				withdraw();
				
				
//				System.out.println("프로그램을 종료합니다.");
//				re = false;
				
			} else if (menuNum == 5) {
				System.out.println("다른 회원으로 로그인합니다.");
				System.out.println();
				System.out.print("새로 사용할 회원번호를 입력하세요 : ");
				usernum2 = scanner.nextInt();
				System.out.println(usernum2 + "님 반갑습니다.");


			}else{
			
			}

		} while (re == true);

	}
}
