package Bank;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Bank.CreateUser;

public class Bank_Layout extends Frame implements ActionListener {

	Panel p[] = new Panel[10];
	JLabel[] la = new JLabel[50];
	JTextField[] tf = new JTextField[5];
	
	
	Button[] b = new Button[10];
	public Dialog dialog;
	public Image img;

	public Bank_Layout() {

		img = Toolkit.getDefaultToolkit().getImage("C:/data/pigBank.jpg");
		// ������Ʈ �ʱ�ȭ
		la[0] = new JLabel("���̵� : ");
		la[1] = new JLabel("��й�ȣ : ");
		la[2] = new JLabel(" ");
		la[3] = new JLabel(" ");
		la[4] = new JLabel(" ");
		la[5] = new JLabel(" ");
		la[6] = new JLabel("Bank Menu");
		la[6].setFont(new Font("Serif", Font.BOLD, 50));
		la[7] = new JLabel(" ");
		la[8] = new JLabel(" ");
		la[9] = new JLabel(" ");
		la[10] = new JLabel(" ");
		la[11] = new JLabel(" ");
		la[12] = new JLabel(" ");
		la[13] = new JLabel(" ");
		la[14] = new JLabel(" ");
		la[15] = new JLabel(" ");
		la[16] = new JLabel(" ");
		la[17] = new JLabel(" ");
		la[18] = new JLabel(" ");
		la[19] = new JLabel(" ");

		tf[0] = new JTextField("", 30);
		tf[1] = new JTextField("", 30);

		b[0] = new Button("�α���");
		b[1] = new Button("���");
		b[2] = new Button("Ȯ��");
		b[3] = new Button("ȸ������");
		b[4] = new Button("IDã��");

		// �гε� ���δ� �г�
		p[6] = new Panel();
		p[6].setLayout(new BorderLayout());

		// �г� 1 - BankMenu�ΰ�
		p[0] = new Panel();
		p[0].setLayout(new BorderLayout());
		p[0].add(la[2], "North");
		p[0].add(la[3], "East");
		p[0].add(la[6], "Center");
		p[0].add(la[4], "West");
		p[0].add(la[5], "South");

		p[6].add(p[0], "North");

		// �г�2 - �̹���
		p[1] = new Panel();
		p[1].setLayout(new BorderLayout());
		p[1].add(la[7], "North");
		p[1].add(la[8], "East");
		p[1].add(new ImagePanel(), "Center");
		p[1].add(la[9], "West");
		p[1].add(la[10], "South");

		p[6].add(p[1], "Center");

		// �г�3 - ID,PW �Է¶�
		p[3] = new Panel();
		p[3].setLayout(new BorderLayout());
		p[2] = new Panel();
		p[2].setLayout(new GridLayout(2, 5));

		p[4] = new Panel();
		p[4].setLayout(new FlowLayout());
		p[4].add(b[3]);
		p[4].add(b[4]);

		p[2].add(la[11]);
		p[2].add(la[0]);
		p[2].add(tf[0]);
		p[2].add(b[0]);
		p[2].add(la[12]);

		p[2].add(la[13]);
		p[2].add(la[1]);
		p[2].add(tf[1]);
		p[2].add(b[1]);
		p[2].add(la[14]);

		p[3].add(la[15], "North");
		p[3].add(la[16], "East");
		p[3].add(p[2], "Center");
		p[3].add(la[17], "West");
		p[3].add(p[4], "South");

		p[6].add(p[3], "South");

		add(p[6]);
		setSize(470, 550);
		setVisible(true);
		setTitle("Bank");
		b[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new CreateUser();
			}

		});

		// �ݱ�
		addWindowListener(new WindowAdapter() { // ����Ͽ��� ���� ���(���� �͸�)
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		b[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				login();
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
		Object obj = e.getSource();
		Button b = (Button) obj;
		System.out.println("ȸ������ : " + b.getLabel());

	}

	public boolean login() {
		String id = tf[0].getText();
		String pw = tf[1].getText();

		boolean result = false;
		for (int i = 0; i < CreateUser.list.size(); i++) {

			if (CreateUser.list.get(i) == null)
				break;

			if (id.equals(CreateUser.list.get(i).getId()) && pw.equals(CreateUser.list.get(i).getPw())) {
				System.out.println(CreateUser.list.get(i).getName() + "�� �ݰ����ϴ�.");
				new MainLayout();

				//CreateUser.list.get(i);
				// member = members[i];
				return true;
			} else {
				System.out.println("ID�� PW�� ��ġ���� �ʽ��ϴ�.");
				return false;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Bank_Layout();
	}

}
