package hydraulic;

/**
 * Represents a source of water, i.e. the initial element for the simulation.
 *
 * Lo status of the source is defined through the method
 * {@link #setFlow(double) setFlow()}.
 */
public class Source extends Element {
	private double exitFlow;

	public Source(String name) {
		super(name);

		exitFlow = 0;
	}

	public void setFlow(double flow){
		this.exitFlow = flow;
	}
	
	protected double getFlow() {
		return exitFlow;
	}

	@Override
	public double computeOutputFlow(double inputFlow) {
		return inputFlow;
	}

	@Override
	public String simulate(double inputFlow) {

		if (inputFlow != getFlow()) {
			throw new IllegalArgumentException();
		}

		StringBuilder string = new StringBuilder()
				.append(this)
				.append('\n')
				.append("Output flow: ")
				.append(computeOutputFlow(inputFlow))
				.append('\n');

		return string.toString();
	}
}
