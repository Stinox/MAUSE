package mause;

import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

public class MyText extends MyShape implements ActionListener {

	private String text =  "sample text";
	private JDialog dialog;
	private JTextField textField;
	
	public MyText(int x1, int y1){
		super.x1 = x1;
		super.y1 = y1;
		
		dialog = new JDialog();
		dialog.setTitle("Enter your text");
		textField = new JTextField();
		dialog.add(textField);
		JButton button = new JButton("OK");
		dialog.add(button);
		button.addActionListener(this);
		dialog.setSize(new Dimension(500,100));
		dialog.setAlwaysOnTop(true);
		dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
		super.width = 200;
		super.height = 50;
		super.x2 = x1 + width;
		super.y2 = y1 + height;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		text = textField.getText();
		dialog.dispose();
	}
	
	public void draw(Graphics2D g2d){
		g2d.drawString(text, x1, y1);
	}
}
