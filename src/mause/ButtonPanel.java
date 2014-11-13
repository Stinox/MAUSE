package mause;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
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
		
		ToolButton rect = new ToolButton(new ImageIcon(MauseIcon.rect.getIcon()), Tool.RECTANGLE);
		this.add(rect);
		rect.addActionListener(new ToolButtonHandler(drawingPanel));
		drawingPanel.addButton(rect);
		rect.setBackground(selectedColor);
		rect.setToolTipText("Click on the canvas and drag your mouse to draw a rectangle.");
		
		ToolButton ellipse = new ToolButton(new ImageIcon(MauseIcon.ellipse.getIcon()), Tool.ELLIPSE);
		this.add(ellipse);
		ellipse.addActionListener(new ToolButtonHandler(drawingPanel));
		drawingPanel.addButton(ellipse);
		ellipse.setToolTipText("Click on the canvas and drag your mouse to draw a circle.");
		
		ToolButton line = new ToolButton(new ImageIcon(MauseIcon.line.getIcon()), Tool.LINE);
		this.add(line);
		line.addActionListener(new ToolButtonHandler(drawingPanel));
		drawingPanel.addButton(line);
		line.setToolTipText("Click on the canvas and drag your mouse to draw a line.");
		
		ToolButton image = new ToolButton(new ImageIcon(MauseIcon.image.getIcon()), Tool.IMAGE);
		this.add(image);
		image.addActionListener(new ToolButtonHandler(drawingPanel));
		drawingPanel.addButton(image);
		image.setToolTipText("Click on the canvas and select a loccaly stored image in the dialogbox (most formats are supported).");
		
		ToolButton text = new ToolButton(new ImageIcon(MauseIcon.text.getIcon()), Tool.TEXT);
		this.add(text);
		text.addActionListener(new ToolButtonHandler(drawingPanel));
		drawingPanel.addButton(text);
		text.setToolTipText("Click on the canvas and enter your text and font size in the dialog box.");
		
		ToolButton move = new ToolButton(new ImageIcon(MauseIcon.move.getIcon()), Tool.MOVE);
		this.add(move);
		move.addActionListener(new ToolButtonHandler(drawingPanel));
		drawingPanel.addButton(move);
		move.setToolTipText("Use this tool to select and move shapes on the canvas.");
		
		ToolButton resize = new ToolButton(new ImageIcon(MauseIcon.resize.getIcon()), Tool.RESIZE);
		this.add(resize);
		resize.addActionListener(new ToolButtonHandler(drawingPanel));
		drawingPanel.addButton(resize);
		resize.setToolTipText("Use this tool to select shapes and resize them.");
		
		ToolButton foreground = new ToolButton(new ImageIcon(MauseIcon.foreground.getIcon()), Tool.FOREGROUND);
		this.add(foreground);
		foreground.addActionListener(new ToolButtonHandler(drawingPanel));
		foreground.setToolTipText("Click this button to move the selected shape to the foreground");
		
		ToolButton background = new ToolButton(new ImageIcon(MauseIcon.background.getIcon()), Tool.BACKGROUND);
		this.add(background);
		background.addActionListener(new ToolButtonHandler(drawingPanel));
		background.setToolTipText("Click this button to move the selected shape to the background");
		
		ToolButton delete = new ToolButton(new ImageIcon(MauseIcon.delete.getIcon()), Tool.DELETE);
		this.add(delete);
		delete.addActionListener(new ToolButtonHandler(drawingPanel));
		drawingPanel.addButton(delete);
		delete.setToolTipText("Select this tool and click on a shape to remove that shape.");
		
		ToolButton edit = new ToolButton(new ImageIcon(MauseIcon.edit.getIcon()), Tool.EDIT);
		this.add(edit);
		edit.addActionListener(new ToolButtonHandler(drawingPanel));
		drawingPanel.addButton(edit);
		edit.setToolTipText("Sets the selected shape to the current settings (color, thickness).");
		
		
		JTextField sliderText = new JTextField("003");
		JSlider slider = new JSlider();
		slider.setToolTipText("Adjust the line thickness of rectangles, circles and lines");
		slider.setValue(3);
		this.add(slider);
		this.add(sliderText);
		slider.addChangeListener(new SliderHandler(drawingPanel, slider, sliderText));
		
		for(int color : colors){
			ColorButton button = new ColorButton(new Color(color));
			this.add(button);
			button.addActionListener(new ColorButtonHandler(drawingPanel));
		}
		
		JButton colorPalette = new JButton("Color palette");
		this.add(colorPalette);
		colorPalette.addActionListener(new ColorPalette(drawingPanel));
		
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
		changeStrokeColor.setToolTipText("Select a color while this mode is selected to adjust the stroke color of rectangles, circles and lines");
		changeFillColor.setToolTipText("Select a color while this mode is selected to adjust the fill color of rectangles, circles and lines");
		
	}
}
