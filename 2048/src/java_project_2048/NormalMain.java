package java_project_2048;

import java.awt.*;
import javax.swing.*;

public class NormalMain extends JFrame {

	NormalMain(){
		setTitle("Normal ( 4 x 4 : 2048) - �ٽ� �����Ϸ��� 'R'�� ��������");
	    setSize(600, 600);
	    setLocation(700, 200);
	    setResizable(false);
	    this.getContentPane().setLayout(new GridLayout(4, 4, 5, 5));
	    new NormalGame(this);
	    this.setVisible(true);
	}
}
