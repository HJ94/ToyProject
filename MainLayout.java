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
	public JButton[] b = new JButton[20];
	public TextField[] tf = new TextField[10];
	public Dialog dialog1, dialog2;
	public Image img;
	String UserName;
	int UserBalance, deposit, withdraw;
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/app?characterEnconding=UTF-8&serverTimezone=UTC"; //url 정보
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
				if(id.equals(rs.getString("ID"))) {
					UserName = rs.getString("NAME");
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
		l[4] = new Label(UserName + "님 반갑습니다.");
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
		l[51] = new Label(UserName + "님의 잔액");
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
		p[3].setLayout(new GridLayout(3,2));
		
		b[10]= new JButton("입금");
		b[11]= new JButton("출금");
		b[12]= new JButton("개인 정보 변경");
		b[13]= new JButton("잔액 조회");
		b[14]= new JButton("로그아웃");
		b[15]= new JButton("계정삭제");
		
		p[3].add(b[10]);
		p[3].add(b[11]);
		p[3].add(b[12]);
		p[3].add(b[13]);
		p[3].add(b[14]);
		p[3].add(b[15]);
		
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

		// <입금>
		b[10].addActionListener(this);
		b[10].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Deposit();
				
			}
			
		});
		// <출금>
		b[16].addActionListener(this);
		b[16].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
						
					}
				});
		
		
		
		
		
//
//		// <출금>
		b[11].addActionListener(this);
		b[11].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
//
//		// <잔액 조회>
		b[13].addActionListener(this);
		b[13].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				l[54].setText(Integer.toString(UserBalance) + "원");
			}
		});
//		// <로그아웃>
		b[14].addActionListener(this);
		b[14].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Bank_Layout();
				setVisible(false);
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
		//<회원 정보 삭제>
//		b[7].addActionListener(this);
//		b[7].addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					Class.forName(driver);
//					conn = DriverManager.getConnection(url, "root", "java");
//					stmt = conn.createStatement();
//					String sql = "DELETE FROM member WHERE ID = '" + tf[3] +"' AND PW = '" + tf[4] + "'";
//					int result = stmt.executeUpdate(sql);
//					String msg = result >  -1 ? "successful" : "fail";
//					System.out.println(msg);
//				}catch(Exception ex) {
//					ex.printStackTrace();
//				}finally {
//					try {
//						if (stmt != null)stmt.close();
//						if (conn != null)conn.close();
//					}catch(Exception ex) {	
//					}
//				}	
//			}
//		});
		
		
		
	}
	public void Deposit() {
		Frame fr2 = new Frame();
		p[6] = new Panel();
		p[6].setLayout(new GridLayout(3,3));
		
		l[59] = new Label("");
		l[60] = new Label("입금하기");
		l[61] = new Label("");
		
		l[62] = new Label("금액 입력");
		tf[5] = new TextField();
		b[16] = new JButton("입금");
				
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
		
		fr2.setSize(350,200);
		fr2.setVisible(true);
		
		
	}
	//회원 정보 삭제 메서드
	public void DeleteUser() {
		Frame fr = new Frame();
		p[4] = new Panel(); 
		fr.setLayout(new BorderLayout());
		p[4].setLayout(new GridLayout(1,3));

		l[14] = new Label("회원 탈퇴");
		l[14].setFont(new Font("Bodeni MT Black", Font.BOLD, 20));
		l[15] = new Label("");
		l[16] = new Label("");
		
		p[4].add(l[15]);
		p[4].add(l[14]);
		p[4].add(l[16]);
		fr.add(p[4],"North");
		
		p[5] = new Panel();
		p[5].setLayout(new GridLayout(5,4));
		
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

	
		fr.setSize(300,300);
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