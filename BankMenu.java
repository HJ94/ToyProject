package appEx;

import java.util.Scanner;


public class BankMenu{
	
	Member members[];	
	boolean run;
	
	
	public BankMenu() {
		members = new Member[2];
		run = true;
	}
	
	
	
	//�޴� ����(���� �Է���ġ)
	public int inputNum() {
		int num = new java.util.Scanner(System.in).nextInt();
		return num;
	}
	
	public static String inputStr(){
		return new java.util.Scanner(System.in).next();
	}
	
	
	//ȸ������
	int idx;
	public void createUser(){
		System.out.println("------------------");
		System.out.println("ȸ������");
		System.out.println("------------------");
		System.out.print("ID  : ");
		String id = inputStr(); 
		System.out.print("PW  : ");
		String pw = inputStr();
		System.out.print("ȸ���̸� : ");
		String name = inputStr();
		System.out.print("ȸ���̸� : ");
		int balance = inputNum();
		System.out.println("------------------");
		
		
		Member member = new Member(name, id, pw, balance);
		members[idx++] = member;
		
		
	}
	
	//�α���
	public boolean login() {
		System.out.print("ID : ");
		String id = inputStr();
		System.out.print("PW : ");
		String pw = inputStr();
		
		boolean result = false;
		
		for(int i =0; i < members.length; i++) {
			if(members[i] == null)break;
			if(id.equals(members[i].getId()) && pw.equals(members[i].getPw())) {
				System.out.println(members[i].getName() + "�� �ݰ����ϴ�.");
				return true;
			}else {
				System.out.println("ID�� PW�� ��ġ���� �ʽ��ϴ�.");
				return false;
			}
		}
		return true;
		
	}
	//�Ա�
	public void deposit() {
		
	}
	
	//���
	public void withdraw() {
			
	}
	
	
	
	
	

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		int [] balance_arr = new int[2];
		
		int menuNum, price, price2, usernum, usernum2;
		boolean re = true;
		
		//int munuNum = new java.util.Scanner(System.in).nextInt();
		//int userNum = new java.util.Scanner(System.in).nextInt();
		
		
		
		/*System.out.print("����� ȸ�� ��ȣ�� �Է��ϼ��� : ");
		usernum = scanner.nextInt();
		System.out.println(usernum + "�� �ݰ����ϴ�.");
		*/
		BankMenu bank = new BankMenu();		
		
		do {

			System.out.println(" --------------------------------------------------------");
			System.out.println("| 1.ȸ������  | 2.�α���   | 3.����   | 4.���   | 5.�ܰ� | 6.����     |");
			System.out.println(" --------------------------------------------------------");
			System.out.print("�޴��� �����ϼ��� => ");
			
			menuNum = bank.inputNum();
			//menuNum = scanner.nextInt();
			System.out.print("����� ���� : (0 or 1) => ");
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
				
				
//				System.out.println("���α׷��� �����մϴ�.");
//				re = false;
				
			} else if (menuNum == 5) {
				System.out.println("�ٸ� ȸ������ �α����մϴ�.");
				System.out.println();
				System.out.print("���� ����� ȸ����ȣ�� �Է��ϼ��� : ");
				usernum2 = scanner.nextInt();
				System.out.println(usernum2 + "�� �ݰ����ϴ�.");


			}else{
			
			}

		} while (re == true);

	}
}
