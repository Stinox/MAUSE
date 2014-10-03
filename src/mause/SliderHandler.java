package mause;

import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderHandler implements ChangeListener {
	
	private DrawingPanel drawingPanel;
	private JSlider slider;
	private JTextField sliderText;

	public SliderHandler(DrawingPanel drawingPanel, JSlider slider, JTextField sliderText) {
		super();
		this.drawingPanel = drawingPanel;
		this.slider = slider;
		this.sliderText = sliderText;
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		drawingPanel.setStrokeSize(slider.getValue());
		if(slider.getValue() < 10){
			sliderText.setText("00" + String.valueOf(slider.getValue()));
		} else if(slider.getValue() < 100){
			sliderText.setText("0" + String.valueOf(slider.getValue()));
		} else {
			sliderText.setText(String.valueOf(slider.getValue()));
		}
	}
}