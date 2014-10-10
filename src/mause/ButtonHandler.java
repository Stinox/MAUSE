package mause;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonHandler implements ActionListener {

	private DrawingPanel drawingPanel;
	
	public ButtonHandler(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Rectangle"){
			drawingPanel.setSelectedTool(Tool.RECTANGLE);
		} 
		else if(e.getActionCommand() == "Ellipse"){
			drawingPanel.setSelectedTool(Tool.ELLIPSE);
		} 
		else if(e.getActionCommand() == "Line"){
			drawingPanel.setSelectedTool(Tool.LINE);
		} 
		else if (e.getActionCommand() == "Move"){
			drawingPanel.setSelectedTool(Tool.HAND);
		}
		else if(e.getActionCommand() == "Delete"){
			drawingPanel.setSelectedTool(Tool.DELETE);
		} 
		else if(e.getActionCommand() == "Red"){
			drawingPanel.setColor(Color.RED);
		} 
		else if(e.getActionCommand() == "Black"){
			drawingPanel.setColor(Color.BLACK);
		} 
		else if(e.getActionCommand() == "Blue"){
			drawingPanel.setColor(Color.BLUE);
		} 
		else if(e.getActionCommand() == "Stroke"){
			drawingPanel.setCurrentCCS(ColorChangeState.STROKE);
		}
		else if(e.getActionCommand() == "Fill"){
			drawingPanel.setCurrentCCS(ColorChangeState.FILL);
		}
	}

	
}
