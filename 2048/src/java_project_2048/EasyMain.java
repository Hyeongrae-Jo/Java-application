package java_project_2048;

import java.awt.*;
import javax.swing.*;

public class EasyMain extends JFrame {
	
	EasyMain(){
		setTitle("Easy ( 5 x 5 : 1024) - �ٽ� �����Ϸ��� 'R'�� ��������");
	    setSize(600, 600);
	    setLocation(700, 200);
	    setResizable(false);
	    this.getContentPane().setLayout(new GridLayout(5, 5, 4, 4));
	    new EasyGame(this);
	    this.setVisible(true);
	}
}
