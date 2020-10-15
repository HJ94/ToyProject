package Bank;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import DB.DBAction;

public class MainLayout extends Frame implements ActionListener {
	// List<Member> list = new Vector<>();
	Frame fr5 = new Frame();
	Frame fr2 = new Frame();
	Panel[] p = new Panel[30];
	Label[] l = new Label[200];
	JButton[] b = new JButton[50];
	TextField[] tf = new TextField[30];
	Dialog dialog1, dialog2;
	Image img;
	String UserName, UserAccount , Account, UserId, ac, name, idd, pww, email, phone, account, balance;
	int UserBalance=0, MyBalance, deposit, withdraw, Balance;
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/app?characterEnconding=UTF-8&serverTimezone=UTC"; // url 정보
	Statement stmt = null;
	ResultSet rs = null;
	DBAction db = DBAction.getInstance();
	Connection conn = db.getConnection();
	ResultSetMetaData rsmd = null;

	public MainLayout() {
		
		String id = Bank_Layout.tf[0].getText();
		String pw = Bank_Layout.tf[1].getText();
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "java");
			stmt = conn.createStatement();
			String sql = "select * from member";
			rs = stmt.executeQuery(sql);
			while(rs.next()) {
				if(id.equals(rs.getString("ID")) && pw.equals(rs.getString("PW"))) {
					UserName = rs.getString("NAME");
					UserAccount = rs.getString("ACCOUNT");
					//UserBalance = rs.getInt("BALANCE");
				}
			}
		}catch(Exception e) {
			System.out.println("데이터 찾기 실패");
		}finally {
			try {
				if(rs != null)rs.close();
				if(stmt != null)stmt.close();
				if(conn != null)conn.close();
			}catch(Exception e) {}
		}


		dialog1 = new Dialog(this);
		dialog2 = new Dialog(this);

		img = Toolkit.getDefaultToolkit().getImage("C:/data/piggy.jpg");

		p[0] = new Panel();
		p[0].setLayout(new BorderLayout());
		p[1] = new Panel();
		p[1].setLayout(new GridLayout(2, 3));
		l[0] = new Label("");
		l[1] = new Label("Pig Bank");
		l[1].setFont(new Font("Serif", Font.BOLD, 40));
		l[2] = new Label("");
		l[3] = new Label("");
		l[4] = new Label(UserName + "님 의 계좌");
		l[4].setFont(new Font("Serif", Font.BOLD, 20));
		l[5] = new Label("");

		p[1].add(l[0]);
		p[1].add(l[1]);
		p[1].add(l[2]);
		p[1].add(l[3]);
		p[1].add(l[4]);
		p[1].add(l[5]);
		p[0].add(p[1], "North");

		//
		p[2] = new Panel();
		//p[2].setBackground(Color.yellow);
		p[2].setLayout(new GridLayout(3,3));
//		b[0] = new Button("예금");
//		b[1] = new Button("출금");
//		b[2] = new Button("로그아웃");
//		b[6] = new Button("회원 탈퇴");
		l[50] = new Label("");
		l[51] = new Label(UserAccount);
		l[51].setFont(new Font("홍익인간", Font.BOLD, 20));
		l[52] = new Label("");
		l[53] = new Label("");
		l[54] = new Label(Integer.toString(UserBalance) + "원");
		l[54].setFont(new Font("홍익인간", Font.BOLD, 25));
		l[55] = new Label("");
		l[56] = new Label("");
		l[57] = new Label("");
		l[58] = new Label("");
		
		
		p[2].add(l[50]);
		p[2].add(l[51]);
		p[2].add(l[52]);
		
		p[2].add(l[53]);
		p[2].add(l[54]);
		p[2].add(l[55]);
		
		p[2].add(l[56]);
		p[2].add(l[57]);
		p[2].add(l[58]);

//		p[2].add(b[0]);
//		p[2].add(b[1]);
//		p[2].add(b[2]);
//		p[2].add(b[6]);
		p[0].add(p[2], "Center");
		
		
		p[3] = new Panel();
		p[3].setLayout(new GridLayout(4,2));
		
		
		b[10]= new JButton("입금");
		b[11]= new JButton("출금");
		b[12]= new JButton("개인 정보 변경");
		b[13]= new JButton("잔액 조회");
		b[14]= new JButton("로그아웃");
		b[15]= new JButton("계정삭제");
		b[18]= new JButton("저축");
		b[19]= new JButton("내 정보 보기");
		
		p[3].add(b[18]);
		p[3].add(b[10]);
		p[3].add(b[11]);
		p[3].add(b[12]);
		p[3].add(b[13]);
		p[3].add(b[14]);
		p[3].add(b[15]);
		p[3].add(b[19]);
		
//		l[6] = new Label("예금");
//		l[7] = new Label(" ");
//		// 입금
//		tf[0] = new TextField();
//		b[3] = new Button("입금");
//		l[8] = new Label("출금");
//		l[9] = new Label(" ");
//		// 출금
//		tf[1] = new TextField();
//		b[4] = new Button("출금");
//		l[10] = new Label("잔액 조회");
//		l[11] = new Label(" ");
//		// 잔고
//		String Bal = Integer.toString(UserBalance);
//		l[13] = new Label(UserBalance + "원"); // tf[2] = new TextField(UserBalance);
//		b[5] = new Button("조회");
//		//tf[2] = new TextField();
		
		/*
		p[3].add(l[6]);
		p[3].add(l[7]);
		p[3].add(tf[0]);
		p[3].add(b[3]);
		p[3].add(l[8]);
		p[3].add(l[9]);
		p[3].add(tf[1]);
		p[3].add(b[4]);
		p[3].add(l[10]);
		p[3].add(l[11]);
		p[3].add(l[13]);
		//p[3].add(tf[2]);
		p[3].add(b[5]);
		*/
		
		p[0].add(p[3], "South");

		//<저축>
		b[18].addActionListener(this);
		b[18].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Saving();
				b[20].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String id = Bank_Layout.tf[0].getText();
						String pw = Bank_Layout.tf[0].getText();

						try {
							Class.forName(driver);
							conn = DriverManager.getConnection(url, "root", "java");
							stmt = conn.createStatement();
							String sql = "select * from member";
							rs = stmt.executeQuery(sql);
							while(rs.next()) {
								if(id.equals(rs.getString("ID")) && pw.equals(rs.getString("PW"))) {
									UserBalance = rs.getInt("BALANCE");
									UserName = rs.getString("NAME");
								}
							}
							UserBalance += Integer.parseInt(tf[10].getText());
							String sql2 = "update member set BALANCE = '" + UserBalance + "'WHERE ID = '" + UserName + "'" ;
							int result = stmt.executeUpdate(sql2);
							String msg = result > -1 ? "successful" : "fail";
							System.out.println(msg);
							}catch(Exception ex) {
							System.out.println("데이터 찾기 실패");
						}finally {
							try {
								if(rs != null)rs.close();
								if(stmt != null)stmt.close();
								if(conn != null)conn.close();
							}catch(Exception ex) {}
						}
						JOptionPane.showMessageDialog(null, "저축되었습니다.");
					}
						});
				
			}
		});
		// 닫기
		fr5.addWindowListener(new WindowAdapter() { // 모바일에서 많이 사용(내부 익명)
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
		// <입금>
		b[10].addActionListener(this);
		b[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deposit();	
				b[16].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String id = Bank_Layout.tf[0].getText();
						String pw = Bank_Layout.tf[0].getText();
						String Account = tf[9].getText();
						try {
							Class.forName(driver);
							conn = DriverManager.getConnection(url, "root", "java");
							stmt = conn.createStatement();
							String sql = "select * from member";
							rs = stmt.executeQuery(sql);
							//MyBalance - 로그인 화면에서 입력한 ID와 PW가 일치하는 사용자의 잔고를 가져옴
							while(rs.next()) {
								if(id.equals(rs.getString("ID")) && pw.equals(rs.getString("PW"))) {
									MyBalance = rs.getInt("BALANCE");
									UserAccount = rs.getString("ACCOUNT");
								}								
							}
							System.out.println("로그인한 사용자 잔고 : " + MyBalance);
							
							//UserAccount - 내가 입력한 다른 사용자 계좌
							//UserBalance - 내가 이체하려고하는 사용자의 계좌 잔액
							rs = stmt.executeQuery(sql);
							while(rs.next()) {
								if(Account.equals(rs.getString("ACCOUNT"))) {
									Balance = rs.getInt("BALANCE");
									UserId = rs.getString("ID");
									Account = rs.getString("ACCOUNT");
 									break;
								}
							}
							System.out.println("내가 입력한 다른 사용자 계좌 : "+Account); 
							System.out.println("내가 입력한 다른 사용자 계좌 잔액 : " + Balance);
							System.out.println("내가 입력한 다른 사용자의 ID : " + UserId);
							
							//내 잔고가 입력한 금액보다 크면 송금하고 내 잔고를 입력한 금액만큼 차감시킴 
							if(MyBalance >= Integer.parseInt(tf[5].getText())) {
								Balance += Integer.parseInt(tf[5].getText());
								MyBalance -= Integer.parseInt(tf[5].getText());
								JOptionPane.showMessageDialog(null, "입금되었습니다.");
								fr2.setVisible(false);
							}else {
								JOptionPane.showMessageDialog(null, "잔액이 부족합니다.");
							}
							
							String sql2 = "update member set BALANCE = '" + Balance + "'WHERE ACCOUNT = '" + Account + "'" ;
							int result = stmt.executeUpdate(sql2);
							String sql3 = "update member set BALANCE = '" + MyBalance + "'WHERE ACCOUNT = '" + UserAccount + "'" ;
							int result2 = stmt.executeUpdate(sql3);
							String msg = result > -1 ? "successful" : "fail";
							System.out.println(msg);
							}catch(Exception ex) {
							System.out.println("데이터 찾기 실패");
						}finally {
							try {
								if(rs != null)rs.close();
								if(stmt != null)stmt.close();
								if(conn != null)conn.close();
							}catch(Exception ex) {}
						}
					}
					
						});
			}	
		});
		// 닫기
		fr2.addWindowListener(new WindowAdapter() { // 모바일에서 많이 사용(내부 익명)
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
//		// <출금>
		b[11].addActionListener(this);
		b[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Withdraw();
				b[17].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String id = Bank_Layout.tf[0].getText();
						String pw = Bank_Layout.tf[0].getText();

						try {
							Class.forName(driver);
							conn = DriverManager.getConnection(url, "root", "java");
							stmt = conn.createStatement();
							String sql = "select * from member";
							rs = stmt.executeQuery(sql);
							while(rs.next()) {
								if(id.equals(rs.getString("ID")) && pw.equals(rs.getString("PW"))) {
									UserBalance = rs.getInt("BALANCE");
								}
							}
							UserBalance -= Integer.parseInt(tf[6].getText());
							String sql2 = "update member set BALANCE = '" + UserBalance + "'WHERE ID = '" + UserName + "'" ;
							int result = stmt.executeUpdate(sql2);
							String msg = result > -1 ? "successful" : "fail";
							System.out.println(msg);
							}catch(Exception ex) {
							System.out.println("데이터 찾기 실패");
						}finally {
							try {
								if(rs != null)rs.close();
								if(stmt != null)stmt.close();
								if(conn != null)conn.close();
							}catch(Exception ex) {}
						}
						JOptionPane.showMessageDialog(null, "출금되었습니다.");
					}
						});
				
			}
		});
//
//		// <잔액 조회>
		b[13].addActionListener(this);
		b[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName(driver);
					conn = DriverManager.getConnection(url, "root", "java");
					stmt = conn.createStatement();
					String sql = "select * from member";
					rs = stmt.executeQuery(sql);
					while(rs.next()) {
						if(id.equals(rs.getString("ID")) && pw.equals(rs.getString("PW"))) {
							UserBalance = rs.getInt("BALANCE");
						}
					}
					l[54].setText(Integer.toString(UserBalance) + "원");
					}catch(Exception ex) {
					System.out.println("데이터 찾기 실패");
				}finally {
					try {
						if(rs != null)rs.close();
						if(stmt != null)stmt.close();
						if(conn != null)conn.close();
					}catch(Exception ex) {}
				}
				l[54].setText(Integer.toString(UserBalance) + "원");
			}
		});
//		// <로그아웃>
		b[14].addActionListener(this);
		b[14].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "로그아웃 되었습니다.");
				new Bank_Layout();
				setVisible(false);
			}
		});
		//<개인 정보 변경> - Update
		b[12].addActionListener(this);
		b[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeInfo();
				b[9].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String changepw = tf[18].getText();
						String changeid = tf[7].getText();
						
						try {
							Class.forName(driver);
							conn = DriverManager.getConnection(url, "root", "java");
							stmt = conn.createStatement();
							System.out.println(changepw);
							System.out.println(changeid);
							String sql = "UPDATE MEMBER SET PW ='"+ changepw + "'WHERE ID ='" + changeid + "'" ;
							int result = stmt.executeUpdate(sql);
						}catch(Exception ex) {
							System.out.println("데이터 찾기 실패");
						}finally {
							try {
								if(rs != null)rs.close();
								if(stmt != null)stmt.close();
								if(conn != null)conn.close();
							}catch(Exception ex) {}
						}
					}
				});
			}	
		});	
		
		//<내 정보 보기>
		b[19].addActionListener(this);
		b[19].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserInfo();
				String id = Bank_Layout.tf[0].getText();
				String pw = Bank_Layout.tf[0].getText();
				try {
					Class.forName(driver);
					conn = DriverManager.getConnection(url, "root", "java");
					stmt = conn.createStatement();
					String sql = "select * from member WHERE ID = '" + id + "'AND PW='" + pw + "'";
					rs = stmt.executeQuery(sql);

					while(rs.next()) {
						name = rs.getString("NAME");
						idd = rs.getString("ID");
						pww = rs.getString("PW");
						email = rs.getString("EMAIL");
						phone = rs.getString("PHONE");
						balance = rs.getString("BALANCE");
						account = rs.getString("ACCOUNT");
					}
					System.out.println(name);
							
						
					
					l[148].setText(name);
					l[149].setText(idd);
					l[150].setText(pww);
					l[151].setText(email);
					l[152].setText(phone);
					l[153].setText(balance);
					l[154].setText(account);
					
				}catch(Exception ex) {
					ex.printStackTrace();
				}finally {
					try {
						if(rs != null)rs.close();
						if(stmt != null)stmt.close();
						if(conn != null)conn.close();
					}catch(Exception ex) {}
				}
			}	
		});	
		
		
//		
//		//<회원 탈퇴>
//		b[6].addActionListener(this);
//		b[6].addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				DeleteUser();
//			}	
//		});		
		
		add(p[0]);
		setSize(500, 500);
		setVisible(true);

//		b[0].addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// login();
//				setVisible(true);
//			}
//		});

		// 닫기
		addWindowListener(new WindowAdapter() { // 모바일에서 많이 사용(내부 익명)
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
//		b[21].addActionListener(this);
//		b[21].addActionListener(new ActionListener() { 
//			public void actionPerformed(ActionEvent arg0) { 
//				System.exit(0); 
//				} 
//			});

		
		
		//<회원 정보 삭제>
		b[15].addActionListener(this);
		b[15].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteUser();
				b[7].addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					String id = tf[3].getText();
					String pw = tf[4].getText();	
					try
					{
						Class.forName(driver);
						conn = DriverManager.getConnection(url, "root", "java");
						stmt = conn.createStatement();
						String sql = "DELETE FROM member WHERE ID = '" + id + "' AND PW = '" + pw + "'";
						int result = stmt.executeUpdate(sql);
						String msg = result > -1 ? "successful" : "fail";
						System.out.println(msg);
					}catch(
					Exception ex)
					{
						ex.printStackTrace();
					}finally
					{
						try {
							if (stmt != null)
								stmt.close();
							if (conn != null)
								conn.close();
						} catch (Exception ex) {
						}
					}
					JOptionPane.showMessageDialog(null, "삭제되었습니다.");
					}
				});			
			}
			
		});	
	}// MainLayout () end

	

	public void Deposit() {
		Frame fr2 = new Frame();
		p[6] = new Panel();
		p[6].setLayout(new GridLayout(4, 3));

		l[59] = new Label("");
		l[60] = new Label("입금하기");
		l[61] = new Label("");

		l[62] = new Label("금액 입력");
		tf[5] = new TextField();
		b[16] = new JButton("입금");

		l[97] = new Label("계좌번호 입력");
		tf[9] = new TextField();
		l[98] = new Label("");
		
		l[65] = new Label("");
		l[66] = new Label("");
		l[67] = new Label("");

		p[6].add(l[59]);
		p[6].add(l[60]);
		p[6].add(l[61]);

		p[6].add(l[62]);
		p[6].add(tf[5]);
		p[6].add(b[16]);
		
		p[6].add(l[97]);
		p[6].add(tf[9]);
		p[6].add(l[98]);

		p[6].add(l[65]);
		p[6].add(l[66]);
		p[6].add(l[67]);

		fr2.add(p[6]);

		fr2.setSize(350, 200);
		fr2.setVisible(true);
	}

	public void Withdraw() {
		Frame fr3 = new Frame();
		p[7] = new Panel();
		p[7].setLayout(new GridLayout(3, 3));

		l[68] = new Label("");
		l[69] = new Label("출금하기");
		l[70] = new Label("");

		l[71] = new Label("금액 입력");
		tf[6] = new TextField();
		b[17] = new JButton("출금");

		l[72] = new Label("");
		l[73] = new Label("");
		l[74] = new Label("");

		p[7].add(l[68]);
		p[7].add(l[69]);
		p[7].add(l[70]);

		p[7].add(l[71]);
		p[7].add(tf[6]);
		p[7].add(b[17]);

		p[7].add(l[72]);
		p[7].add(l[73]);
		p[7].add(l[74]);

		fr3.add(p[7]);
		fr3.setSize(350, 200);
		fr3.setVisible(true);
	}
	//회원 정보 변경
	public void ChangeInfo() {
		Frame fr4 = new Frame();
		p[8] = new Panel();
		fr4.setLayout(new BorderLayout());
		p[8].setLayout(new GridLayout(1,3));
		
		l[75] = new Label("회원 정보 변경");
		l[75].setFont(new Font("Bodeni MT Black", Font.BOLD, 20));
		l[76] = new Label("");
		l[77] = new Label("");
		
		p[8].add(l[76]);
		p[8].add(l[75]);
		p[8].add(l[77]);
		fr4.add(p[8], "North");
		
		p[9] = new Panel();
		p[9].setLayout(new GridLayout(5,4));
		
		l[78] = new Label("");
		l[79] = new Label("");
		l[80] = new Label("");
		l[81] = new Label("");
		
		l[82] = new Label("");
		l[83] = new Label("ID : ");
		tf[7] = new TextField();
		l[84] = new Label("");
		
		l[85] = new Label("");
		l[86] = new Label("PW : ");
		tf[8] = new TextField();
		l[87] = new Label("");
		
		l[88] = new Label("");
		l[89] = new Label("변경할 PW 입력 : ");
		tf[18] = new TextField();
		//l[90] = new Label("");
		l[91] = new Label("");
		
		l[92] = new Label("");
		b[9] = new JButton("확인");
		b[21] = new JButton("취소");
		l[93] = new Label("");
		
		p[9].add(l[78]);
		p[9].add(l[79]);
		p[9].add(l[80]);
		p[9].add(l[81]);
		
		p[9].add(l[82]);
		p[9].add(l[83]);
		p[9].add(tf[7]);
		p[9].add(l[84]);
		
		p[9].add(l[85]);
		p[9].add(l[86]);
		p[9].add(tf[8]);
		p[9].add(l[87]);
		
		p[9].add(l[88]);
		p[9].add(l[89]);
		p[9].add(tf[18]);
		//p[9].add(l[90]);
		p[9].add(l[91]);
		
		p[9].add(l[92]);
		p[9].add(b[9]);
		p[9].add(b[21]);
		p[9].add(l[93]);
		
		l[94] = new Label("");
		l[95] = new Label("");
		l[96] = new Label("");
		
		fr4.add(p[9], "Center");
		fr4.add(l[94], "East");
		fr4.add(l[95], "West");
		fr4.add(l[96], "South");
		
		fr4.setSize(300,300);
		fr4.setVisible(true);
		
	}

	// 회원 정보 삭제 메서드
	public void DeleteUser() {
		Frame fr = new Frame();
		p[4] = new Panel();
		fr.setLayout(new BorderLayout());
		p[4].setLayout(new GridLayout(1, 3));

		l[14] = new Label("회원 탈퇴");
		l[14].setFont(new Font("Bodeni MT Black", Font.BOLD, 20));
		l[15] = new Label("");
		l[16] = new Label("");

		p[4].add(l[15]);
		p[4].add(l[14]);
		p[4].add(l[16]);
		fr.add(p[4], "North");

		p[5] = new Panel();
		p[5].setLayout(new GridLayout(5, 4));

		l[17] = new Label("");
		l[18] = new Label("");
		l[19] = new Label("");
		l[20] = new Label("");

		l[21] = new Label("");
		l[22] = new Label("ID : ");
		tf[3] = new TextField();
		l[23] = new Label("");

		l[24] = new Label("");
		l[25] = new Label("PW : ");
		tf[4] = new TextField();
		l[26] = new Label("");

		l[27] = new Label("");
		l[28] = new Label("");
		l[29] = new Label("");
		l[30] = new Label("");

		l[31] = new Label("");
		b[7] = new JButton("확인");
		b[8] = new JButton("취소");
		l[32] = new Label("");

		p[5].add(l[17]);
		p[5].add(l[18]);
		p[5].add(l[19]);
		p[5].add(l[20]);

		p[5].add(l[21]);
		p[5].add(l[22]);
		p[5].add(tf[3]);
		p[5].add(l[23]);

		p[5].add(l[24]);
		p[5].add(l[25]);
		p[5].add(tf[4]);
		p[5].add(l[26]);

		p[5].add(l[27]);
		p[5].add(l[28]);
		p[5].add(l[29]);
		p[5].add(l[30]);

		p[5].add(l[31]);
		p[5].add(b[7]);
		p[5].add(b[8]);
		p[5].add(l[32]);

		l[33] = new Label("");
		l[34] = new Label("");
		l[35] = new Label("");

		fr.add(p[5], "Center");
		fr.add(l[33], "East");
		fr.add(l[34], "West");
		fr.add(l[35], "South");

		fr.setSize(300, 300);
		fr.setVisible(true);
	}
	
	//<저축>
	public void Saving() {
		Frame fr5 = new Frame();
		p[10] = new Panel();
		p[10].setLayout(new GridLayout(3,3));
		
		l[99] = new Label("");
		l[100] = new Label("저축하기");
		l[101] = new Label("");
		
		l[102] = new Label("금액 입력");
		tf[10] = new TextField();
		b[20] = new JButton("저축");
		
		l[103] = new Label("");
		l[104] = new Label("");
		l[105] = new Label("");
		
		p[10].add(l[99]);
		p[10].add(l[100]);
		p[10].add(l[101]);
		
		p[10].add(l[102]);
		p[10].add(tf[10]);
		p[10].add(b[20]);
		
		p[10].add(l[103]);
		p[10].add(l[104]);
		p[10].add(l[105]);
		
		fr5.add(p[10]);
		fr5.setSize(300,300);
		fr5.setVisible(true);
		
	}
	//<개인 정보 조회>
	public void UserInfo() {
		Frame fr6 = new Frame();
		p[11] = new Panel();
		p[11].setLayout(new GridLayout(1,5));
		
		l[106] = new Label("내 정보");
		l[106].setFont(new Font("Serif", Font.BOLD, 25));
		l[107] = new Label(" ");
		l[108] = new Label(" ");
		l[109] = new Label(" ");
		l[110] = new Label(" ");
		
		p[11].add(l[107]);
		p[11].add(l[108]);
		p[11].add(l[106]);
		p[11].add(l[109]);
		p[11].add(l[110]);
		
		
		
		p[12] = new Panel();
		p[12].setLayout(new GridLayout(8,5));
		
		l[111] = new Label(" ");
		l[112] = new Label(" ");
		l[113] = new Label(" ");
		l[114] = new Label(" ");
		l[115] = new Label(" ");
		
		p[12].add(l[111]);
		p[12].add(l[112]);
		p[12].add(l[113]);
		p[12].add(l[114]);
		p[12].add(l[115]);
		
		l[116] = new Label(" ");
		l[117] = new Label("NAME : ");
		l[148] = new Label(" ");
		//tf[11] = new TextField();
		l[118] = new Label(" ");
		l[119] = new Label(" ");
		
		p[12].add(l[116]);
		p[12].add(l[117]);
		p[12].add(l[148]);
		//p[12].add(tf[11]);
		p[12].add(l[118]);
		p[12].add(l[119]);
		
		l[120] = new Label(" ");
		l[121] = new Label("ID : ");
		//tf[12] = new TextField();
		l[149] = new Label("");
		l[122] = new Label(" ");
		l[123] = new Label(" ");
		
		p[12].add(l[120]);
		p[12].add(l[121]);
		//p[12].add(tf[12]);
		p[12].add(l[149]);
		p[12].add(l[122]);
		p[12].add(l[123]);
		
		l[124] = new Label(" ");
		l[125] = new Label("PW : ");
		//tf[13] = new TextField();
		l[150] = new Label("");
		l[126] = new Label(" ");
		l[127] = new Label(" ");
		
		p[12].add(l[124]);
		p[12].add(l[125]);
		//p[12].add(tf[13]);
		p[12].add(l[150]);
		p[12].add(l[126]);
		p[12].add(l[127]);
		
		l[128] = new Label(" ");
		l[129] = new Label("EMAIL : ");
		//tf[14] = new TextField();
		l[151] = new Label("");
		l[130] = new Label(" ");
		l[131] = new Label(" ");
		
		p[12].add(l[128]);
		p[12].add(l[129]);
		//p[12].add(tf[14]);
		p[12].add(l[151]);
		p[12].add(l[130]);
		p[12].add(l[131]);
		
		l[132] = new Label(" ");
		l[133] = new Label("PHONE : ");
		//tf[15] = new TextField();
		l[152] = new Label("");
		l[134] = new Label(" ");
		l[135] = new Label(" ");
		
		p[12].add(l[132]);
		p[12].add(l[133]);
		//p[12].add(tf[15]);
		p[12].add(l[152]);
		p[12].add(l[134]);
		p[12].add(l[135]);
		
		l[136] = new Label(" ");
		l[137] = new Label("BALANCE : ");
		//tf[16] = new TextField();
		l[153] = new Label("");
		l[138] = new Label(" ");
		l[139] = new Label(" ");
		
		p[12].add(l[136]);
		p[12].add(l[137]);
		//p[12].add(tf[16]);
		p[12].add(l[153]);
		p[12].add(l[138]);
		p[12].add(l[139]);
		
		l[140] = new Label(" ");
		l[141] = new Label("ACCOUNT : ");
		//tf[17] = new TextField();
		l[154] = new Label("");
		l[142] = new Label(" ");
		l[143] = new Label(" ");
		
		p[12].add(l[140]);
		p[12].add(l[141]);
		//p[12].add(tf[17]);
		p[12].add(l[154]);
		p[12].add(l[142]);
		p[12].add(l[143]);
		
		l[144] = new Label(" ");
		l[145] = new Label(" ");
		l[146] = new Label(" ");
		l[147] = new Label(" ");

		fr6.add(p[12], "Center");
		fr6.add(l[144], "East");
		fr6.add(l[145], "West");
		fr6.add(l[146], "South");
		fr6.add(p[11], "North");
		
		//fr6.add(p[12]);
		fr6.setSize(400,400);
		fr6.setVisible(true);
		
	}

	class ImagePanel extends Panel {
		@Override
		public void paint(Graphics g) {
			// g.fillRect(x,100,200,200);
			g.drawImage(img, 0, 0, this);

		}
	}

	public void actionPerformed(ActionEvent e) {
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	}
}