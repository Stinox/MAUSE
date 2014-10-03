package mause;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Ellipse2D;

public class MyEllipse extends MyShape {

	public MyEllipse() {
		super();
	}

	public MyEllipse(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}

	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		Ellipse2D.Double ellipse = new Ellipse2D.Double(startx, starty, width,
				height);
		g.draw(ellipse);
	}
	
	public boolean contains(Point point){
		return (point.x >= startx && point.x <= startx+width && point.y >= starty && point.y <= starty+height);
	}
}