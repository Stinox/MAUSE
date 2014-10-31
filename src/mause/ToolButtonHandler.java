package mause;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolButtonHandler implements ActionListener {

	private DrawingPanel drawingPanel;
	
	public ToolButtonHandler(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	public void actionPerformed(ActionEvent e) {
		drawingPanel.setSelectedTool(((ToolButton) e.getSource()).getTool());
	}
}
