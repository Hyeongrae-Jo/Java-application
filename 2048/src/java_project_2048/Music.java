package java_project_2048;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Music {

	// music ������
	public Music() {
		
	}
	
	// ������� �Լ�
	static void BackGroundMusic(boolean Loop) { 	// boolean������ �Ű������� True�Ͻ� �ݺ����
		AudioInputStream ais;
		try {
			ais = AudioSystem.getAudioInputStream(new File("BGM.wav"));		// ��� ���� ���� ��������
			Clip clip = AudioSystem.getClip();		// Clip�� ����
			clip.open(ais);		// Clip ����
			clip.start();		// Clip ����
			
			if(Loop) clip.loop(-1);		// Loop�� True�Ͻ� -1�� �ǳ��� ������ �ݺ������ ����
			
		} catch (UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (LineUnavailableException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// block �̵� ȿ���� �Լ�
	static void moveBlockMusic() {
		AudioInputStream ais;
		try {
			ais = AudioSystem.getAudioInputStream(new File("moveBlock.wav"));	// block �̵� ȿ���� ���� ��������
			Clip clip = AudioSystem.getClip();	// Clip�� ����
			clip.open(ais);		// Clip ����
			clip.start();		// Clip ����
		} catch (UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (LineUnavailableException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// ���� �й� ȿ���� �Լ�
	static void gameOverMusic() {
		AudioInputStream ais;
		try {
			ais = AudioSystem.getAudioInputStream(new File("gameOver.wav"));	// ���� �й� �� ȿ���� ���� ��������
			Clip clip = AudioSystem.getClip();		// Clip�� ����
			clip.open(ais);		// Clip ����
			clip.start();		// Clip ����
		} catch (UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (LineUnavailableException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// ���� �¸� ȿ���� �Լ�
	static void gameWinMusic() {
		AudioInputStream ais;
		try {
			ais = AudioSystem.getAudioInputStream(new File("gameWin.wav"));		// ���� �¸� �� ȿ���� ���� ��������
			Clip clip = AudioSystem.getClip();		// Clip�� ����
			clip.open(ais);		// Clip ����
			clip.start();		// Clip ����
		} catch (UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (LineUnavailableException e) {
			System.out.println(e.getMessage());
		}
	}
}
