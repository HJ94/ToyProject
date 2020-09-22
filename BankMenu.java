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

	// ���� �Է���ġ
	public int inputNum() {
		int num = new java.util.Scanner(System.in).nextInt();
		return num;
	}

	// ���ڿ� �Է���ġ
	public static String inputStr() {
		return new java.util.Scanner(System.in).next();
	}

	// ȸ������
	int idx;

	public void createUser() {
		System.out.println("------------------");
		System.out.println("	    ȸ������          ");
		System.out.println("------------------");
		System.out.print("ID  : "); 
		String id = input().next();
		
		System.out.print("PW  : ");
		String pw = inputStr();
		
		System.out.print("ȸ���̸� : ");
		String name = inputStr();
		
		System.out.print("�̸��� : ");
		String email = inputStr();
		String regExp = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		boolean result = Pattern.matches(regExp, inputStr());;
		while(result == false) {
			if(result==true) {
				result = true;
				break;
			}else {
				System.out.println("�̸��� ������ �ùٸ��� �ʽ��ϴ�. ex)abcde@naver.com");
				System.out.println();
				System.out.print("�̸����� �ٽ� �Է����ּ��� : ");
				email = inputStr();
				System.out.println();

			}
				
		}
		
		
		System.out.print("��ȭ��ȣ :");
		String phone = inputStr();
		regExp = "(02|010)-\\d{3,4}-\\d{4}";  
		result = Pattern.matches(regExp, inputStr());
	
			if(result) {
				result = true;
			}else {
				System.out.println("��ȭ��ȣ ������ �ùٸ��� �ʽ��ϴ�. \n ex)010-1111-1111 or 02-222-2222");
				result = false;
			}
	
		
//		if(result) {
//			result = true;
//		}else {
//			System.out.println("�̸��� ������ �ùٸ��� �ʽ��ϴ�. \n ex)abcde@naver.com");
//			result = false;
//		}
		
		
		
		int balance = 0;
		System.out.println();
		System.out.println("ȸ������ �Ǿ����ϴ�!");
		System.out.println("------------------");

		Member member = new Member(name, id, pw, email, phone, balance);
		members[idx++] = member;

	}

	// �α���
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
				System.out.println(members[i].getName() + "�� �ݰ����ϴ�.");
				member = members[i];
				return true;
			} else {
				System.out.println("ID�� PW�� ��ġ���� �ʽ��ϴ�.");
				return false;
			}
		}
		return result;
	}

	
	public void findUser() {
		System.out.print("���̵� �Է��ϼ��� : ");
		String id = inputStr();
		
		
		for(int i = 0; i < members.length; i++) {
			if(members[i] == null)
				break;
			if(id.equals(members[i].getId())) {
				System.out.println("��ȸ�Ͻ� ��й�ȣ�� " + members[i].getPw()+ " �Դϴ�.");
				member = members[i];
			}
		}
	}
	

	// ȸ�� ���� ��� ���
	public void memberList() {
		for (Member member : members) {

			if (member != null) {
				System.out.println("ȸ���̸� : " + member.getName());
				System.out.println("���̵�    : " + member.getId());
				System.out.println("��й�ȣ : " + member.getPw());
				System.out.println("�̸��� : " + member.getEmail());
				System.out.println("��ȭ��ȣ : " + member.getPhone());
				System.out.println("�ܰ�      : " + member.getBalance());
			}
			System.out.println();
		}
	}

	// �޴� ��� ���
	public void menu() {
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println(" --------------------------------------------------------");
			System.out.println("| 1.ȸ������  | 2.�α���   | 3.����   | 4.���   | 5.�ܰ�  |  6. PWã��     |");
			
			System.out.println(" --------------------------------------------------------");
			System.out.print("�޴��� �����ϼ��� => ");
			menuNum = inputNum();
			System.out.print("����� ���� : (0 or 1) => ");
			userNum = inputNum();

			switch (menuNum) {

			case 1:
				createUser();
				break;

			case 2:
				login();
				break;

			case 3:
				System.out.print("���ݾ� : ");
				Member member = members[userNum];
				member.setBalance(member.getBalance() + inputNum());
				break;

			case 4:
				System.out.print("��ݾ� : ");

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
