package java_project_2048;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main extends JFrame implements ActionListener{
	
	private JPanel panel;
	private JLabel label;
	private JButton EasyBtn;
	private JButton NormalBtn;
	private JButton HardBtn;
	private Thread snow;
	
	public Main() {
		setTitle("2048 Game");
	    setSize(600, 600);
	    setLocation(700, 200);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setResizable(false);	// â ũ�� ���� �Ұ���
	    
	    panel = new Snow();		// Snow�� ������ panel
	    
	    label = new JLabel("2048  Game");
	    label.setFont(new Font("font", Font.BOLD, 80));
	    label.setForeground(new Color(255,0,0));
	    EasyBtn = new JButton("Easy");
	    NormalBtn = new JButton("Normal");
	    HardBtn = new JButton("Hard");
	    panel.add(label);
	    label.setBounds(95, -150, 500, 500);
	    panel.add(EasyBtn);
	    panel.add(NormalBtn);
	    panel.add(HardBtn);
	    EasyBtn.setBounds(225, 200, 150, 50); 
	    NormalBtn.setBounds(225, 300, 150, 50); 
	    HardBtn.setBounds(225, 400, 150, 50); 
	    EasyBtn.setFont(new Font("font", Font.BOLD, 30));
	    NormalBtn.setFont(new Font("font", Font.BOLD, 30));
	    HardBtn.setFont(new Font("font", Font.BOLD, 30));
	    EasyBtn.setForeground(new Color(255,0,0));
	    NormalBtn.setForeground(new Color(255,0,0));
	    HardBtn.setForeground(new Color(255,0,0));
	    panel.setLayout(null);
	    EasyBtn.addActionListener(this);
	    NormalBtn.addActionListener(this);
	    HardBtn.addActionListener(this);	    
	    this.add(panel);
	    this.setVisible(true); 
	    
	    snow = new Thread((Runnable)panel);		// Panel�� Runnable ����ȯ ���ְ� Thread �߰�
	    snow.start();		// Thread ����
	}
	
	public static void main(String[] args) {
		 new Main();		// main ����
		 Music.BackGroundMusic(true);	// BGM ���� �Լ� ȣ��
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == EasyBtn) {		// EasyBtn ���� ��
			// showMessageDialog�� �̿��� Easy ��ǥ ����
			JOptionPane.showMessageDialog(this, "Easy ���̵��� �����Ͽ����ϴ�!\n1024 Block�� ����� �¸��մϴ�!");
			new EasyMain();
		}
		else if(e.getSource() == NormalBtn){	// NormalBtn ���� ��
			// showMessageDialog�� �̿��� Normal ��ǥ ����
			JOptionPane.showMessageDialog(this, "Normal ���̵��� �����Ͽ����ϴ�!\n2048 Block�� ����� �¸��մϴ�!");
			new NormalMain();
		}
		else {		// HardBtn ���� ��
			// showMessageDialog�� �̿��� Hard ��ǥ ����
			JOptionPane.showMessageDialog(this, "Hard ���̵��� �����Ͽ����ϴ�!\n4096 Block�� ����� �¸��մϴ�!");
			new HardMain();
		}
	}
}
