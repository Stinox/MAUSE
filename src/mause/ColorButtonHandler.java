package mause;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorButtonHandler implements ActionListener{

	private DrawingPanel drawingPanel;
	
	public ColorButtonHandler(DrawingPanel dp){
		this.drawingPanel = dp;
	}

	public void actionPerformed(ActionEvent e) {
		drawingPanel.setColor(((ColorButton) e.getSource()).getColor());
	}
}