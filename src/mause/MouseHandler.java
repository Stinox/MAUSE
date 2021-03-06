package mause;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseHandler implements MouseListener, MouseMotionListener {
	
	private DrawingPanel drawingPanel;
	
	public MouseHandler(DrawingPanel drawingPanel) {
		this.drawingPanel = drawingPanel;
	}

	@Override
	public void mouseClicked(MouseEvent e) {		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		drawingPanel.draw(e.getPoint());
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		if(drawingPanel.getLastDrawn() != null){
			drawingPanel.setSelectedShape(drawingPanel.getLastDrawn());
			drawingPanel.setLastDrawn(null);
		}
		drawingPanel.stopMove();
		drawingPanel.repaint();
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		drawingPanel.changeLastDrawn(e.getPoint());
		if(drawingPanel.getSelectedShape() != null)
			drawingPanel.hand(e.getPoint());
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
