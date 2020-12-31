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

	// music 생성자
	public Music() {
		
	}
	
	// 배경음악 함수
	static void BackGroundMusic(boolean Loop) { 	// boolean변수를 매개변수로 True일시 반복재생
		AudioInputStream ais;
		try {
			ais = AudioSystem.getAudioInputStream(new File("BGM.wav"));		// 배경 음악 파일 가져오기
			Clip clip = AudioSystem.getClip();		// Clip에 저장
			clip.open(ais);		// Clip 열기
			clip.start();		// Clip 시작
			
			if(Loop) clip.loop(-1);		// Loop가 True일시 -1은 맨끝에 닿으면 반복재생을 뜻함
			
		} catch (UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (LineUnavailableException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// block 이동 효과음 함수
	static void moveBlockMusic() {
		AudioInputStream ais;
		try {
			ais = AudioSystem.getAudioInputStream(new File("moveBlock.wav"));	// block 이동 효과음 파일 가져오기
			Clip clip = AudioSystem.getClip();	// Clip에 저장
			clip.open(ais);		// Clip 열기
			clip.start();		// Clip 시작
		} catch (UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (LineUnavailableException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 게임 패배 효과음 함수
	static void gameOverMusic() {
		AudioInputStream ais;
		try {
			ais = AudioSystem.getAudioInputStream(new File("gameOver.wav"));	// 게임 패배 시 효과음 파일 가져오기
			Clip clip = AudioSystem.getClip();		// Clip에 저장
			clip.open(ais);		// Clip 열기
			clip.start();		// Clip 시작
		} catch (UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (LineUnavailableException e) {
			System.out.println(e.getMessage());
		}
	}
	
	// 게임 승리 효과음 함수
	static void gameWinMusic() {
		AudioInputStream ais;
		try {
			ais = AudioSystem.getAudioInputStream(new File("gameWin.wav"));		// 게임 승리 시 효과음 파일 가져오기
			Clip clip = AudioSystem.getClip();		// Clip에 저장
			clip.open(ais);		// Clip 열기
			clip.start();		// Clip 시작
		} catch (UnsupportedAudioFileException e) {
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (LineUnavailableException e) {
			System.out.println(e.getMessage());
		}
	}
}
