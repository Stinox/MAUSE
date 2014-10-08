package mause;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;

public class MyLine extends MyShape {

	public MyLine() {
		super();
	}

	public MyLine(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}

	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		Line2D.Double line = new Line2D.Double(x1, y1, x2, y2);
		g.setColor(strokeColor);
		g.draw(line);
	}
	
	public boolean contains(Point point){
		return (point.x >= startx && point.x <= startx+width && point.y >= starty && point.y <= starty+height);
	}
}