package mause;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class ButtonPanel extends JPanel {
	
	private Color selectedColor = new Color(0,162,255);

	public ButtonPanel(DrawingPanel drawingPanel) {
		super();
		// Add a button to the panel . The argument to the JButton constructor
		// will become the text on the button .
		ToolButton rect = new ToolButton("Rectangle", Tool.RECTANGLE);
		this.add(rect);
		rect.addActionListener(new ButtonHandler(drawingPanel));
		drawingPanel.addButton(rect);
		rect.setBackground(selectedColor);
		rect.setIcon(new ImageIcon(MauseIcon.rect.getIcon()));
		
		ToolButton ellipse = new ToolButton("Ellipse", Tool.ELLIPSE);
		this.add(ellipse);
		ellipse.addActionListener(new ButtonHandler(drawingPanel));
		drawingPanel.addButton(ellipse);
		
		ToolButton line = new ToolButton("Line", Tool.LINE);
		this.add(line);
		line.addActionListener(new ButtonHandler(drawingPanel));
		drawingPanel.addButton(line);
		
		ToolButton move = new ToolButton("Move", Tool.MOVE);
		this.add(move);
		move.addActionListener(new ButtonHandler(drawingPanel));
		drawingPanel.addButton(move);
		
		ToolButton resize = new ToolButton("Resize", Tool.RESIZE);
		this.add(resize);
		resize.addActionListener(new ButtonHandler(drawingPanel));
		drawingPanel.addButton(resize);
		
		ToolButton delete = new ToolButton("Delete", Tool.DELETE);
		this.add(delete);
		delete.addActionListener(new ButtonHandler(drawingPanel));
		drawingPanel.addButton(delete);
		
		JTextField sliderText = new JTextField("003");
		JSlider slider = new JSlider();
		slider.setValue(3);
		this.add(slider);
		this.add(sliderText);
		slider.addChangeListener(new SliderHandler(drawingPanel, slider, sliderText));
		
		JButton black = new JButton("Black");
		black.setBackground(Color.BLACK);
		this.add(black);
		black.addActionListener(new ButtonHandler(drawingPanel));
		JButton red = new JButton("Red");
		red.setBackground(Color.RED);
		this.add(red);
		red.addActionListener(new ButtonHandler(drawingPanel));
		JButton blue = new JButton("Blue");
		blue.setBackground(Color.BLUE);
		this.add(blue);
		blue.addActionListener(new ButtonHandler(drawingPanel));
		
		JButton changeStrokeColor = new JButton("Stroke");
		JButton changeFillColor = new JButton("Fill");
		changeStrokeColor.addActionListener(new ButtonHandler(drawingPanel));
		changeFillColor.addActionListener(new ButtonHandler(drawingPanel));
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
