package mause;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;

public class ButtonPanel extends JPanel {

	public ButtonPanel(DrawingPanel drawingPanel) {
		super();
		// Add a button to the panel . The argument to the JButton constructor
		// will become the text on the button .
		JButton rect = new JButton("Rectangle");
		this.add(rect);
		rect.addActionListener(new ButtonHandler(drawingPanel));
		JButton ellipse = new JButton("Ellipse");
		this.add(ellipse);
		ellipse.addActionListener(new ButtonHandler(drawingPanel));
		JButton line = new JButton("Line");
		this.add(line);
		line.addActionListener(new ButtonHandler(drawingPanel));
		JButton delete = new JButton("Delete");
		this.add(delete);
		delete.addActionListener(new ButtonHandler(drawingPanel));
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
	}
}
