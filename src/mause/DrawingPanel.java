package mause;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;

public class DrawingPanel extends JPanel {
	
	private List<MyShape> shapesList = new ArrayList<MyShape>();
	
	private Tool selectedTool;
	private MyShape lastDrawn = null;
	private int strokeSize = 3;
	private Color strokeColor = Color.BLACK;
	private Color fillColor = Color.WHITE;
	private ColorChangeState currentCCS;
	private JButton stroke;
	private JButton fill;
	private JCheckBox fillCheck;
	
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
		selectedTool = Tool.RECTANGLE;
		currentCCS = ColorChangeState.STROKE;
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
		switch (selectedTool) {
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
		line.setStrokeColor(strokeColor);
		line.setFillColor(fillColor);
		line.setFill(fillCheck.isSelected());
		repaint();
		lastDrawn = line;
	}
	
	public void drawRect(Point point){
		MyRectangle rect = new MyRectangle();
		rect.setCoords(point.x, point.y, point.x, point.y);
		shapesList.add(rect);
		rect.setStrokeSize(strokeSize);
		rect.setStrokeColor(strokeColor);
		rect.setFillColor(fillColor);
		rect.setFill(fillCheck.isSelected());
		repaint();
		lastDrawn = rect;
	}
	
	public void drawEllipse(Point point){
		MyEllipse ellipse = new MyEllipse();
		ellipse.setCoords(point.x, point.y, point.x, point.y);
		shapesList.add(ellipse);
		ellipse.setStrokeSize(strokeSize);
		ellipse.setStrokeColor(strokeColor);
		ellipse.setFillColor(fillColor);
		ellipse.setFill(fillCheck.isSelected());
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
		if(lastDrawn != null && selectedTool != Tool.DELETE){
			lastDrawn.setCoords(lastDrawn.x1, lastDrawn.y1, point.x, point.y);
			repaint();
		}
	}
	
	public void setSelectedTool(Tool tool){
		selectedTool = tool;
	}
	
	public void setStrokeSize(int thickness){
		strokeSize = thickness;
	}
	
	public void setColor(Color color){
		switch(currentCCS) {
			case STROKE:
				this.strokeColor = color;
				stroke.setForeground(color);
				break;
			case FILL:
				this.fillColor = color;
				fill.setForeground(color);
				break;
		}
		
	}

	public void setCurrentCCS(ColorChangeState currentCCS) {
		this.currentCCS = currentCCS;
		switch(currentCCS) {
		case STROKE:
			stroke.setBackground(new Color(0, 162, 255));
			fill.setBackground(null);
			break;
		case FILL:
			fill.setBackground(new Color(0, 162, 255));
			stroke.setBackground(null);
			break;
		}
	}

	public void setStroke(JButton stroke) {
		this.stroke = stroke;
	}

	public void setFill(JButton fill) {
		this.fill = fill;
	}

	public void setFillCheck(JCheckBox fillCheck) {
		this.fillCheck = fillCheck;
	}
	

}
