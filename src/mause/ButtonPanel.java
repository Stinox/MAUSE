package mause;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class ButtonPanel extends JPanel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Color selectedColor = new Color(0,162,255);
	
	private int[] colors = {0x000000, 0xff00ff, 0x0000ff, 0x00ffff, 0x00ff00, 0xffff00, 0xff0000, 0xffffff}; 

	public ButtonPanel(DrawingPanel drawingPanel) {
		super();
		// Add a button to the panel . The argument to the JButton constructor
		// will become the text on the button .
		ToolButton rect = new ToolButton(new ImageIcon(MauseIcon.rect.getIcon()), Tool.RECTANGLE);
		this.add(rect);
		rect.addActionListener(new ToolButtonHandler(drawingPanel));
		drawingPanel.addButton(rect);
		rect.setBackground(selectedColor);
		
		ToolButton ellipse = new ToolButton(new ImageIcon(MauseIcon.ellipse.getIcon()), Tool.ELLIPSE);
		this.add(ellipse);
		ellipse.addActionListener(new ToolButtonHandler(drawingPanel));
		drawingPanel.addButton(ellipse);
		
		ToolButton line = new ToolButton(new ImageIcon(MauseIcon.line.getIcon()), Tool.LINE);
		this.add(line);
		line.addActionListener(new ToolButtonHandler(drawingPanel));
		drawingPanel.addButton(line);
		
		ToolButton move = new ToolButton(new ImageIcon(MauseIcon.move.getIcon()), Tool.MOVE);
		this.add(move);
		move.addActionListener(new ToolButtonHandler(drawingPanel));
		drawingPanel.addButton(move);
		
		ToolButton resize = new ToolButton(new ImageIcon(MauseIcon.resize.getIcon()), Tool.RESIZE);
		this.add(resize);
		resize.addActionListener(new ToolButtonHandler(drawingPanel));
		drawingPanel.addButton(resize);
		
		ToolButton delete = new ToolButton(new ImageIcon(MauseIcon.delete.getIcon()), Tool.DELETE);
		this.add(delete);
		delete.addActionListener(new ToolButtonHandler(drawingPanel));
		drawingPanel.addButton(delete);
		
		JTextField sliderText = new JTextField("003");
		JSlider slider = new JSlider();
		slider.setValue(3);
		this.add(slider);
		this.add(sliderText);
		slider.addChangeListener(new SliderHandler(drawingPanel, slider, sliderText));
		
		for(int color : colors){
			ColorButton button = new ColorButton(new Color(color));
			this.add(button);
			button.addActionListener(new ColorButtonHandler(drawingPanel));
		}
		
		JButton changeStrokeColor = new JButton("Stroke");
		JButton changeFillColor = new JButton("Fill");
		changeStrokeColor.addActionListener(new DrawButtonHandler(drawingPanel));
		changeFillColor.addActionListener(new DrawButtonHandler(drawingPanel));
		changeStrokeColor.setBackground(selectedColor);
		changeStrokeColor.setForeground(Color.BLACK);
		drawingPanel.setFill(changeFillColor);
		drawingPanel.setStroke(changeStrokeColor);
		this.add(changeStrokeColor);
		this.add(changeFillColor);
		
		JCheckBox fill = new JCheckBox("fill (on/off)");
		drawingPanel.setFillCheck(fill);
		add(fill);
	}
}
