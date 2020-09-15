package appEx;

import java.util.Scanner;


public class BankMenu{
	
	Member members[];
	boolean run;
	public Scanner scanner;
	
	
	
	
	public BankMenu() {
		int [] balance_arr = new int[2];
		members = new Member[2];
		run = true;
		scanner = new Scanner(System.in);
	}
	
	
	
	//정수 입력장치
	public int inputNum() {
		int num = new java.util.Scanner(System.in).nextInt();
		return num;
	}
	//문자열 입력장치
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
		int balance = 0;
		System.out.println("------------------");
		
		
		Member member = new Member(name, id, pw, balance);
		members[idx++] = member;
		
		
		
		
	}
	
	//로그인
	Member member;
	public boolean login() {
		System.out.print("ID : ");
		String id = inputStr();
		System.out.print("PW : ");
		String pw = inputStr();
		
		boolean result = false;
		
		for(int i =0; i < members.length; i++) {
			if(members[i] != null) {
			if(id.equals(members[i].getId()) && pw.equals(members[i].getPw())) {
				System.out.println(members[i].getName() + "님 반갑습니다.");
				member = members[i];
				return true;
			}
		}
	}
	return result;
	}
	public void memberList() {
		for(Member member : members) {
			if(member !=null) {
				System.out.println("회원이름 : " + member.getName());
				System.out.println("아이디 : " + member.getId());
				System.out.println("비밀번호 : " + member.getPw());
				System.out.println("잔고 : " + member.getBalance());
			}
		}
	}
	
		
	//입금
	public void deposit() {
		System.out.println("입금 : ");
		int balance_arr = inputNum();
		
		
	}
	
	//출금
	public void withdraw() {
			
	}
	
	//메뉴 출력 기능
	public void menu() {
		
		do {

			System.out.println(" --------------------------------------------------------");
			System.out.println("| 1.회원가입  | 2.로그인   | 3.예금   | 4.출금   | 5.잔고 |   6.종료     |");
			System.out.println(" --------------------------------------------------------");
			System.out.print("메뉴를 선택하세요 => ");
			
			int menuNum = inputNum();
			
			System.out.print("사용자 선택 : (0 or 1) => ");
			menuNum = inputNum();
			
			switch(menuNum) {
			case 1:
				createUser();
				break;
			case 2:
				login();
				break;
			case 3:
				if(member == null) {
					System.out.println("로그인 및 회원가입을 먼저 하십시오");
					break;
				}
				System.out.print("예금액 : ");
				member.setBalance(member.getBalance() + inputNum());
				break;
			case 4:
				System.out.print("출금액 : ");
				member.setBalance(member.getBalance() - inputNum());
				break;
			case 5:
				System.out.println("잔고 : ");
				System.out.println(member.getBalance());
			case 6:
				run = false;
				break;
			default:
				System.out.println("메뉴를 다시 선택해주세요.");

		}
		System.out.println();
		
	}while (run);
	System.out.println("프로그램 종료");
}
	

	public static void main(String[] args) {
		BankMenu bank = new BankMenu();
		bank.menu();
		

	}
}
