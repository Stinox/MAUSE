package mause;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;

public class MyImage extends MyShape{
	
	private BufferedImage image;
	
	public MyImage(int x1,int y1){
		super.x1 = x1;
		super.y1 = y1;
		
		JFileChooser browser = new JFileChooser();
		browser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		int returnVal = browser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION){
			try {
				image = ImageIO.read(browser.getSelectedFile());
				super.width = image.getWidth();
				super.height = image.getHeight();
				super.x2 = image.getWidth() + x1;
				super.y2 = image.getHeight() + y1;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void draw(Graphics2D g2d){
		super.draw(g2d);
		g2d.drawImage(image, x1, y1, null);
	}
	
	public BufferedImage getImage(){
		return image;
	}
}
