package java_project_2048;

import javax.swing.*;
import java.awt.event.*;

public class EasyGame implements KeyListener{
	
	private static int EasyCnt = 0;
	private static int EasyScore = 0;
	Block[] block;
	JPanel panel;
	public boolean up, down, right, left;
	boolean running;
	
	// EasyGame ������
	public EasyGame(JFrame frame) {
		this.panel = (JPanel)frame.getContentPane();
	    block = new Block[25];		// 25���� block ����
	    running = true;			
	    up = true;
	    down = true;
	    left = true;
	    right = true;
	    addBlock();
	    for (int i = 0; i < 2; i++)
	      createBlock();
	    frame.addKeyListener(this);
	}
	
	// block 25���� frame�� �߰��ϴ� �Լ�
	private void addBlock() {
		for (int i = 0; i < 25; i++) 
	    {
	      block[i] = new Block();
	      block[i].setHorizontalAlignment(JLabel.CENTER);
	      block[i].setOpaque(true);
	      panel.add(block[i]);
	    }
	}
	
	// block�� �ΰ��� ���� �����ϴ� �Լ�
	public void createBlock(){
		while(running) {
			int index = (int)(Math.random() * 25);
			if(block[index].getValue() == 0) {
				if(Math.random() < 0.8) {
					block[index].setValue(2);		// 80�� Ȯ���� 2 ����
				}else {
					block[index].setValue(4);		// 20�� Ȯ���� 4 ����
				}break;
			}
		}
	}
	
	// block�� ���� ���θ� �Ǵ��ϴ� �Լ�
	public void judgeCreate() {
		int sum = 0;
		for (int i = 0; i < 25; i++) {
			if(block[i].getValue() != 0) {
				sum++;
			}
		}
		if(sum == 25) {
			running = false;
		}
	}
	
	// 0�� �ƴ� block ���� ã�� �Լ�
	public int Find(int i, int j, int a, int b) {
		while(i < b && i >= a) {
			if(block[i].getValue() != 0) {
				return i;
			}
			i = i + j;
		}
		return -1;
	}
	
	// block�� ���� �̵��ϴ� �Լ�
	public void moveUp() {
		int i = 0, j = 0, t = 0, valueJ = 0,valueI = 0, index = 0;
		for(i = 0;i < 5;i++)
	    {
	     index = i;
	     for(j = i + 5;j < 25;j += 5)
	     {  
	       valueJ = 0; valueI = 0;
	       if(block[index].getValue() == 0)
	       {
	         t = Find(index,5,0,25);
	         if(t != -1)
	         {
	           block[index].setValue(block[t].getValue());
	           block[t].setValue(0);
	         }
	         else
	         {
	           break;
	         }
	       }
	       valueI = block[index].getValue();
	       if(block[j].getValue() == 0)
	       {
	         t = Find(j,5,0,25);
	         if(t != -1)
	         {
	           block[j].setValue(block[t].getValue());
	           block[t].setValue(0);
	         }
	         else
	         {
	           break;
	         }
	       }
	       valueJ = block[j].getValue();
	       if(valueI == valueJ && valueI != 0 && valueJ != 0)
	       {
	         block[index].setValue(valueI + valueJ);
	         block[j].setValue(0);
	         running = true;
	       }
	       index = j;
	     }  
	   }
	}
	
	// block�� �Ʒ��� �̵��ϴ� �Լ�
	public void moveDown() {
		int i = 0, j = 0, t = 0, valueJ = 0,valueI = 0, index = 0;
		for(i = 20;i < 25;i++)
	    {
	     index = i;
	     for(j = i - 5;j >= 0;j -= 5)
	     {  
	       valueJ = 0; valueI = 0;
	       if(block[index].getValue() == 0)
	       {
	         t = Find(index,-5,0,25);
	         if(t != -1)
	         {
	           block[index].setValue(block[t].getValue());
	           block[t].setValue(0);
	         }
	         else
	         {
	           break;
	         }
	       }
	       valueI = block[index].getValue();
	       if(block[j].getValue() == 0)
	       {
	         t = Find(j,-5,0,25);
	         if(t != -1)
	         {
	           block[j].setValue(block[t].getValue());
	           block[t].setValue(0);
	         }
	         else
	         {
	           break;
	         }
	       }
	       valueJ = block[j].getValue();
	       if(valueI == valueJ && valueI != 0 && valueJ != 0)
	       {
	         block[index].setValue(valueI + valueJ);
	         block[j].setValue(0);
	         running = true;
	       }
	       index = j;
	     }  
	   }
	}
	
	// block�� ���������� �̵��ϴ� �Լ�
	public void moveRight() {
		int i = 0, j = 0, t = 0, valueJ = 0,valueI = 0, index = 0;
		for(i = 4;i < 25;i += 5)
	    {
	     index = i;
	     for(j = i - 1;j > i-5;j--)
	     {  
	       valueJ = 0; valueI = 0;
	       if(block[index].getValue() == 0)
	       {
	         t = Find(index,-1,i-4,index+2);
	         if(t != -1)
	         {
	           block[index].setValue(block[t].getValue());
	           block[t].setValue(0);
	         }
	         else
	         {
	           break;
	         }
	       }
	       valueI = block[index].getValue();
	       if(block[j].getValue() == 0)
	       {
	         t = Find(j,-1,i-4,j+2);
	         if(t != -1)
	         {
	           block[j].setValue(block[t].getValue());
	           block[t].setValue(0);
	         }
	         else
	         {
	           break;
	         }
	       }
	       valueJ = block[j].getValue();
	       if(valueI == valueJ && valueI != 0 && valueJ != 0)
	       {
	         block[index].setValue(valueI + valueJ);
	         block[j].setValue(0);
	         running = true;
	       }
	       index = j;
	     }  
	   }
	}
	
	// block�� �������� �̵��ϴ� �Լ�
	public void moveLeft() {
		int i = 0, j = 0, t = 0, valueJ = 0,valueI = 0, index = 0;
		for(i = 0;i < 25;i += 5)
		{
		  index = i;
		  for(j = i+1;j <i + 5;j++)
		  {  
		    valueJ = 0; valueI = 0;
		    if(block[index].getValue() == 0)
		    {
		      t = Find(index,1,index,i+5);
		      if(t != -1)
		      {
		        block[index].setValue(block[t].getValue());
		        block[t].setValue(0);
		      }
		      else
		      {
		        break;
		      }
		    }
		    valueI = block[index].getValue();
		    if(block[j].getValue() == 0)
		    {
		      t = Find(j,1,j,i+5);
		      if(t != -1)
		      {
		        block[j].setValue(block[t].getValue());
		        block[t].setValue(0);
		      }
		      else
		      {
		        break;
		      }
		    }
		    valueJ = block[j].getValue();
		    if(valueI == valueJ && valueI != 0 && valueJ != 0)
		    {
		      block[index].setValue(valueI + valueJ);
		      block[j].setValue(0);
		      EasyScore += block[index].getValue();
		      running = true;
		    }
		    index = j;
		  }  
	    }
	}
	
	// ���� �й� �˻� �Լ�
	public void gameOver() {
		if(running == false && up == false && down == false && right == false && left == false) {
			Music.gameOverMusic();		// ���� �й� ȿ���� ���
			block[0].setText("");
			block[1].setText("");
			block[2].setText("");
			block[3].setText("");
			block[4].setText("");
		    block[5].setText("G");
		    block[6].setText("A");
		    block[7].setText("M");
		    block[8].setText("E");
		    block[9].setText("");
		    block[10].setText("");
		    block[11].setText(""); 
		    block[12].setText(""); 
		    block[13].setText(""); 
		    block[14].setText(""); 
		    block[15].setText(""); 
		    block[16].setText("O"); 
		    block[17].setText("V"); 
		    block[18].setText("E"); 
		    block[19].setText("R"); 
		    block[20].setText(""); 
		    block[21].setText(""); 
		    block[22].setText(""); 
		    block[23].setText(""); 
		    block[24].setText("");
		    // ShowMessageDialog�� �̿��Ͽ� �õ�Ƚ���� score ǥ��
		    JOptionPane.showMessageDialog(panel, "Game Over...!\nTry : "+ EasyCnt +"\nScore : " + EasyScore);
		    reStart();
		}
	}
	
	// ���� �¸�  �˻� �Լ�
	public void gameWin() {
		for(int i = 0; i < 25; i ++) {
			if (block[i].getValue() >= 1024) {	// block�� 1024���� ũ��
				Music.gameWinMusic();		// ���� �¸� ȿ���� ���
				block[0].setText("");
				block[1].setText("");
				block[2].setText("");
				block[3].setText("");
				block[4].setText("");
			    block[5].setText("");
			    block[6].setText("Y");
			    block[7].setText("O");
			    block[8].setText("U");
			    block[9].setText("");
			    block[10].setText("");
			    block[11].setText(""); 
			    block[12].setText(""); 
			    block[13].setText(""); 
			    block[14].setText(""); 
			    block[15].setText(""); 
			    block[16].setText("W"); 
			    block[17].setText("I"); 
			    block[18].setText("N"); 
			    block[19].setText(""); 
			    block[20].setText(""); 
			    block[21].setText(""); 
			    block[22].setText(""); 
			    block[23].setText(""); 
			    block[24].setText(""); 
			    // ShowMessageDialog�� �̿��Ͽ� �õ�Ƚ���� score ǥ��
			    JOptionPane.showMessageDialog(panel, "You Win...!!\nTry : "+ EasyCnt +"\nScore : " + EasyScore);
			    reStart();
			}
		}
	}
	
	// ����� �Լ�(reset)
	public void reStart() {
		running = true;
	    up = true;
	    down = true;
	    left = true;
	    right = true;
	    EasyCnt = 0;
	    EasyScore = 0;
	    for(int i = 0;i < 25;i++)
	      block[i].setValue(0);
	    for (int i = 0; i < 2; i++)
	      createBlock();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:		// ���� ����Ű ������
			Music.moveBlockMusic();	// block �̵� ȿ���� ���
			EasyCnt++;
			if(up) {
				moveUp();
			}
			judgeCreate();
			createBlock();
			gameOver();
			gameWin();
			
			if(running == false) {
				up = false;
			}else {
				up = true;
			    down = true;
			    left = true;
			    right = true;
			}
			break;
		case KeyEvent.VK_DOWN:		// �Ʒ��� ����Ű ���� ��
			Music.moveBlockMusic();	// block �̵� ȿ���� ���
			EasyCnt++;
			if(down) {
				moveDown();
			}
			judgeCreate();
			createBlock();
			gameOver();
			gameWin();
			
			if(running == false) {
				down = false;
			}else {
				up = true;
			    down = true;
			    left = true;
			    right = true;
			}
			break;
		case KeyEvent.VK_RIGHT:		// ������ ����Ű ���� ��
			Music.moveBlockMusic();	// block �̵� ȿ���� ���
			EasyCnt++;
			if(right) {
				moveRight();
			}
			judgeCreate();
			createBlock();
			gameOver();
			gameWin();
			
			if(running == false) {
				right = false;
			}else {
				up = true;
			    down = true;
			    left = true;
			    right = true;
			}
			break;
		case KeyEvent.VK_LEFT:		// ���� ����Ű ���� ��
			Music.moveBlockMusic();	// block �̵� ȿ���� ���
			EasyCnt++;
			if(left) {
				moveLeft();
			}
			judgeCreate();
			createBlock();
			gameOver();
			gameWin();
			
			if(running == false) {
				left = false;
			}else {
				up = true;
			    down = true;
			    left = true;
			    right = true;
			}
			break;
		case KeyEvent.VK_R:			// RŰ ���� ��
			Music.moveBlockMusic();	// block �̵� ȿ���� ���
			reStart();				// ���� �����
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
