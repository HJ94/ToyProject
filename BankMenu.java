package appEx;

import java.util.Scanner;

public class BankMenu {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		//inputnum - �޴� ����, price1,2 - ���� �ܾ� , usernum1,2 - 
		int inputnum, price, price2, usernum, usernum2;
		boolean re = true;
		int[][] user = new int[2][2];
		
	
		
		
		
		System.out.print("����� ȸ�� ��ȣ�� �Է��ϼ��� : ");
		usernum = scanner.nextInt();
		System.out.println(usernum + "�� �ݰ����ϴ�.");

		user[0][0]=usernum;

		do {

			System.out.println("--------------------------------------------------------");
			System.out.println("|    1.���� | 2.��� | 3.�ܰ� | 4.���� | 5. �ٸ� ȸ������ �α���       |");
			System.out.println("--------------------------------------------------------");
			System.out.print("�޴��� �����ϼ��� > ");

			inputnum = scanner.nextInt();

			if (inputnum == 1) {
				System.out.print("���ݾ��� �Է��ϼ��� : ");
				price = scanner.nextInt();
				user[0][1] += price;
				System.out.println("���ݾ� : " + user[0][1] + "��");
				re = true;
				
				System.out.println();

				

			} else if (inputnum == 2) {
				System.out.print("��ݾ��� �Է��ϼ��� : ");
				price = scanner.nextInt();
				user[0][1] -= price;
				System.out.println("��ݾ� : " + user[0][1] + "��");
				re = true;

			} else if (inputnum == 3) {
				System.out.println(user[0][0]+"���� ���� �ܰ�� " + user[0][1] + "�� �Դϴ�");
				System.out.println(user[1][0]+"���� ���� �ܰ�� " + user[0][1] + "�� �Դϴ�");
				re = true;
				
			} else if (inputnum == 4) {
				System.out.println("���α׷��� �����մϴ�.");
				re = false;
				
			} else if (inputnum == 5) {
				System.out.println("�ٸ� ȸ������ �α����մϴ�.");
				System.out.println();
				System.out.print("���� ����� ȸ����ȣ�� �Է��ϼ��� : ");
				usernum2 = scanner.nextInt();
				System.out.println(usernum2 + "�� �ݰ����ϴ�.");

				user[1][0]=usernum2;

			}else{
			
			}

		} while (re == true);

	}

}
