package mause;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;

public abstract class MyShape {

	protected int x1, y1, x2, y2;
	protected int width, height, startx, starty;
	protected int strokeSize;
	protected Color strokeColor;
	protected Color fillColor;
	protected boolean fill;
	protected boolean isSelected = true;
	protected int borderPadding = 3;
	
	public abstract boolean contains(Point point);
	
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

	public void setFill(boolean fill) {
		this.fill = fill;
	}
	
	public void setSelected(boolean bool){
		isSelected = bool;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}
	
}