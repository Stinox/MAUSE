package colorclicker;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	
	private List<MyShape> shapesList = new ArrayList<MyShape>();
	
	private Tool selected;
	private int i = 0;
	
	public DrawingPanel() {
		super();
		addMouseListener(new MouseHandler(this));
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
		line.setCoords(point.x, point.y, point.x + 50, point.y + 50);
		shapesList.add(line);
		repaint();
	}
	
	public void drawRect(Point point){
		MyRectangle rect = new MyRectangle();
		rect.setCoords(point.x, point.y, point.x + 50, point.y + 50);
		shapesList.add(rect);
		repaint();
	}
	
	public void drawEllipse(Point point){
		MyEllipse ellipse = new MyEllipse();
		ellipse.setCoords(point.x, point.y, point.x + 50, point.y + 50);
		shapesList.add(ellipse);
		repaint();
	}
	
	public void delete(Point point){
		
		
	}
	
	public void setSelected(Tool tool){
		selected = tool;
	}
}
