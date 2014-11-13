package mause;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;

public class KeyAction extends AbstractAction{

	private static final long serialVersionUID = 1L;
	long timer;
	boolean running = false;
	
    public KeyAction(String actionCommand) {
        putValue(ACTION_COMMAND_KEY, actionCommand);
     }
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand() == "timer"){
			timer();
		}
		
	}
	
	private void timer() {
		if(!running){
			timer = System.currentTimeMillis();
			running = true;
			System.out.println("Started timer");
		}
		else if(running){
			running = false;
			System.out.println("Stopped timer: " + (double) (System.currentTimeMillis() - timer) / 1000.0 + " seconds");
		}
	}


}
