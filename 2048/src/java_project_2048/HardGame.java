package java_project_2048;

import javax.swing.*;
import java.awt.event.*;

public class HardGame implements KeyListener{
	
	private static int HardCnt = 0;
	private static int HardScore = 0;
	Block[] block;
	JPanel panel;
	public boolean up, down, right, left;
	boolean running;
	
	// HardGame 생성자
	public HardGame(JFrame frame) {
		this.panel = (JPanel)frame.getContentPane();
	    block = new Block[16];		// 16개의 block 생성
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
	
	// block 16개를 frame에 추가하는 함수
	private void addBlock() {
		for (int i = 0; i < 16; i++) //Add a block to the panel
	    {
	      block[i] = new Block();
	      block[i].setHorizontalAlignment(JLabel.CENTER);
	      block[i].setOpaque(true);
	      panel.add(block[i]);
	    }
	}
	
	// block을 두개를 랜덤 생성하는 함수
	public void createBlock(){
		while(running) {
			int index = (int)(Math.random() * 16);
			if(block[index].getValue() == 0) {
				if(Math.random() < 0.8) {
					block[index].setValue(2);		// 80퍼 확률로 2 생성
				}else {
					block[index].setValue(4);		// 20퍼 확률로 4 생성
				}break;
			}
		}
	}
	
	// block을 생성 여부를 판단하는 함수
	public void judgeCreate() {
		int sum = 0;
		for (int i = 0; i < 16; i++) {
			if(block[i].getValue() != 0) {
				sum++;
			}
		}
		if(sum == 16) {
			running = false;
		}
	}
	
	// 0이 아닌 block 값을 찾는 함수
	public int Find(int i, int j, int a, int b) {
		while(i < b && i >= a) {
			if(block[i].getValue() != 0) {
				return i;
			}
			i = i + j;
		}
		return -1;
	}
	
	// block을 위로 이동하는 함수
	public void moveUp() {
		int i = 0, j = 0, t = 0, valueJ = 0,valueI = 0, index = 0;
		for(i = 0;i < 4;i++)
	    {
	     index = i;
	     for(j = i + 4;j < 16;j += 4)
	     {  
	       valueJ = 0; valueI = 0;
	       if(block[index].getValue() == 0)
	       {
	         t = Find(index,4,0,16);
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
	         t = Find(j,4,0,16);
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
	
	// block을 아래로 이동하는 함수
	public void moveDown() {
		int i = 0, j = 0, t = 0, valueJ = 0,valueI = 0, index = 0;
		for(i = 12;i < 16;i++)
	    {
	     index = i;
	     for(j = i - 4;j >= 0;j -= 4)
	     {  
	       valueJ = 0; valueI = 0;
	       if(block[index].getValue() == 0)
	       {
	         t = Find(index,-4,0,16);
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
	         t = Find(j,-4,0,16);
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
	
	// block을 오른쪽으로 이동하는 함수
	public void moveRight() {
		int i = 0, j = 0, t = 0, valueJ = 0,valueI = 0, index = 0;
		for(i = 3;i < 16;i += 4)
	    {
	     index = i;
	     for(j = i - 1;j > i-4;j--)
	     {  
	       valueJ = 0; valueI = 0;
	       if(block[index].getValue() == 0)
	       {
	         t = Find(index,-1,i-3,index+1);
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
	         t = Find(j,-1,i-3,j+1);
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
	
	// block을 왼쪽으로 이동하는 함수
	public void moveLeft() {
		int i = 0, j = 0, t = 0, valueJ = 0,valueI = 0, index = 0;
		for(i = 0;i < 16;i += 4)
		{
		  index = i;
		  for(j = i+1;j <i + 4;j++)
		  {  
		    valueJ = 0; valueI = 0;
		    if(block[index].getValue() == 0)
		    {
		      t = Find(index,1,index,i+4);
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
		      t = Find(j,1,j,i+4);
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
		      HardScore += block[index].getValue();
		      running = true;
		    }
		    index = j;
		  }  
	    }
	}
	
	// 게임 패배 검사 함수
	public void gameOver() {
		if(running == false && up == false && down == false && right == false && left == false) {
			Music.gameOverMusic();		// 게임 패배 효과음 재생
			block[0].setText("G");
			block[1].setText("A");
			block[2].setText("M");
			block[3].setText("E");
			block[4].setText("");
		    block[5].setText("");
		    block[6].setText("");
		    block[7].setText("");
		    block[8].setText("");
		    block[9].setText("");
		    block[10].setText("");
		    block[11].setText(""); 
		    block[12].setText("O"); 
		    block[13].setText("V"); 
		    block[14].setText("E"); 
		    block[15].setText("R"); 
		    // ShowMessageDialog를 이용하여 시도횟수와 score 표시
		    JOptionPane.showMessageDialog(panel, "Game Over...!\nTry : "+ HardCnt +"\nScore : " + HardScore);
		    reStart();
		}
	}
	
	// 게임 승리  검사 함수
	public void gameWin() {
		for(int i = 0; i < 16; i ++) {
			if (block[i].getValue() >= 4096) {	// block이 4096보다 크면
				Music.gameWinMusic();		// 게임 승리 효과음 재생
				block[0].setText("");
				block[1].setText("");
				block[2].setText("");
				block[3].setText("");
				block[4].setText("Y");
				block[5].setText("O");
				block[6].setText("U");	    
				block[7].setText("");
				block[8].setText("");
				block[9].setText("W");
				block[10].setText("I");
				block[11].setText("N");
				block[12].setText("");
				block[13].setText("");
				block[14].setText("");
				block[15].setText("");
				// ShowMessageDialog를 이용하여 시도횟수와 score 표시
				JOptionPane.showMessageDialog(panel, "You Win...!!\nTry : "+ HardCnt +"\nScore : " + HardScore);
				reStart();
			}
		}
	}
	
	// 재시작 함수(reset)
	public void reStart() {
		running = true;
	    up = true;
	    down = true;
	    left = true;
	    right = true;
	    HardCnt = 0;
	    HardScore = 0;
	    for(int i = 0;i < 16;i++)
	      block[i].setValue(0);
	    for (int i = 0; i < 2; i++)
	      createBlock();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
		case KeyEvent.VK_UP:		// 위쪽 방향키 누를 시
			Music.moveBlockMusic();	// block 이동 효과음 재생
			HardCnt++;
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
		case KeyEvent.VK_DOWN:		// 아래쪽 방향키 누를 시
			Music.moveBlockMusic();	// block 이동 효과음 재생
			HardCnt++;
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
		case KeyEvent.VK_RIGHT:		// 오른쪽 방향키 누를 시
			Music.moveBlockMusic();	// block 이동 효과음 재생
			HardCnt++;
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
		case KeyEvent.VK_LEFT:		// 왼쪽 방향키 누를 시
			Music.moveBlockMusic();	// block 이동 효과음 재생
			HardCnt++;
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
		case KeyEvent.VK_R:			// R키 누를 시
			Music.moveBlockMusic();	// block 이동 효과음 재생
			reStart();				// 게임 재시작
		}
	}
	
	@Override
	public void keyTyped(KeyEvent e) {
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}
}
