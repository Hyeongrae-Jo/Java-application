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
	    setResizable(false);	// 창 크기 조정 불가능
	    
	    panel = new Snow();		// Snow를 적용한 panel
	    
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
	    
	    snow = new Thread((Runnable)panel);		// Panel을 Runnable 형변환 해주고 Thread 추가
	    snow.start();		// Thread 실행
	}
	
	public static void main(String[] args) {
		 new Main();		// main 실행
		 Music.BackGroundMusic(true);	// BGM 실행 함수 호출
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == EasyBtn) {		// EasyBtn 선택 시
			// showMessageDialog를 이용해 Easy 목표 설명
			JOptionPane.showMessageDialog(this, "Easy 난이도를 선택하였습니다!\n1024 Block을 만들면 승리합니다!");
			new EasyMain();
		}
		else if(e.getSource() == NormalBtn){	// NormalBtn 선택 시
			// showMessageDialog를 이용해 Normal 목표 설명
			JOptionPane.showMessageDialog(this, "Normal 난이도를 선택하였습니다!\n2048 Block을 만들면 승리합니다!");
			new NormalMain();
		}
		else {		// HardBtn 선택 시
			// showMessageDialog를 이용해 Hard 목표 설명
			JOptionPane.showMessageDialog(this, "Hard 난이도를 선택하였습니다!\n4096 Block을 만들면 승리합니다!");
			new HardMain();
		}
	}
}
