package mause;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

public class Window extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Window() {
		// ’super ’ calls a function inherited from the parent class ( JFrame )
		for(LookAndFeelInfo info: UIManager.getInstalledLookAndFeels()){
			System.out.println(info.getName());
			if("Nimbus".equals(info.getName())){
				try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
			}
		}
		super.setTitle(" Mega Awesome Uber Super Epic - MAUSE ");
		super.setSize(new Dimension(1600, 900));
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
