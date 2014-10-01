package colorclicker;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

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
	}
}
