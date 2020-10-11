package Bank;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
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
import java.sql.Statement;

import javax.swing.JButton;

public class MainLayout extends Frame implements ActionListener {
	// List<Member> list = new Vector<>();
	Panel[] p = new Panel[10];
	Label[] l = new Label[100];
	JButton[] b = new JButton[20];
	TextField[] tf = new TextField[10];
	Dialog dialog1, dialog2;
	Image img;
	String UserName;
	int UserBalance, deposit, withdraw;
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/app?characterEnconding=UTF-8&serverTimezone=UTC"; // url ����
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;

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
					//UserBalance = rs.getInt("BALANCE");
				}
			}
		}catch(Exception e) {
			System.out.println("������ ã�� ����");
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
		l[4] = new Label(UserName + "�� �ݰ����ϴ�.");
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
//		b[0] = new Button("����");
//		b[1] = new Button("���");
//		b[2] = new Button("�α׾ƿ�");
//		b[6] = new Button("ȸ�� Ż��");
		l[50] = new Label("");
		l[51] = new Label(UserName + "���� �ܾ�");
		l[51].setFont(new Font("ȫ���ΰ�", Font.BOLD, 20));
		l[52] = new Label("");
		l[53] = new Label("");
		l[54] = new Label(Integer.toString(UserBalance) + "��");
		l[54].setFont(new Font("ȫ���ΰ�", Font.BOLD, 25));
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
		p[3].setLayout(new GridLayout(3,2));
		
		b[10]= new JButton("�Ա�");
		b[11]= new JButton("���");
		b[12]= new JButton("���� ���� ����");
		b[13]= new JButton("�ܾ� ��ȸ");
		b[14]= new JButton("�α׾ƿ�");
		b[15]= new JButton("��������");
		
		p[3].add(b[10]);
		p[3].add(b[11]);
		p[3].add(b[12]);
		p[3].add(b[13]);
		p[3].add(b[14]);
		p[3].add(b[15]);
		
//		l[6] = new Label("����");
//		l[7] = new Label(" ");
//		// �Ա�
//		tf[0] = new TextField();
//		b[3] = new Button("�Ա�");
//		l[8] = new Label("���");
//		l[9] = new Label(" ");
//		// ���
//		tf[1] = new TextField();
//		b[4] = new Button("���");
//		l[10] = new Label("�ܾ� ��ȸ");
//		l[11] = new Label(" ");
//		// �ܰ�
//		String Bal = Integer.toString(UserBalance);
//		l[13] = new Label(UserBalance + "��"); // tf[2] = new TextField(UserBalance);
//		b[5] = new Button("��ȸ");
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

		// <�Ա�>
		b[10].addActionListener(this);
		b[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deposit();	
				b[16].addActionListener(new ActionListener() {
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
							UserBalance += Integer.parseInt(tf[5].getText());
							String sql2 = "update member set BALANCE = '" + UserBalance + "'WHERE ID = '" + UserName + "'" ;
							int result = stmt.executeUpdate(sql2);
							String msg = result > -1 ? "successful" : "fail";
							System.out.println(msg);
							}catch(Exception ex) {
							System.out.println("������ ã�� ����");
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
//		// <���>
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
							System.out.println("������ ã�� ����");
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
//
//		// <�ܾ� ��ȸ>
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
					l[54].setText(Integer.toString(UserBalance) + "��");
					}catch(Exception ex) {
					System.out.println("������ ã�� ����");
				}finally {
					try {
						if(rs != null)rs.close();
						if(stmt != null)stmt.close();
						if(conn != null)conn.close();
					}catch(Exception ex) {}
				}
				l[54].setText(Integer.toString(UserBalance) + "��");
			}
		});
//		// <�α׾ƿ�>
		b[14].addActionListener(this);
		b[14].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Bank_Layout();
				setVisible(false);
			}
		});
		//<���� ���� ����> - Update
		b[12].addActionListener(this);
		b[12].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChangeInfo();
			}	
		});	
		
		
//		
//		//<ȸ�� Ż��>
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

		// �ݱ�
		addWindowListener(new WindowAdapter() { // ����Ͽ��� ���� ���(���� �͸�)
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		//<ȸ�� ���� ����>
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
					
					}
				});			
			}
		});	
	}// MainLayout () end

	

	public void Deposit() {
		Frame fr2 = new Frame();
		p[6] = new Panel();
		p[6].setLayout(new GridLayout(3, 3));

		l[59] = new Label("");
		l[60] = new Label("�Ա��ϱ�");
		l[61] = new Label("");

		l[62] = new Label("�ݾ� �Է�");
		tf[5] = new TextField();
		b[16] = new JButton("�Ա�");

		l[65] = new Label("");
		l[66] = new Label("");
		l[67] = new Label("");

		p[6].add(l[59]);
		p[6].add(l[60]);
		p[6].add(l[61]);

		p[6].add(l[62]);
		p[6].add(tf[5]);
		p[6].add(b[16]);

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
		l[69] = new Label("����ϱ�");
		l[70] = new Label("");

		l[71] = new Label("�ݾ� �Է�");
		tf[6] = new TextField();
		b[17] = new JButton("���");

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
	//ȸ�� ���� ����
	public void ChangeInfo() {
		Frame fr4 = new Frame();
		p[8] = new Panel();
		fr4.setLayout(new BorderLayout());
		p[8].setLayout(new GridLayout(1,3));
		
		l[75] = new Label("ȸ�� ���� ����");
		l[75].setFont(new Font("Bodeni MT Black", Font.BOLD, 20));
		l[76] = new Label("");
		l[77] = new Label("");
		
		p[8].add(l[75]);
		p[8].add(l[76]);
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
		l[86] = new Label("");
		tf[8] = new TextField();
		l[87] = new Label("");
		
		l[88] = new Label("");
		l[89] = new Label("");
		l[90] = new Label("");
		l[91] = new Label("");
		
		l[92] = new Label("");
		b[9] = new JButton("Ȯ��");
		b[10] = new JButton("Ȯ��");
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
		p[9].add(l[90]);
		p[9].add(l[91]);
		
		p[9].add(l[92]);
		p[9].add(b[9]);
		p[9].add(b[10]);
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

	// ȸ�� ���� ���� �޼���
	public void DeleteUser() {
		Frame fr = new Frame();
		p[4] = new Panel();
		fr.setLayout(new BorderLayout());
		p[4].setLayout(new GridLayout(1, 3));

		l[14] = new Label("ȸ�� Ż��");
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
		b[7] = new JButton("Ȯ��");
		b[8] = new JButton("���");
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