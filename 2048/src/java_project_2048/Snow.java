package java_project_2048;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Snow extends JPanel implements Runnable{
	
	// �������� Thread�� ���� �����ϴ� Vector�� ����
	Vector<Point> v = new Vector<Point>();
	
	// Snow ������
    Snow() {
        this.setLayout(null);
        for(int i = 0; i < 70; i++){			// 70���� ������ ����
            int x = (int)(Math.random()*600);	// 600x600�� â�� x��ǥ �� ���� ��ġ
            int y = (int)(Math.random()*600);	// 600x600�� â�� y��ǥ �� ���� ��ġ
            v.add(new Point(x,y));				// ��ġ�� vector�� �߰�
        }
    }
    
    // ���� ������ �׸��� paint �Լ�
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ImageIcon icon = new ImageIcon("BGImage.jpg");		// ��� �̹��� �������
        Image img = icon.getImage();
        g.drawImage(img, 0, 0, 600, 600, this);				// ��� �̹��� ����
        g.setColor(Color.WHITE);
        for(int i = 0; i < v.size(); i++){
            Point p = v.get(i);				
            g.fillOval((int)p.getX(), (int)p.getY(), 7, 7);	// �������� 7�� ������ �׸���
        }
    }
    
    // ���� ��ġ ���� �Լ�
    public void changeSnowPosition(){
        for(int i = 0; i < v.size(); i++){
            Point p = v.get(i);
            p.y += (int)(Math.random()*10);		// ���� �Ʒ��� 0~10 ���� �ӵ��� ������ ����
            if(p.y > 600)	// ���� ��ġ�� 600�� ������
                p.y = 0;	// 0���� �ʱ�ȭ
            v.set(i, p);
        }
    }
    
    // Thread�� run �Լ�
    public void run(){
        while(true){
            try{
                Thread.sleep(60);		// �ð������� 60ms�� ����
            }
            catch(Exception e){
            	System.out.println(e.getMessage());
            }
            changeSnowPosition();
            repaint();
        }
    }
}
