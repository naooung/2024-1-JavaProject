package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel {
	MainView mainView;
	PuzzlePanel puzzlePanel;
	String imagePath;
	int n;
	JTextArea explainText1;
	JTextArea explainText2;
	JLabel timeLabel;
	JLabel moveLabel;
	Timer timer;
	private long time;
	public long runTime;
	public int runCount;
	
	GamePanel(MainView mainView, String imagePath, int n) {
		this.mainView = mainView;
		this.imagePath = imagePath;
		this.n = n;
		setLayout(null);
		
		JPanel helpPanel = new JPanel();
		helpPanel.setLayout(null);
		helpPanel.setBounds(10, 50, 400, 600);
		
		JPanel originalPanel = new JPanel() {
			Toolkit toolkit = this.getToolkit();
			Image image = toolkit.getImage(imagePath);
			
			public void paint(Graphics g) {
				g.drawImage(image, 0, 0, this);
			}
		};
		originalPanel.setBounds(10, 0, 400, 400);
		helpPanel.add(originalPanel);
		
		JLabel pictureLabel = new JLabel("ORIGINAL PICTURE");
		Font font1 = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 30);
		pictureLabel.setFont(font1);
		pictureLabel.setBounds(20, 300, 400, 50);
		helpPanel.add(pictureLabel);
		
		JButton replayButton = new JButton("REPLAY");
		replayButton.setBounds(50, 370, 100, 50);
		replayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mainView.changePanel("StartPanel");
			}
		});
		helpPanel.add(replayButton); 
		
		JButton resetButton = new JButton("RESET");
		resetButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
					puzzlePanel.randomPuzzle();
					puzzlePanel.repaint();
					timer.stop();
					time = 0;
					timer.start();
			}
		});
		resetButton.setBounds(170, 370, 100, 50);
		helpPanel.add(resetButton);
		add(helpPanel);		

		puzzlePanel = new PuzzlePanel(imagePath, n);
		puzzlePanel.setBounds(410, 50, 300, 300);
		add(puzzlePanel);
		
		JPanel explainPanel = new JPanel(new BorderLayout());
		explainText1 = new JTextArea("");
		Font font2 = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 12);
		explainText1.setFont(font2);
		explainText1.setBackground(new Color(210, 210, 210));
		explainPanel.add(explainText1, BorderLayout.NORTH);
		
		explainText2 = new JTextArea("");
		Font font3 = new Font(Font.SERIF, Font.ITALIC, 11);
		explainText2.setFont(font3);
		explainText2.setBackground(new Color(210, 210, 210));
		explainPanel.add(explainText2, BorderLayout.CENTER);
		
		setExplainText();
		explainPanel.setBounds(410, 360, 310, 70);
		add(explainPanel);
			
		timeLabel = new JLabel("TIME: 0");
		Font font4 = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 20);
		timeLabel.setFont(font4);
		timeLabel.setBounds(450, 450, 100, 50);
		add(timeLabel);
				moveLabel = new JLabel("MOVE: 0");
		moveLabel.setFont(font4);
		moveLabel.setBounds(600, 450, 100, 50);
		add(moveLabel);
		
		time = 0;
		timer = new Timer(1000, new ActionListener() {
			@Override
	           public void actionPerformed(ActionEvent e) {
	               time++;
	               timeLabel.setText("TIME: " + time);
	               moveLabel.setText("MOVE: " + puzzlePanel.getCount());
	               solved();
	           }
			});
			timer.start();
		
		setVisible(true);
	}
	
	void setExplainText() {
		if (imagePath == "image\\Delacroix.png") {
			explainText1.setText("외젠 들라크루아의 '민중을 이끄는 자유의 여신' 감상 Tip");
			explainText2.setText("\n1. 강렬한 색체와 명암의 대비를 통한 역동적인 화풍 "
					+ "\n2. 주변 색체와 대비되는 여신을 통한 혁명의 숭고함과 신성함");
		} 
		else if (imagePath == "image\\Millet.png") {
			explainText1.setText("장 프랑수아 밀레의 '이삭 줍는 여인들' 감상 Tip");
			explainText2.setText("\n1. 전경으로 갈 수록 어두워지는 빛과 그림자의 은은한 조화 "
					+ "\n2. 뒷 배경에 보이는 저택과 대비되는 소박한 서민의 삶");
		} 
		else if (imagePath == "image\\Monet.png") {
			explainText1.setText("클로드 모네의 '인상, 해돋이' 감상 Tip");
			explainText2.setText("\n1. 검은색을 사용하지 않고 밝은색으로만 그려낸 어두운 분위기 "
					+ "\n2. 찰나의 순간에 빛의 움직임을 표현");
		}
	}
	
	void solved() {
		if (puzzlePanel.solved() == true) {
			timer.stop();
        	runTime = time;
        	runCount = puzzlePanel.getCount();
        	EndPanel endPanel = new EndPanel
        			(mainView, imagePath, n, runTime, puzzlePanel.getCount());
			mainView.addPanel(endPanel, "EndPanel");
			mainView.changePanel("EndPanel");
		}
	}
}
