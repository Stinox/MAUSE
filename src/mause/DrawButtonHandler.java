package mause;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawButtonHandler implements ActionListener {
	
	private DrawingPanel drawingPanel;
	
	public DrawButtonHandler(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Stroke"){
			drawingPanel.setCurrentCCS(ColorChangeState.STROKE);
		}
		else if(e.getActionCommand() == "Fill"){
			drawingPanel.setCurrentCCS(ColorChangeState.FILL);
		}
	}	
}
