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
	private ArrayList<ToolButton> toolButtons = new ArrayList<ToolButton>();
	private Color selectedColor = new Color(0, 162, 255);
	private MyShape selectedShape;
	private Point mouse;
	private Point shape;
	
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
		case HAND:
			hand(point);
			break;
		case DELETE:
			delete(point);
			break;
		default:
			break;
		}
	}
	
	private void drawLine(Point point){
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
	
	private void drawRect(Point point){
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
	
	private void drawEllipse(Point point){
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
	
	private void hand(Point point){
		if(selectedShape != null && selectedShape.contains(point)){
			moveShape(point);
		}
		else {
			boolean found = false;
			for(int i = shapesList.size()-1; i >= 0 && !found; i--){
				if(shapesList.get(i).contains(point)){
					selectShape(shapesList.get(i));
					found = true;
				}
			}
			if (!found){
				selectedShape.setSelected(false);
				selectedShape = null;
			}
			repaint();
		}
	}
	
	public void moveShape(Point point){
		if(mouse == null || shape == null){
			mouse = point;
			shape = new Point(selectedShape.getX1(), selectedShape.getY1());
		} else {
			Point diff = getManhattanDistance(mouse, point);
			selectedShape.setCoords(shape.x + diff.x, shape.y + diff.y, selectedShape.getWidth(), selectedShape.getHeight());
		}
		repaint();
	}
	
	private Point getManhattanDistance(Point p1, Point p2){
		return new Point(p2.x - p1.x, p2.y - p1.y);
	}
	
	private void delete(Point point){
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
		for(ToolButton button : toolButtons){
			if(button.getTool() == tool){
				button.setBackground(selectedColor);
			}
			else {
				button.setBackground(null);
			}
		}
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
			stroke.setBackground(selectedColor);
			fill.setBackground(null);
			break;
		case FILL:
			fill.setBackground(selectedColor);
			stroke.setBackground(null);
			break;
		}
	}
	
	public void selectShape(MyShape shape){
		selectedShape = shape;
		for(MyShape s : shapesList){
			if(s == shape){
				s.setSelected(true);
			}
			else {
				s.setSelected(false);
			}
		}
		repaint();
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
	
	public void addButton(ToolButton button) {
		toolButtons.add(button);
	}
	
	public void stopMove(){
		mouse = null;
		shape = null;
	}
	
	public MyShape getSelectedShape(){
		return selectedShape;
	}

	public void setSelectedShape(MyShape selectedShape) {
		this.selectedShape = selectedShape;
	}
	
	
}
