package app2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Bank_Layout extends Frame implements ActionListener{

	Panel p1 = new Panel();
	Panel p2 = new Panel();
	
	public Dialog dialog;
	public Label la1, la2, la3, la4, la5, la6, la7, la8;
	public TextField tf1, tf2;
	public Button b1, b2;

	public Bank_Layout() {

		dialog = new Dialog(this);
		dialog.setSize(200,200);
		dialog.add(new Button("Ȯ��"));
		
		la1 = new Label(" ");
		la2 = new Label("���̵� : ");
		la3 = new Label("��й�ȣ : ");
		la4 = new Label("ȸ�� ����");
		la5 = new Label(" ");
		la6 = new Label(" ");
		la7 = new Label(" ");
		la8 = new Label(" ");

		tf1 = new TextField("ID�Է�", 30);
		tf2 = new TextField("PW�Է�", 30);

		b1 = new Button("Ȯ��");
		b2 = new Button("���");

		p1.setLayout(new GridLayout(5,2));

		p1.add(la4);
		p1.add(la1);
		p1.add(la2);
		p1.add(tf1);
		p1.add(la3);
		p1.add(tf2);
		p1.add(b1);
		p1.add(b2);
		
		add(p1);
		
		p2.setLayout(new BorderLayout());
		
		p2.add(la5, "North");
		p2.add(la6, "West");
		p2.add(add(p1) , "Center");
		p2.add(la7, "East");
		p2.add(la8, "South");
		
		add(p2);
		
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		

		
		setSize(300, 250);
		setVisible(true);
		
		//�ݱ�
		addWindowListener(new WindowAdapter() { //����Ͽ��� ���� ���(���� �͸�)
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

	}
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		Button b = (Button)obj;
		System.out.println("ȸ������ : " + b.getLabel());
		
	}
	
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Bank_Layout();
	}

}
