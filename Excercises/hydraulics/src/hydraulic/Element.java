package hydraulic;

/**
 * Represents the generic abstract element of an hydraulics system.
 * It is the base class for all elements.
 *
 * Any element can be connect to a downstream element
 * using the method {@link #connect(Element) connect()}.
 */
public abstract class Element {
	private String name;
	private Element output;

	/**
	 * Constructor
	 * @param name the name of the element
	 */
	public Element(String name){
		this.name = name;
	}

	/**
	 * getter method
	 * @return the name of the element
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * Connects this element to a given element.
	 * The given element will be connected downstream of this element
	 * @param elem the element that will be placed downstream
	 */
	public void connect(Element elem){

		if (elem instanceof Source) {
			throw new IllegalArgumentException();
		}

		output = elem;
	}
	
	/**
	 * Retrieves the element connected downstream of this
	 * @return downstream element
	 */
	public Element getOutput(){
		return output;
	}

	/**
	 * Receives an input flow and compute
	 * a possible output flow to use during simulation
	 * @param inputFLow flow in input
	 * @return output flow given inputFLow
	 */
	public abstract double computeOutputFlow(double inputFlow);

	/**
	 * Receives an input flow and simulate the flow
	 * through this element.
	 * 
	 * <b>DON'T use it on a Split object. Use instead an overloaded
	 * method:</b> See {@link #simulate() String simulate(double, int)}.
	 * 
	 * @return String containing infos about this element 
	 * and input/output flow simulation
	 * @throws UnsupportedOperationException if used on a Sink or Split object
	 */
	public abstract String simulate(double inputFlow);

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder()
			.append('[')
			.append(getName())
			.append(']')
			.append(getClass().getSimpleName());

		return string.toString();
	}
	
}
