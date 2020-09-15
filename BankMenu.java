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
	
	
	
	//���� �Է���ġ
	public int inputNum() {
		int num = new java.util.Scanner(System.in).nextInt();
		return num;
	}
	//���ڿ� �Է���ġ
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
		int balance = 0;
		System.out.println("------------------");
		
		
		Member member = new Member(name, id, pw, balance);
		members[idx++] = member;
		
		
		
		
	}
	
	//�α���
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
				System.out.println(members[i].getName() + "�� �ݰ����ϴ�.");
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
				System.out.println("ȸ���̸� : " + member.getName());
				System.out.println("���̵� : " + member.getId());
				System.out.println("��й�ȣ : " + member.getPw());
				System.out.println("�ܰ� : " + member.getBalance());
			}
		}
	}
	
		
	//�Ա�
	public void deposit() {
		System.out.println("�Ա� : ");
		int balance_arr = inputNum();
		
		
	}
	
	//���
	public void withdraw() {
			
	}
	
	//�޴� ��� ���
	public void menu() {
		
		do {

			System.out.println(" --------------------------------------------------------");
			System.out.println("| 1.ȸ������  | 2.�α���   | 3.����   | 4.���   | 5.�ܰ� |   6.����     |");
			System.out.println(" --------------------------------------------------------");
			System.out.print("�޴��� �����ϼ��� => ");
			
			int menuNum = inputNum();
			
			System.out.print("����� ���� : (0 or 1) => ");
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
					System.out.println("�α��� �� ȸ�������� ���� �Ͻʽÿ�");
					break;
				}
				System.out.print("���ݾ� : ");
				member.setBalance(member.getBalance() + inputNum());
				break;
			case 4:
				System.out.print("��ݾ� : ");
				member.setBalance(member.getBalance() - inputNum());
				break;
			case 5:
				System.out.println("�ܰ� : ");
				System.out.println(member.getBalance());
			case 6:
				run = false;
				break;
			default:
				System.out.println("�޴��� �ٽ� �������ּ���.");

		}
		System.out.println();
		
	}while (run);
	System.out.println("���α׷� ����");
}
	

	public static void main(String[] args) {
		BankMenu bank = new BankMenu();
		bank.menu();
		

	}
}
