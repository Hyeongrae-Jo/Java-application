package java_project_2048;

import java.awt.*;
import javax.swing.*;

public class HardMain extends JFrame {
	
	HardMain(){
		setTitle("Hard ( 4 x 4 : 4096) - 다시 시작하려면 'R'을 누르세요");
	    setSize(600, 600);
	    setLocation(700, 200);
	    setResizable(false);
	    this.getContentPane().setLayout(new GridLayout(4, 4, 5, 5));
	    new HardGame(this);
	    this.setVisible(true);
	}
}
