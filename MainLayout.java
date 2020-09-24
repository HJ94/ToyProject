package Bank;

import java.util.List;
import java.util.Vector;
import java.awt.*;
import Bank.CreateUser;
import Bank.Bank_Layout.ImagePanel;
import Bank.Bank_Layout;

public class MainLayout extends Frame {

	List<Member> list = new Vector<>();

	Panel[] p = new Panel[10];
	Label[] l = new Label[50];
	Button[] b = new Button[10];
	TextField[] tf = new TextField[10];
	public Image img;

	public MainLayout() {
		img = Toolkit.getDefaultToolkit().getImage("C:/data/piggy.jpg");

		p[0] = new Panel();
		p[0].setLayout(new BorderLayout());
		p[1] = new Panel();
		p[1].setLayout(new GridLayout(2, 3));
		l[0] = new Label("");
		l[1] = new Label("Bank");
		l[1].setFont(new Font("Serif", Font.BOLD, 50));
		l[2] = new Label();
		l[3] = new Label("");
		l[4] = new Label();
		l[5] = new Label("´Ô ¹Ý°©½À´Ï´Ù.");

//		Bank_Layout bankLayout = new Bank_Layout();
//		for (int i = 0; i < list.size(); i++) {
//			Object obj = list.get(i);
//			Member member = (Member) obj;
//			l[2] = new Label(CreateUser.list.get(i).getName());
//		}
		p[1].add(l[0]);
		p[1].add(l[1]);
		p[1].add(l[2]);
		p[1].add(l[3]);
		p[1].add(l[4]);
		p[1].add(l[5]);

		p[0].add(p[1], "North");
		
		p[2] = new Panel();
		p[2].setLayout(new FlowLayout());
		b[0] = new Button("¿¹±Ý");
		b[1] = new Button("Ãâ±Ý");
		b[2] = new Button("È¸¿ø Å»Åð");
		
		p[2].add(b[0]);
		p[2].add(b[1]);
		p[2].add(b[2]);
		
		p[0].add(p[2], "Center");
		
		p[3] = new Panel();
		p[3].setLayout(new GridLayout(1,3));
		l[6] = new Label(" ");
		p[3].add(new ImagePanel());
		l[7] = new Label(" ");
		p[0].add(p[3], "Center");

		
		
		add(p[0]);
		setSize(500, 500);
		setVisible(true);
	}
	class ImagePanel extends Panel {
		@Override
		public void paint(Graphics g) {
			// g.fillRect(x,100,200,200);
			g.drawImage(img, 0, 0, this);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MainLayout();

	}

}
