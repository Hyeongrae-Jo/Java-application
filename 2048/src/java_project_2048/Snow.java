package java_project_2048;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class Snow extends JPanel implements Runnable{
	
	// 여러개의 Thread를 동시 실행하는 Vector를 선언
	Vector<Point> v = new Vector<Point>();
	
	// Snow 생성자
    Snow() {
        this.setLayout(null);
        for(int i = 0; i < 70; i++){			// 70개의 눈덩이 생성
            int x = (int)(Math.random()*600);	// 600x600의 창의 x좌표 중 랜덤 위치
            int y = (int)(Math.random()*600);	// 600x600의 창의 y좌표 중 랜덤 위치
            v.add(new Point(x,y));				// 위치를 vector에 추가
        }
    }
    
    // 배경과 눈덩이 그리는 paint 함수
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        ImageIcon icon = new ImageIcon("BGImage.jpg");		// 배경 이미지 갖고오기
        Image img = icon.getImage();
        g.drawImage(img, 0, 0, 600, 600, this);				// 배경 이미지 설정
        g.setColor(Color.WHITE);
        for(int i = 0; i < v.size(); i++){
            Point p = v.get(i);				
            g.fillOval((int)p.getX(), (int)p.getY(), 7, 7);	// 반지름이 7인 눈덩이 그리기
        }
    }
    
    // 눈의 위치 설정 함수
    public void changeSnowPosition(){
        for(int i = 0; i < v.size(); i++){
            Point p = v.get(i);
            p.y += (int)(Math.random()*10);		// 눈이 아래로 0~10 랜덤 속도로 내리게 설정
            if(p.y > 600)	// 눈의 위치가 600을 넘으면
                p.y = 0;	// 0으로 초기화
            v.set(i, p);
        }
    }
    
    // Thread의 run 함수
    public void run(){
        while(true){
            try{
                Thread.sleep(60);		// 시간지연을 60ms로 설정
            }
            catch(Exception e){
            	System.out.println(e.getMessage());
            }
            changeSnowPosition();
            repaint();
        }
    }
}
