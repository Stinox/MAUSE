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
			drawingPanel.setSelected(Tool.RECTANGLE);
		} else if(e.getActionCommand() == "Ellipse"){
			drawingPanel.setSelected(Tool.ELLIPSE);
		} else if(e.getActionCommand() == "Line"){
			drawingPanel.setSelected(Tool.LINE);
		} else if(e.getActionCommand() == "Delete"){
			drawingPanel.setSelected(Tool.DELETE);
		} else if(e.getActionCommand() == "Red"){
			drawingPanel.setColor(Color.RED);
		} else if(e.getActionCommand() == "Black"){
			drawingPanel.setColor(Color.BLACK);
		} else if(e.getActionCommand() == "Blue"){
			drawingPanel.setColor(Color.BLUE);
		}
	}

	
}
