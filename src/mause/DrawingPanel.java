package mause;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
	
public class DrawingPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	private Point startMouseCoor;
	private Point startShapeCoor;
	private boolean isResizing = false;
	
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
		if(selectedShape != null)
			selectedShape.drawBorder(g2d);
	}
	

	public void draw(Point point){
		switch (selectedTool) {
		case IMAGE:
			createImage(point);
			break;
		case TEXT:
			createText(point);
			break;
		case LINE:
			drawLine(point);
			break;
		case RECTANGLE:
			drawRect(point);
			break;
		case ELLIPSE:
			drawEllipse(point);
			break;
		case MOVE:
			hand(point);
			break;
		case RESIZE:
			hand(point);
			break;
		case DELETE:
			delete(point);
			break;
		default:
			break;
		}
	}
	
	private void createImage(Point point){
		selectedShape = null;
		MyImage image = new MyImage(point.x, point.y);
		if(image.getImage() != null){
			shapesList.add(image);
			selectedShape = image;
			repaint();
		}
	}
	
	private void createText(Point point){
		selectedShape = null;
		MyText text = new MyText(point.x, point.y, this);
		shapesList.add(text);
		selectedShape = text;
		text.setStrokeColor(strokeColor);
		repaint();
	}
	
	private void drawLine(Point point){
		selectedShape = null;
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
		selectedShape = null;
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
		selectedShape = null;
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
	
	public void hand(Point point){
		if(selectedShape != null && (selectedShape.contains(point) || isResizing)){
			isResizing = true;
			if(selectedTool == Tool.MOVE)
				moveShape(point);
			else
				resizeShape(point);
		}
		else {
			boolean found = false;
			for(int i = shapesList.size()-1; i >= 0 && !found; i--){
				if(shapesList.get(i).contains(point)){
					selectedShape = shapesList.get(i);
					found = true;
				}
			}
			if (!found){
				selectedShape = null;
			}
			repaint();
		}
	}
	
	private void moveShape(Point point){
		if(startMouseCoor == null || startShapeCoor == null){
			startMouseCoor = point;
			startShapeCoor = new Point(selectedShape.getX1(), selectedShape.getY1());
		} else {
			Point diff = getManhattanDistance(startMouseCoor, point);
			selectedShape.setCoords(startShapeCoor.x + diff.x, startShapeCoor.y + diff.y, startShapeCoor.x+selectedShape.getWidth()+diff.x,
									startShapeCoor.y+selectedShape.getHeight()+diff.y);
		}
		repaint();
	}
	
	private void resizeShape(Point point){
		if(startMouseCoor == null || startShapeCoor == null){
			startMouseCoor = point;
			startShapeCoor = new Point(selectedShape.getX1(), selectedShape.getY1());
		} else {
			Point diff = getManhattanDistance(startMouseCoor, point);
			selectedShape.setCoords(startShapeCoor.x, startShapeCoor.y, startShapeCoor.x+selectedShape.getWidth()+diff.x,
									startShapeCoor.y+selectedShape.getHeight()+diff.y);
			startMouseCoor = point;
		}
		repaint();
	}
	
	private Point getManhattanDistance(Point p1, Point p2){
		return new Point(p2.x - p1.x, p2.y - p1.y);
	}
	
	private void delete(Point point){
		for(int i = shapesList.size() - 1; i >= 0; i--){
			if(shapesList.get(i).contains(point)){
				if(shapesList.get(i) == selectedShape)
					selectedShape = null;
				shapesList.remove(i);
				break;
			}
		}
		repaint();
	}
	
	// Resizes shape while drawing
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
		switch (tool) {
		case MOVE:
			this.setCursor(new Cursor(Cursor.MOVE_CURSOR));
			break;
		case RESIZE:
			this.setCursor(new Cursor(Cursor.SE_RESIZE_CURSOR));
			break;
		case DELETE:
			this.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(MauseIcon.delete.getIcon(), new Point(16,16), "deleteCursor"));
			break;
		default:
			this.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			break;
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
		startMouseCoor = null;
		startShapeCoor = null;
		isResizing = false;
	}
	
	public MyShape getSelectedShape(){
		return selectedShape;
	}

	public void setSelectedShape(MyShape selectedShape) {
		this.selectedShape = selectedShape;
	}
	
	
}
