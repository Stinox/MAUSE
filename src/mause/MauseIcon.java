package mause;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class MauseIcon {
	
	public static MauseIcon image = new MauseIcon("/icons/image.png");
	public static MauseIcon text = new MauseIcon("/icons/text.png");
	public static MauseIcon rect = new MauseIcon("/icons/rectangle.png");
	public static MauseIcon ellipse = new MauseIcon("/icons/ellipse.png");
	public static MauseIcon line = new MauseIcon("/icons/line.png");
	public static MauseIcon move = new MauseIcon("/icons/move.png");
	public static MauseIcon resize = new MauseIcon("/icons/resize.png");
	public static MauseIcon delete = new MauseIcon("/icons/delete.png");
	
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
