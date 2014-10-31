package mause;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class ColorButton extends JButton {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Color color;

	public ColorButton(Color color) {
		this.setPreferredSize(new Dimension(20,20));
		this.color = color;
		this.setBackground(color);
	}
	
	public Color getColor(){
		return color;
	}
}
