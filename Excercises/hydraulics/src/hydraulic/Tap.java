package hydraulic;

/**
 * Represents a tap that can interrupt the flow.
 * 
 * The status of the tap is defined by the method
 * {@link #setOpen(boolean) setOpen()}.
 */

public class Tap extends Element {
	private boolean isOpen;

	public Tap(String name) {
		super(name);
		
		isOpen = false;
	}
	
	public void setOpen(boolean open){
		isOpen = open;
	}

	protected boolean isOpen() {
		return isOpen;
	}
}
