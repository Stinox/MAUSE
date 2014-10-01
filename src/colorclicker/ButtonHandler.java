package colorclicker;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JFrame;

public class ButtonHandler implements ActionListener {

	private DrawingPanel drawingPanel;
	private static Color[] colors = {Color.BLUE, Color.YELLOW, Color.BLACK, Color.CYAN, Color.GREEN, Color.PINK, Color.ORANGE, Color.RED, Color.MAGENTA};
	
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
		}
	}

	
}
