package project;

import java.awt.*;
import javax.swing.*;

public class StartPanel extends JPanel {
	JButton helpButton;
	JTextField text;
	JButton nButton;
	JButton startButton;
	JButton delacroixButton;
	JButton milletButton;
	JButton monetButton;
	
	StartPanel() {
		setLayout(new BorderLayout());
		
		JPanel introPanel = new JPanel();
		JLabel title = new JLabel("PUZZLE GAME");
		Font font = new Font(Font.SERIF, Font.BOLD + Font.ITALIC, 50);
		title.setFont(font);
		title.setHorizontalAlignment(JLabel.CENTER);
		introPanel.add(title);
		
		helpButton = new JButton(new ImageIcon("image\\Light.png"));
		helpButton.setBorderPainted(false);
		helpButton.setContentAreaFilled(false);
		introPanel.add(helpButton);
		add(introPanel, BorderLayout.NORTH);
		
		JPanel choosePanel = new JPanel(new BorderLayout());
		JPanel setupPanel = new JPanel();
		JLabel nLabel = new JLabel("<html> 생성할 퍼즐의 가로칸 입력 <br> ( → ˙ ˘ ˙) → → → </html>");
		nLabel.setHorizontalAlignment(JLabel.CENTER);
		setupPanel.add(nLabel);
		
		text = new JTextField(3);
		setupPanel.add(text);
		
		nButton = new JButton("SAVE");
		setupPanel.add(nButton);
		choosePanel.add(setupPanel, BorderLayout.NORTH);
 
        JPanel imagePanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 50));
        delacroixButton = new JButton(new ImageIcon("image\\Delacroix.png"));
        delacroixButton.setPreferredSize(new Dimension(230, 230));
        imagePanel.add(delacroixButton);
        
        milletButton = new JButton(new ImageIcon("image\\Millet.png"));
        milletButton.setPreferredSize(new Dimension(230, 230));
        imagePanel.add(milletButton);
        
        monetButton = new JButton(new ImageIcon("image\\Monet.png"));
        monetButton.setPreferredSize(new Dimension(230, 230));
        imagePanel.add(monetButton);
        choosePanel.add(imagePanel, BorderLayout.CENTER);
        
        JPanel explainPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 5));
        explainPanel.setPreferredSize(new Dimension(800, 50));
        JLabel label1 = new JLabel("들라크루아 '민중을 이끄는 자유의 여신'");
        label1.setPreferredSize(new Dimension(280, 20));
        explainPanel.add(label1);
        
        JLabel label2 = new JLabel("밀레 '이삭 줍는 여인들'");
        label2.setPreferredSize(new Dimension(250, 20));
        explainPanel.add(label2);
        
        JLabel label3 = new JLabel("모네 '인상, 해돋이'");
        label3.setPreferredSize(new Dimension(160, 20));
        explainPanel.add(label3);
        choosePanel.add(explainPanel, BorderLayout.SOUTH);
        add(choosePanel, BorderLayout.CENTER);
        
        JPanel actionPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		startButton = new JButton("START"); 
		startButton.setPreferredSize(new Dimension(300, 50));
		actionPanel.add(startButton);
		add(actionPanel, BorderLayout.SOUTH);
		
		setVisible(true);
	}
	
	int getN() {
		return Integer.parseInt(text.getText());
	}
	
	JButton getHelpButton() {
		return helpButton;
	}
	
	JButton getNButton() {
		return nButton;
	}
	
	JButton getDelacroixButton() {
		return delacroixButton;
	}
	
	JButton getMilletButton() {
		return milletButton;
	}
	
	JButton getMonetButton() {
		return monetButton;
	}
	
	JButton getStartButton() {
		return startButton;
	}
}

