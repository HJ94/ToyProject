package Bank;

import java.util.List;
import java.util.Vector;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import Bank.CreateUser;
import Bank.Bank_Layout.ImagePanel;
import Bank.Bank_Layout;
import Bank.Member;

public class MainLayout extends Frame implements ActionListener {

	// List<Member> list = new Vector<>();

	Panel[] p = new Panel[10];
	Label[] l = new Label[50];
	Button[] b = new Button[10];
	TextField[] tf = new TextField[10];
	public Dialog dialog1, dialog2;
	public Image img;
	String UserName;
	int UserBalance, deposit, withdraw;

	public MainLayout() {
		// �α����� ȸ�� �̸� ���
		for (int i = 0; i < CreateUser.list.size(); i++) {
			Object obj = CreateUser.list.get(i);
			Member member = (Member) obj;

			String id = Bank_Layout.tf[0].getText();
			String pw = Bank_Layout.tf[1].getText();

			if (id.equals(member.id) && pw.equals(member.pw)) {

				UserName = member.getName();
				UserBalance = member.balance;
			}
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

		p[2] = new Panel();
		p[2].setLayout(new FlowLayout());
		b[0] = new Button("����");
		b[1] = new Button("���");
		b[2] = new Button("�α׾ƿ�");

		p[2].add(b[0]);
		p[2].add(b[1]);
		p[2].add(b[2]);
		p[0].add(p[2], "Center");

		p[3] = new Panel();
		p[3].setLayout(new GridLayout(6, 2));
		l[6] = new Label("����");
		l[7] = new Label(" ");
		// �Ա�
		tf[0] = new TextField();
		b[3] = new Button("�Ա�");
		l[8] = new Label("���");
		l[9] = new Label(" ");
		// ���
		tf[1] = new TextField();
		b[4] = new Button("���");
		l[10] = new Label("�ܾ� ��ȸ");
		l[11] = new Label(" ");
		// �ܰ�
		String Bal = Integer.toString(UserBalance);
		l[13] = new Label(UserBalance + "��"); // tf[2] = new TextField(UserBalance);
		b[5] = new Button("��ȸ");

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
		// p[3].add(tf[2]);
		p[3].add(b[5]);
		p[0].add(p[3], "South");

		// <�Ա�>
		b[3].addActionListener(this);
		b[3].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserBalance += Integer.parseInt(tf[0].getText());
				System.out.println(UserBalance);
			}
		});

		// <���>
		b[4].addActionListener(this);
		b[4].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UserBalance -= Integer.parseInt(tf[1].getText());
				System.out.println(UserBalance);
			}
		});

		// <�ܾ� ��ȸ>
		b[5].addActionListener(this);
		b[5].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				l[13].setText(Integer.toString(UserBalance) + "��");
			}
		});
		// <�α׾ƿ�>
		b[2].addActionListener(this);
		b[2].addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (int i = 0; i < CreateUser.list.size(); i++) {
					Object obj = CreateUser.list.get(i);
					Member member = (Member) obj;

					String id = Bank_Layout.tf[0].getText();
					String pw = Bank_Layout.tf[1].getText();

					if (id.equals(member.id) && pw.equals(member.pw)) {
						new Bank_Layout();
						setVisible(false);
					
					}
				}
			}
		});

		add(p[0]);
		setSize(500, 500);
		setVisible(true);

		b[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// login();
				setVisible(true);
			}
		});

		// �ݱ�
		addWindowListener(new WindowAdapter() { // ����Ͽ��� ���� ���(���� �͸�)
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}

	class ImagePanel extends Panel {
		@Override
		public void paint(Graphics g) {
			// g.fillRect(x,100,200,200);
			g.drawImage(img, 0, 0, this);
		}
	}

	public void actionPerformed(ActionEvent e) {

		// Button b = (Button) obj;

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				// dialog�����

				// ��ü ����
			}
		});

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainLayout();

	}

}
