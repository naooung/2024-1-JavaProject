package project;

import java.awt.*;
import javax.swing.*;

public class HelpPanel extends JPanel {
	JButton backButton;
	
	HelpPanel() {
		setLayout(null);
		
		backButton = new JButton(new ImageIcon("image\\Back.png"));
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setBounds(50, 20, 70, 70);
		add(backButton);
		
		
		JLabel title = new JLabel("Help");
		Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 50);
		title.setFont(font);
		title.setBounds(350, 20, 100, 60);
		add(title);
		
		
		Font font1 = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 20);
		Font font2 = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 13);
		
		JLabel qLabel = new JLabel("< PUZZLE GAME이란? >");
		qLabel.setFont(font1);
		qLabel.setBounds(70, 100, 800, 50);
		add(qLabel);
		
		JLabel explainLabel = new JLabel("랜덤하게 조각나있는 그림들을 이동하여 원래의 그림을 맞추는 게임입니다.");
		explainLabel.setFont(font2);
		explainLabel.setBounds(70, 150, 800, 50);
		add(explainLabel);
		
		JLabel methodLabel = new JLabel("< 게임 방법 >");
		methodLabel.setFont(font1);
		methodLabel.setBounds(70, 220, 250, 50);
		add(methodLabel);
		
		JLabel label1 = new JLabel("1. 퍼즐의 가로칸을 저장해주세요.");
		label1.setFont(font2);
		label1.setBounds(70, 270, 300, 50);
		add(label1);
		
		JLabel label2 = new JLabel("2. 퍼즐의 그림을 선택해주세요.");
		label2.setFont(font2);
		label2.setBounds(70, 310, 300, 50);
		add(label2);
		
		JLabel label3 = new JLabel("3. START 버튼을 누르세요.");
		label3.setFont(font2);
		label3.setBounds(70, 350, 300, 50);
		add(label3);
		
		JLabel label4 = new JLabel("4. 빈 퍼즐의 주변을 클릭하면 퍼즐이 움직입니다.");
		label4.setFont(font2);
		label4.setBounds(70, 390, 330, 50);
		add(label4);
		
		JLabel helpImage = new JLabel(new ImageIcon("image//Help.png"));
		helpImage.setBounds(380, 200, 400, 270);	
		add(helpImage);
		}
	
	JButton getBackButton() {
		return backButton;
	}
}
