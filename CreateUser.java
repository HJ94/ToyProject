package Bank;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.*;

public class CreateUser extends JFrame implements ActionListener{
	
	JPanel []jp = new JPanel[10];
	JLabel []jl = new JLabel[100];
	JButton []jb = new JButton[10];
	JTextField []jf = new JTextField[5];
	JTextArea []ja = new JTextArea[5];
	
	
	public CreateUser() {
	//ȸ������ �� 	
	jp[0] = new JPanel();
	jp[0].setLayout(new GridLayout(1,5));
	
	jl[0] = new JLabel("ȸ������");
	jl[1] = new JLabel(" ");
	jl[2] = new JLabel(" ");
	jl[3] = new JLabel(" ");
	jl[4] = new JLabel(" ");
			
	
	jp[0].add(jl[1]);
	jp[0].add(jl[2]);
	jp[0].add(jl[0]);
	jp[0].add(jl[3]);
	jp[0].add(jl[4]);
	add(jp[0],"North");
	
	//ID,PW �ʵ�]
	jp[1] = new JPanel();
	jp[1].setLayout(new GridLayout(7,5));
	
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
	jl[6] = new JLabel("ID : " );
	jf[0] = new JTextField("���̵� �Է� ", 30);
	jl[7] = new JLabel(" ");
	jl[8] = new JLabel(" ");
	
	jp[1].add(jl[5]);
	jp[1].add(jl[6]);
	jp[1].add(jf[0]);
	jp[1].add(jl[7]);
	jp[1].add(jl[8]);
	
	
	jl[9] = new JLabel(" ");
	jl[10] = new JLabel("PW :  ");
	jf[1] = new JTextField("��й�ȣ �Է� ", 30);
	jl[11] = new JLabel(" ");
	jl[12] = new JLabel(" ");
	
	jp[1].add(jl[9]);
	jp[1].add(jl[10]);
	jp[1].add(jf[1]);
	jp[1].add(jl[11]);
	jp[1].add(jl[12]);
	
	jl[18] = new JLabel(" ");
	jl[19] = new JLabel("�̸� : ");
	jf[2] = new JTextField("�̸� �Է� ", 30);
	jl[21] = new JLabel(" ");
	jl[22] = new JLabel(" ");
	
	jp[1].add(jl[18]);
	jp[1].add(jl[19]);
	jp[1].add(jf[2]);
	jp[1].add(jl[21]);
	jp[1].add(jl[22]);
	
	jl[23] = new JLabel(" ");
	jl[24] = new JLabel("��ȭ��ȣ : " );
	jf[3] = new JTextField("��ȭ��ȣ �Է� ", 30);
	jl[25] = new JLabel(" ");
	jl[26] = new JLabel(" ");
	
	jp[1].add(jl[23]);
	jp[1].add(jl[24]);
	jp[1].add(jf[3]);
	jp[1].add(jl[25]);
	jp[1].add(jl[26]);
	
	
	jl[27] = new JLabel(" ");
	jl[28] = new JLabel("�̸��� : " );
	jf[4] = new JTextField("�̸��� �Է�  ", 30);
	jl[29] = new JLabel(" ");
	jl[30] = new JLabel(" ");
	
	jp[1].add(jl[27]);
	jp[1].add(jl[28]);
	jp[1].add(jf[4]);
	jp[1].add(jl[29]);
	jp[1].add(jl[30]);
	
	jl[31] = new JLabel(" ");
	jb[0] = new JButton("Ȯ��");
	jb[1] = new JButton("���");
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
	
	
	
	//��� ��ư
	jb[1].addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
		System.exit(0);
		}
		});

	
	
	
	
	
	
	setSize(500, 300);
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new CreateUser();

	
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
