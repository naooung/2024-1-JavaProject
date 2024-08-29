package project;

import java.awt.event.*;
import java.io.File;
import javax.swing.*;
import javax.sound.sampled.*;

public class Controller {
	Model model = new Model();
	MainView mainView = new MainView();
	StartPanel startPanel = new StartPanel();
	HelpPanel helpPanel = new HelpPanel();
	GamePanel gamePanel;
	
	Controller() {
		try {
    		AudioInputStream audio 
    		= AudioSystem.getAudioInputStream(new File("sound//BGM.wav").getAbsoluteFile());
    		Clip clip = AudioSystem.getClip();
    		clip.open(audio);
    		clip.start();
    	} catch (Exception ex) {
    		System.out.println("Error with playing sound.");
    		ex.printStackTrace();
    	}
		startPanelListener();
		helpPanelListener();
	}
	
	public void startPanelListener() {
		
		this.startPanel.getHelpButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainView.addPanel(helpPanel, "HelpPanel");
				mainView.changePanel("HelpPanel");
			}
		});
		
		this.startPanel.getNButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clickSound();
				try {
					int n = startPanel.getN();
					if (n < 2) {
						JOptionPane.showMessageDialog(startPanel, "1보다 큰 숫자를 입력해주세요!");
					}
					else {
						JOptionPane.showMessageDialog(startPanel, n + " x " + n + " 퍼즐이 생성됩니다.", 
								"SAVE", JOptionPane.PLAIN_MESSAGE);
						model.setN(n);
					}
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(startPanel, "숫자를 입력해주세요!");
				}
			}
		});
		
		this.startPanel.getDelacroixButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clickSound();
				model.setImagePath("image\\Delacroix.png"); 
				ImageIcon image = new ImageIcon(model.getImagePath());
				JOptionPane.showMessageDialog(startPanel, 
						"<민중을 이끄는 자유의 여신> \n낭만주의 화가 외젠 들라크루아가 프랑스 7월 혁명을 기념하여 그린 그림 \n "
						+ "\n\"나는 현대적인 주제, 즉 바리케이트전(戰)을 그리기 시작했습니다. "
						+ "\n나는 조국의 승리를 위해 직접 나서지는 못했지만 "
						+ "\n그래도 조국을 위해 이 그림을 그리고 싶습니다.\"", "그림 생성", 
						JOptionPane.INFORMATION_MESSAGE, image); 
			}
		});
		
		this.startPanel.getMilletButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clickSound();
				model.setImagePath("image\\Millet.png");
				ImageIcon image = new ImageIcon(model.getImagePath());
				JOptionPane.showMessageDialog(startPanel, 
						"<이삭 줍는 사람들> \n사실주의 화가 장 프랑수아 밀레가 농촌의 생활을 그린 그림 \n "
						+ "\n\"다른 사람을 감동시키려면 먼저 자신이 감동하지 않으면 안된다."
						+ "\n그렇지 못하면 아무리 정교한 작품이라도 결코 생명력을 갖지 못한다.\"", "그림 생성", 
						JOptionPane.INFORMATION_MESSAGE, image); 
			}
		});
		
		this.startPanel.getMonetButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				clickSound();
				model.setImagePath("image\\Monet.png");
				ImageIcon image = new ImageIcon(model.getImagePath());
				JOptionPane.showMessageDialog(startPanel, 
						"<인상, 해돋이> \n인상주의 화가 클로드 모네가 프랑스 항구의 아침 풍경을 그린 그림\n "
						+ "\n\"우리가 실제로 보는 것은 반사된 빛이므로,"
						+ "\n진짜 눈에 보이는 그대로 그리려면 반사된 빛을 그리면 된다.\"", "그림 생성", 
						JOptionPane.INFORMATION_MESSAGE, image); 
			}
		});
		
		this.startPanel.getStartButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int n = model.getN();
				
				if (n > 1 && model.getImagePath() != null) {
					gamePanel = new GamePanel(mainView, model.getImagePath(), n);
					mainView.addPanel(gamePanel, "GamePanel");
					mainView.changePanel("GamePanel");
				} 
				else if (model.getImagePath() == null) {
					JOptionPane.showMessageDialog(startPanel, "생성할 그림을 선택해주세요!"); 
				}
				else
					JOptionPane.showMessageDialog(startPanel, "퍼즐의 가로칸을 저장해주세요.");
			}
			
		});
	}
	void helpPanelListener() {
		helpPanel.getBackButton().addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainView.changePanel("StartPanel");
			}
		});
	}
	
	void clickSound() {
		try {
    		AudioInputStream audio 
    		= AudioSystem.getAudioInputStream(new File("sound//Click.wav").getAbsoluteFile());
    		Clip clip = AudioSystem.getClip();
    		clip.open(audio);
    		clip.start();
    	} catch (Exception ex) {
    		System.out.println("Error with playing sound.");
    		ex.printStackTrace();
    	}
	}
	
	void start() {
		mainView.addPanel(startPanel, "StartPanel");
		mainView.changePanel("StartPanel");
	}
}