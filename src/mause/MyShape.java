package mause;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;

public abstract class MyShape {

	protected int x1, y1, x2, y2;
	protected int width, height, startx, starty;
	protected int strokeSize;
	protected Color strokeColor;
	protected Color fillColor;
	protected int borderPadding = 3;
	
	public boolean contains(Point point){
		return (point.x >= startx - strokeSize/2 && point.x <= startx + width + strokeSize/2
				&& point.y >= starty - strokeSize/2 && point.y <= starty + height + strokeSize/2);
	}
	
	public MyShape() {
		this(0, 0, 0, 0);
	}

	public MyShape(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}

	public void draw(Graphics2D g) {
		width = Math.abs(this.x1 - this.x2);
		height = Math.abs(this.y1 - this.y2);
		startx = Math.min(this.x1, this.x2);
		starty = Math.min(this.y1, this.y2);
		g.setStroke(new BasicStroke(strokeSize));
		g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
	}
	
	public void drawBorder(Graphics2D g2d){
		g2d.setColor(Color.BLACK);
		float dash[] = { 5f };
		g2d.setStroke(new BasicStroke(1.0f, BasicStroke.CAP_BUTT,
				BasicStroke.JOIN_MITER, 10.0f, dash, 0.0f));
		Rectangle2D.Double border = new Rectangle2D.Double(startx
				- borderPadding - strokeSize / 2, starty - borderPadding
				- strokeSize / 2, width + borderPadding * 2 + strokeSize -1, height + borderPadding * 2 + strokeSize - 1);
		g2d.draw(border);		
	}
		
	public void setStrokeSize(int thickness){
		strokeSize = thickness;
	}
	
	public void setStrokeColor(Color color){
		this.strokeColor = color;
	}
	
	public void setFillColor(Color color){
		this.fillColor = color;
	}
	
	public void setCoords(int x1, int y1, int x2, int y2) {
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}

	public int getX1() {
		return x1;
	}

	public void setX1(int x1) {
		this.x1 = x1;
	}

	public int getY1() {
		return y1;
	}

	public void setY1(int y1) {
		this.y1 = y1;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2) {
		this.y2 = y2;
	}
	
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}