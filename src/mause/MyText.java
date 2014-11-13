package mause;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
	private DrawingPanel dp;
	private int fontSize = 20;
	private JTextField fontSizeField;
	
	public MyText(int x1, int y1, DrawingPanel dp){
		super.x1 = x1;
		super.y1 = y1;
		this.dp = dp;
		
		dialog = new JDialog();
		dialog.setLayout(new BoxLayout(dialog.getContentPane(), BoxLayout.Y_AXIS));
		dialog.setTitle("Enter your text");
		
		textField = new JTextField("Your Text");
		textField.setPreferredSize(new Dimension(50, 12));
		dialog.add(textField);
		
		fontSizeField = new JTextField("12");
		fontSizeField.setPreferredSize(new Dimension(50, 12));
		dialog.add(fontSizeField);
		
		JButton button = new JButton("OK");
		dialog.add(button);
		
		button.addActionListener(this);
		dialog.setSize(new Dimension(500,125));
		dialog.setAlwaysOnTop(true);
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
		fontSize = Integer.parseInt(fontSizeField.getText());
		dialog.dispose();
		dp.repaint();
	}
	
	public void draw(Graphics2D g2d){
		width = text.length() * (fontSize/2);
		height = fontSize;
		startx = x1;
		starty = y1 - fontSize + 2;
		g2d.setStroke(new BasicStroke(strokeSize));
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
				RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.setFont(new Font("Arial", Font.PLAIN, fontSize));
		g2d.setColor(strokeColor);
		g2d.drawString(text, x1, y1);
	}
}
