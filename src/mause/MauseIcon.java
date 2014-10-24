package mause;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MauseIcon {
	
	public static MauseIcon rect = new MauseIcon("/icons/rectangle.png");
	
	private BufferedImage icon;
	
	public BufferedImage getIcon() {
		return icon;
	}

	public MauseIcon(String path){
		try {
			icon = ImageIO.read(MauseIcon.class.getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
