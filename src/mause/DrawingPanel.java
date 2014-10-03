package mause;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	
	private List<MyShape> shapesList = new ArrayList<MyShape>();
	
	private Tool selected;
	private MyShape lastDrawn = null;
	private int strokeSize = 3;
	private Color color;
	
	public MyShape getLastDrawn() {
		return lastDrawn;
	}

	public void setLastDrawn(MyShape lastDrawn) {
		this.lastDrawn = lastDrawn;
	}

	public DrawingPanel() {
		super();
		addMouseListener(new MouseHandler(this));
		addMouseMotionListener(new MouseHandler(this));
		selected = Tool.LINE;
		super.setBackground(Color.WHITE);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		for (MyShape s : shapesList)
			s.draw(g2d);
	}
	
	public void draw(Point point){
		switch (selected) {
		case LINE:
			drawLine(point);
			break;
		case RECTANGLE:
			drawRect(point);
			break;
		case ELLIPSE:
			drawEllipse(point);
			break;
		case DELETE:
			delete(point);
			break;
		default:
			break;
		}
	}
	
	public void drawLine(Point point){
		MyLine line = new MyLine();
		line.setCoords(point.x, point.y, point.x, point.y);
		shapesList.add(line);
		line.setStrokeSize(strokeSize);
		line.setColor(color);
		repaint();
		lastDrawn = line;
	}
	
	public void drawRect(Point point){
		MyRectangle rect = new MyRectangle();
		rect.setCoords(point.x, point.y, point.x, point.y);
		shapesList.add(rect);
		rect.setStrokeSize(strokeSize);
		rect.setColor(color);
		repaint();
		lastDrawn = rect;
	}
	
	public void drawEllipse(Point point){
		MyEllipse ellipse = new MyEllipse();
		ellipse.setCoords(point.x, point.y, point.x, point.y);
		shapesList.add(ellipse);
		ellipse.setStrokeSize(strokeSize);
		ellipse.setColor(color);
		repaint();
		lastDrawn = ellipse;
	}
	
	public void delete(Point point){
		for(int i = shapesList.size() - 1; i >= 0; i--){
			if(shapesList.get(i).contains(point)){
				shapesList.remove(i);
				break;
			}
		}
		repaint();
	}
	
	public void changeLastDrawn(Point point){
		if(lastDrawn != null && selected != Tool.DELETE){
			lastDrawn.setCoords(lastDrawn.x1, lastDrawn.y1, point.x, point.y);
			repaint();
		}
	}
	
	public void setSelected(Tool tool){
		selected = tool;
	}
	
	public void setStrokeSize(int thickness){
		strokeSize = thickness;
	}
	
	public void setColor(Color color){
		this.color = color;
	}

}
