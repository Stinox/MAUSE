package mause;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Rectangle2D;

public class MyRectangle extends MyShape {

	public MyRectangle() {
		super();
	}

	public MyRectangle(int x1, int y1, int x2, int y2) {
		super(x1, y1, x2, y2);
	}

	@Override
	public void draw(Graphics2D g) {
		super.draw(g);
		Rectangle2D.Double rect = new Rectangle2D.Double(startx, starty, width,
				height);
		if (fill) {
			g.setColor(fillColor);
			g.fill(rect);
		}
		g.setColor(strokeColor);
		g.draw(rect);
	}

	public boolean contains(Point point) {
		return (point.x >= startx && point.x <= startx + width
				&& point.y >= starty && point.y <= starty + height);
	}
}