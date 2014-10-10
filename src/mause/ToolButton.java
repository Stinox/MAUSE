package mause;

import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.JButton;

public class ToolButton extends JButton{
	private Tool tool;

	public ToolButton() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ToolButton(Action a) {
		super(a);
		// TODO Auto-generated constructor stub
	}

	public ToolButton(Icon icon) {
		super(icon);
		// TODO Auto-generated constructor stub
	}

	public ToolButton(String text, Icon icon, Tool tool) {
		super(text, icon);
		// TODO Auto-generated constructor stub
	}

	public ToolButton(String text, Tool tool) {
		super(text);
		this.tool = tool;
		// TODO Auto-generated constructor stub
	}

	public Tool getTool() {
		return tool;
	}

	public void setTool(Tool tool) {
		this.tool = tool;
	}

	
}
