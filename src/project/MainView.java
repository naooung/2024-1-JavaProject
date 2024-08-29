package project;

import java.awt.*;
import javax.swing.*;


public class MainView extends JFrame {
	CardLayout cardLayout = new CardLayout();
	JPanel cardPanel;
	
	MainView() {
		
		cardPanel = new JPanel(cardLayout);
		add(cardPanel);
		
		setTitle("Puzzle Game Project");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setPreferredSize(new Dimension(800,550));
		pack();
		setVisible(true);
	}
	
    public void addPanel(JPanel panel, String panelname) {
        cardPanel.add(panel, panelname);
    }
    
	public void changePanel(String panelname) {
		cardLayout.show(cardPanel, panelname);
	}
} 

