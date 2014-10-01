package colorclicker;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends JFrame {
	public Window() {
		// �super � calls a function inherited from the parent class ( JFrame )
		super();
		super.setTitle(" Callbacks ");
		super.setSize(new Dimension(1024, 768));
		// Make sure the window appears in the middle of your screen
		super.setLocationRelativeTo(null);
		// Determines what should happen when the frame is closed
		super.setDefaultCloseOperation(EXIT_ON_CLOSE);
		// Chooses a certain layout type for the elements in this frame
		super.getContentPane().setLayout(new BorderLayout());

		DrawingPanel rp = new DrawingPanel();
		ButtonPanel bp = new ButtonPanel(rp);
		// Places the RectPanel in the center of the frame
		super.getContentPane().add(rp, BorderLayout.CENTER);
		// Places the ButtonPanel in the top of the frame
		super.getContentPane().add(bp, BorderLayout.NORTH);
		

		// Set the window to visible ! Yup ... This is necessary
		super.setVisible(true);
	}
}
