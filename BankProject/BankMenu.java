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
	public void createUser() {
		System.out.println("-----------------------");
		System.out.println("	 ȸ������          ");
		System.out.println("-----------------------");
		System.out.print("ID  : ");
		String id = input().next();
		System.out.print("PW  : ");
		String pw = inputStr();

		System.out.print("ȸ���̸� : ");
		String name = inputStr();

		System.out.print("�̸��� : ");
		String email = inputStr();
		String regExp = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		boolean result = Pattern.matches(regExp, email);
		;
		while (result == false) {
			if (result == true) {
				result = true;
				break;
			} else {
				System.out.println("�̸��� ������ �ùٸ��� �ʽ��ϴ�. ex)abcde@naver.com");
				System.out.println();
				System.out.print("�̸����� �ٽ� �Է����ּ��� : ");
				email = inputStr();
				System.out.println();
				break;
			}

		}
		System.out.print("��ȭ��ȣ :");
		String phone = inputStr();
		regExp = "(02|010)-\\d{3,4}-\\d{4}";
		result = Pattern.matches(regExp, phone);
		while (result == false) {
			if (result == true) {
				result = true;
				break;
			} else {
				System.out.println("��ȭ��ȣ ������ �ùٸ��� �ʽ��ϴ�. \n ex)010-1111-1111 or 02-222-2222");
				System.out.println();
				System.out.print("��ȭ��ȣ�� �ٽ� �Է����ּ��� : ");
				phone = inputStr();
				System.out.println();
				break;
			}
		}

		int balance = 0;
		System.out.println();
		System.out.println("ȸ������ �Ǿ����ϴ�!");
		System.out.println("------------------");

		list.add(new Member(name, id, pw, email, phone, balance));

//		System.out.println(list.size());
//		for(int i=0; i<list.size(); i++) {
//			System.out.println()
//		}
//		Member member = new Member(name, id, pw, email, phone, balance);
//		members[idx++] = member;

	}

	// �α���
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
				System.out.println(CreateUser.list.get(i).getName() + "�� �ݰ����ϴ�.");
				CreateUser.list.get(i);
				// member = members[i];
				return true;
			} else {
				System.out.println("ID�� PW�� ��ġ���� �ʽ��ϴ�.");
				return false;
			}
		}
		return result;
	}

	public void findUser() {
		new CreateUser();

		System.out.print("���̵� �Է��ϼ��� : ");
		String id = inputStr();

		for (int i = 0; i < list.size(); i++) {
			Object obj = list.get(i);
			Member member = (Member) obj;

			if (list.get(i) == null)
				break;
			if (id.equals(member.id)) {
				System.out.println("��ȸ�Ͻ� ��й�ȣ�� " + member.pw + " �Դϴ�.");
				// member = members[i];
			}
		}
	}

	// ȸ�� ���� ��� ���(��й�ȣ ã��)
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

	// ȸ�� Ż�� ���
	public void deleteUser() {
		System.out.print("���̵� �Է��ϼ��� : ");
		String id = inputStr();

		for (int i = 0; i < list.size(); i++) {
			Object obj = list.get(i);
			Member member = (Member) obj;
			if (list.get(i) == null)
				break;
			if (id.equals(member.id)) {
				list.remove(i);
				System.out.println("Ż��Ǿ����ϴ�.");
			}

		}
	}

	// �Ա�
	public void deposit() {

	}

	// �޴� ��� ���
	public void menu() {
		Scanner scanner = new Scanner(System.in);

		do {
			System.out.println(" -------------------------------------------------------------------------");
			System.out.println("| 1.ȸ������  | 2.�α���   | 3.����   | 4.���   | 5.�ܰ�  |  6. PWã��  |   7. ȸ�� Ż��   |");
			System.out.println(" -------------------------------------------------------------------------");
			System.out.print("�޴��� �����ϼ��� => ");
			menuNum = inputNum();
//			System.out.print("����� ���� : (0 or 1) => ");
//			userNum = inputNum();

			switch (menuNum) {

			case 1:
				createUser();
				break;

			case 2:
				login();
				break;

			case 3:
				System.out.print("���ݾ� : ");
				// int balance = tf[0].getText;

				break;

			case 4:
				System.out.print("��ݾ� : ");

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
