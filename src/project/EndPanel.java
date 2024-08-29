package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EndPanel extends JPanel {
	MainView mainView;
	int n;
	int time;
	int count;
	String painter;
	
	EndPanel(MainView mainView, String imagePath, int n, long time, int count) {
		this.mainView = mainView;
		setLayout(new GridLayout(3,1));
		
		JLabel title = new JLabel("GAME CLEAR!");
		Font font1 = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 50);
		title.setFont(font1);
		title.setHorizontalAlignment(JLabel.CENTER);
		add(title);
		

		JPanel resultPanel = new JPanel(null);
		Font font2 = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 17);
				
		JLabel timeLabel = new JLabel("");
		timeLabel.setFont(font2);
		timeLabel.setBounds(100, 0, 150, 50);
		resultPanel.add(timeLabel);
		
		if (time >= 60) {
			long min = time / 60;
			long sec = time % 60;
			timeLabel.setText("소요시간: " + min + "분 " + sec + "초");
		} else 
			timeLabel.setText("소요시간: " + time + "초");
		
		JLabel countLabel = new JLabel("이동횟수: " + count + "회");
		countLabel.setFont(font2);
		countLabel.setBounds(100, 100, 150, 50);
		resultPanel.add(countLabel);
		
		JLabel scoreImage = new JLabel(new ImageIcon("image\\Score.png"));
		scoreImage.setBounds(290, 40, 400, 150);
		resultPanel.add(scoreImage);
		
		if (imagePath == "image\\Delacroix.png") 
			painter = "들라크루아";
		else if (imagePath == "image\\Millet.png") 
			painter = "밀레";
		else if (imagePath == "image\\Monet.png") 
			painter = "모네";

		JLabel score = new JLabel("");
		if (n <= 3) {
			if (time <= 30) {
				score.setBounds(580, 10, 200, 50);
				score.setText("\"" + painter + " 전문가 \"");
			} else if (time <= 60) {
				score.setBounds(480, 10, 200, 50);
				score.setText("\"" + painter + " 고수 \"");
			} else if (time <= 120) {
				score.setBounds(380, 10, 200, 50);
				score.setText("\"" + painter + " 중수 \"");
			} else {
				score.setBounds(290, 10, 200, 50);
				score.setText("\"" + painter + " 초보 \"");
			}
		} else {
			if (time <= 60) {
				score.setBounds(580, 10, 200, 50);
				score.setText("\"" + painter + " 전문가 \"");
			} else if (time <= 120) {
				score.setBounds(480, 10, 200, 50);
				score.setText("\"" + painter + " 고수 \"");
			} else if (time <= 180) {
				score.setBounds(380, 10, 200, 50);
				score.setText("\"" + painter + " 중수 \"");
			} else {
				score.setBounds(290, 10, 200, 50);
				score.setText("\"" + painter + " 초보 \"");
			}
		}
		
		score.setFont(font2);
		resultPanel.add(score);	
		add(resultPanel);

		JPanel lastPanel = new JPanel(null);
		JButton restartButton = new JButton("RESTART");
		restartButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainView.changePanel("StartPanel");
			}
		});
		restartButton.setBounds(150, 80, 200, 50);
		lastPanel.add(restartButton); 
					
		JButton exitButton = new JButton("EXIT");
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		exitButton.setBounds(450, 80, 200, 50);
		lastPanel.add(exitButton);
		add(lastPanel);
	
		setVisible(true);
	}
}
