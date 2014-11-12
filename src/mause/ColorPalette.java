package mause;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;

public class ColorPalette implements ActionListener {
	
	private JDialog dialog;
	private DrawingPanel dp;
	private JColorChooser colorChooser;
	
	public ColorPalette(DrawingPanel dp){
		this.dp = dp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "Color palette"){
			dialog = new JDialog();
			dialog.setAlwaysOnTop(true);
			dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
			colorChooser = new JColorChooser();
			dialog.add(colorChooser);
			JButton button = new JButton("OK");
			dialog.add(button);
			button.addActionListener(this);
			dialog.pack();
			dialog.setVisible(true);
		}
		if(e.getActionCommand() == "OK"){
			dialog.dispose();
			dp.setColor(colorChooser.getColor());
		}
	}

	
	
	
}
