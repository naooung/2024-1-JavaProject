package project;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.image.*;
import java.util.Random;
import javax.sound.sampled.*;
import java.io.File;


class PuzzlePanel extends JPanel  {
	private int n;
    private int spaceSize;
    private Image image;
    private Image[] imageSpace;
    private int emptySpace;
    private int[] numberSpace;
  	public int count;

    PuzzlePanel(String imagePath, int n) {
        this.n = n;
        this.spaceSize = 300 / n;
        this.setPreferredSize(new Dimension(300, 300));
        
        saveImageSpace(imagePath);
        randomPuzzle();        
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                handleMouseClick(e);
                solved();
            }
        });
    }
    
    int getCount() {
    	return count;
    }

    void saveImageSpace(String imagePath) {
    	imageSpace = new Image[n * n];
        numberSpace = new int[n * n];
        
        ImageIcon icon = new ImageIcon(imagePath);
        image = icon.getImage();

        int imageSize = 300;
        int index = 0;
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                BufferedImage smallImage = new BufferedImage
                		(imageSize / n, imageSize / n, BufferedImage.TYPE_INT_ARGB);
                Graphics g = smallImage.createGraphics();
                g.drawImage(image, 0, 0, imageSize / n, imageSize / n,
                		x * imageSize / n, y * imageSize / n, 
                		(x + 1) * imageSize / n, (y + 1) * imageSize / n, null);

                if (x == n - 1 && y == n - 1) 
                	imageSpace[index] = null;
                else 
                	imageSpace[index] = smallImage;
                
                numberSpace[index] = index;
                index++;
            }
        }
    }
    
    void randomPuzzle() {
    	count = 0;
    	Random random = new Random();
    	
        for (int i = 0; i < numberSpace.length; i++) {
        	int j = random.nextInt(numberSpace.length); 
         
            int temp = numberSpace[i];
            numberSpace[i] = numberSpace[j];
            numberSpace[j] = temp;
            
            if (numberSpace[i] == n * n - 1) {
                emptySpace = i;
            } else if (numberSpace[j] == n * n - 1) {
                emptySpace = j;
            }
        }
    }
    
    public void paint(Graphics g) {
        super.paint(g);

        for (int i = 0; i < numberSpace.length; i++) {
            int x = (i % n) * spaceSize;  
            int y = (i / n) * spaceSize; 
            
            int number = numberSpace[i];
            if (number != n * n - 1) {
                g.drawImage(imageSpace[number], x, y, this);
            }
        }
    }

    public void handleMouseClick(MouseEvent e) {
    	
        int clickX = e.getX() / spaceSize;
        int clickY = e.getY() / spaceSize;
    	int emptyX = emptySpace % n;
        int emptyY = emptySpace / n;

        if (Math.abs(emptyX - clickX) + Math.abs(emptyY - clickY) == 1) {
        	try {
        		AudioInputStream audio 
        		= AudioSystem.getAudioInputStream(new File("sound//Move.wav").getAbsoluteFile());
        		Clip clip = AudioSystem.getClip();
        		clip.open(audio);
        		clip.start();
        	} catch (Exception ex) {
        		System.out.println("Error with playing sound.");
        		ex.printStackTrace();
        	}
        	
        	int clickNumber = clickX + (clickY * n);
            int temp = numberSpace[clickNumber];
            numberSpace[clickNumber] = numberSpace[emptySpace];
            numberSpace[emptySpace] = temp;
            
            emptySpace = clickNumber;
            count++;
            
            repaint();
        }
    }
    
    public boolean solved() {
    	for (int i = 0; i < numberSpace.length; i++) {
            if (numberSpace[i] != i) {
            	return false;
            }
        }
    	return true;
    }
}