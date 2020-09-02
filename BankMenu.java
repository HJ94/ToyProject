package appEx;

import java.util.Scanner;

public class BankMenu {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		
		//inputnum - 메뉴 선택, price1,2 - 현재 잔액 , usernum1,2 - 
		int inputnum, price, price2, usernum, usernum2;
		boolean re = true;
		int[][] user = new int[2][2];
		
	
		
		
		
		System.out.print("사용할 회원 번호를 입력하세요 : ");
		usernum = scanner.nextInt();
		System.out.println(usernum + "님 반갑습니다.");

		user[0][0]=usernum;

		do {

			System.out.println("--------------------------------------------------------");
			System.out.println("|    1.예금 | 2.출금 | 3.잔고 | 4.종료 | 5. 다른 회원으로 로그인       |");
			System.out.println("--------------------------------------------------------");
			System.out.print("메뉴를 선택하세요 > ");

			inputnum = scanner.nextInt();

			if (inputnum == 1) {
				System.out.print("예금액을 입력하세요 : ");
				price = scanner.nextInt();
				user[0][1] += price;
				System.out.println("예금액 : " + user[0][1] + "원");
				re = true;
				
				System.out.println();

				

			} else if (inputnum == 2) {
				System.out.print("출금액을 입력하세요 : ");
				price = scanner.nextInt();
				user[0][1] -= price;
				System.out.println("출금액 : " + user[0][1] + "원");
				re = true;

			} else if (inputnum == 3) {
				System.out.println(user[0][0]+"님의 현재 잔고는 " + user[0][1] + "원 입니다");
				System.out.println(user[1][0]+"님의 현재 잔고는 " + user[0][1] + "원 입니다");
				re = true;
				
			} else if (inputnum == 4) {
				System.out.println("프로그램을 종료합니다.");
				re = false;
				
			} else if (inputnum == 5) {
				System.out.println("다른 회원으로 로그인합니다.");
				System.out.println();
				System.out.print("새로 사용할 회원번호를 입력하세요 : ");
				usernum2 = scanner.nextInt();
				System.out.println(usernum2 + "님 반갑습니다.");

				user[1][0]=usernum2;

			}else{
			
			}

		} while (re == true);

	}

}
