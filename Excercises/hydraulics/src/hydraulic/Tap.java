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

	public boolean isOpen() {
		return isOpen;
	}

	@Override
	public double computeOutputFlow(double inputFlow) {
		return ((isOpen()) ? inputFlow : 0);
	}

	@Override
	public String simulate(double inputFlow) {
		StringBuilder string = new StringBuilder()
				.append(this)
				.append('\n')
				.append("Input flow: ")
				.append(inputFlow)
				.append('\n')
				.append("Output flow: ")
				.append(computeOutputFlow(inputFlow))
			  	.append('\n');

		return string.toString();
	}
}
