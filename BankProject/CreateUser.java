package Bank;

import java.awt.Dialog;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CreateUser extends JFrame implements ActionListener {

	JPanel[] jp = new JPanel[10];
	JLabel[] jl = new JLabel[100];
	JButton[] jb = new JButton[10];
	static JTextField[] jf = new JTextField[5];
	JTextArea[] ja = new JTextArea[5];
	public Dialog dialog;

	static List<Member> list = new Vector<>();

	public CreateUser() {

		// 회원가입 라벨
		jp[0] = new JPanel();
		jp[0].setLayout(new GridLayout(1, 5));

		jl[0] = new JLabel("회원가입");
		jl[1] = new JLabel(" ");
		jl[2] = new JLabel(" ");
		jl[3] = new JLabel(" ");
		jl[4] = new JLabel(" ");

		jp[0].add(jl[1]);
		jp[0].add(jl[2]);
		jp[0].add(jl[0]);
		jp[0].add(jl[3]);
		jp[0].add(jl[4]);
		add(jp[0], "North");

		// ID,PW 필드]
		jp[1] = new JPanel();
		jp[1].setLayout(new GridLayout(7, 5));

		jl[13] = new JLabel(" ");
		jl[14] = new JLabel(" ");
		jl[15] = new JLabel(" ");
		jl[16] = new JLabel(" ");
		jl[17] = new JLabel(" ");

		jp[1].add(jl[13]);
		jp[1].add(jl[14]);
		jp[1].add(jl[15]);
		jp[1].add(jl[16]);
		jp[1].add(jl[17]);

		jl[5] = new JLabel(" ");
		jl[6] = new JLabel("ID : ");
		jf[0] = new JTextField();
		jl[7] = new JLabel(" ");
		jl[8] = new JLabel(" ");

		jp[1].add(jl[5]);
		jp[1].add(jl[6]);
		jp[1].add(jf[0]);
		jp[1].add(jl[7]);
		jp[1].add(jl[8]);

		jl[9] = new JLabel(" ");
		jl[10] = new JLabel("PW :  ");
		jf[1] = new JTextField();
		jl[11] = new JLabel(" ");
		jl[12] = new JLabel(" ");

		jp[1].add(jl[9]);
		jp[1].add(jl[10]);
		jp[1].add(jf[1]);
		jp[1].add(jl[11]);
		jp[1].add(jl[12]);

		jl[18] = new JLabel(" ");
		jl[19] = new JLabel("이름 : ");
		jf[2] = new JTextField("", 30);
		jl[21] = new JLabel(" ");
		jl[22] = new JLabel(" ");

		jp[1].add(jl[18]);
		jp[1].add(jl[19]);
		jp[1].add(jf[2]);
		jp[1].add(jl[21]);
		jp[1].add(jl[22]);

		jl[23] = new JLabel(" ");
		jl[24] = new JLabel("전화번호 : ");
		jf[3] = new JTextField("", 30);
		jl[25] = new JLabel(" ");
		jl[26] = new JLabel(" ");

		jp[1].add(jl[23]);
		jp[1].add(jl[24]);
		jp[1].add(jf[3]);
		jp[1].add(jl[25]);
		jp[1].add(jl[26]);

		jl[27] = new JLabel(" ");
		jl[28] = new JLabel("이메일 : ");
		jf[4] = new JTextField("", 30);
		jl[29] = new JLabel(" ");
		jl[30] = new JLabel(" ");

		jp[1].add(jl[27]);
		jp[1].add(jl[28]);
		jp[1].add(jf[4]);
		jp[1].add(jl[29]);
		jp[1].add(jl[30]);

		jl[31] = new JLabel(" ");
		jb[0] = new JButton("확인");
		jb[1] = new JButton("취소");
		jl[32] = new JLabel(" ");
		jl[33] = new JLabel(" ");

		jp[1].add(jl[31]);
		jp[1].add(jb[0]);
		jp[1].add(jb[1]);
		jp[1].add(jl[32]);
		jp[1].add(jl[33]);

		jl[95] = new JLabel(" ");
		jl[96] = new JLabel(" ");
		jl[97] = new JLabel(" ");
		jl[98] = new JLabel(" ");

		add(jp[1], "Center");
		add(jl[95], "East");
		add(jl[96], "West");
		add(jl[97], "South");

		jf[0].addActionListener(this);
		jf[1].addActionListener(this);
		jb[0].addActionListener(this);

		// 회원가입 성공 다이얼로그
		dialog = new Dialog(this);
		dialog.setSize(200, 200);
		dialog.add(new Label("회원가입 되었습니다."));

		// 확인버튼 이벤트-회원 가입 성공 다이얼로그
		jb[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//dialog.setVisible(true);
				JOptionPane.showMessageDialog(null, "회원가입 되었습니다.");
				new Bank_Layout();
				setVisible(false);
			}
			
			
		});
		// 취소 버튼 - 창 닫기
		jb[1].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		setSize(500, 350);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String id = jf[0].getText();
		String pw = jf[1].getText();
		String name = jf[2].getText();
		String phone = jf[3].getText();
		String email = jf[4].getText();

		
		Object obj = e.getSource();
		if (obj.equals(jb[0])) {
			createUser();
		}
		dialog.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				dialog.setVisible(false); // dialog숨기기
				dialog.dispose(); // 객체 해지
			}
		});
	}

	
	// 회원가입
	public static void createUser() {
		String id = jf[0].getText();
		String pw = jf[1].getText();
		String name = jf[2].getText();
		String phone = jf[3].getText();
		String regExp = "^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$";
		boolean result = Pattern.matches(regExp, phone);
		
		while (result == false) {
			if (result == true) {
				result = true;
				break;
			} else {
				System.out.println("이메일 형식이 올바르지 않습니다. ex)abcde@naver.com");
				System.out.println();
				System.out.print("이메일을 다시 입력해주세요 : ");
				phone = jf[3].getText();
				System.out.println();
				break;
			}
		}
		String email = jf[4].getText();
		regExp = "(02|010)-\\d{3,4}-\\d{4}";
		result = Pattern.matches(regExp, email);
		while (result == false) {
			if (result == true) {
				result = true;
				break;
			} else {
				System.out.println("전화번호 형식이 올바르지 않습니다. \n ex)010-1111-1111 or 02-222-2222");
				System.out.println();
				System.out.print("전화번호를 다시 입력해주세요 : ");
				email = jf[4].getText();
				System.out.println();
				break;
			}
		}
		int balance = 0;
		System.out.println();
		System.out.println("회원가입 되었습니다!");
		System.out.println("------------------");

		
		list.add(new Member(name, id, pw, email, phone, balance));
		
		String driver ="com.mysql.cj.jdbc.Driver"; //드라이버
		String url = "jdbc:mysql://localhost:3306/app?characterEnconding=UTF-8&serverTimezone=UTC"; //url 정보
		Connection conn = null;
		Statement stmt = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "java");
			System.out.println("데이터베이스 연결 성공");
			stmt = conn.createStatement();
			String sql = insert();
			int result2 = stmt.executeUpdate(sql);
			String msg =result2 > -1 ? "데이터 저장 성공!" : "데이터 저장 실패!";
			System.out.println(msg);
		}catch(Exception e) {
			System.out.println("데이터베이스 연결 실패!");
		}finally {
			try {
				if(stmt != null)stmt.close();
				if(conn != null)stmt.close();
			}catch(Exception e) {}
		}
	}

	public static String insert() {
		String id = jf[0].getText();
		String pw = jf[1].getText();
		String name = jf[2].getText();
		String phone = jf[3].getText();
		String email = jf[4].getText();
		int balance = 0;
		String account =  "0000" + "-" + (int)((Math.random()*9999)+1);
		String sql = "insert into member values('" + name +"', '" + id + "','" + pw + "','" + email +"' , '" + phone +"','" + balance +"','" + account +"')";
		return sql;
	}
	
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub	
		new CreateUser();
	}


	

}
