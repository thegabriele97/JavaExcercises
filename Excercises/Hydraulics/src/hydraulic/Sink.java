package hydraulic;

/**
 * Represents the sink, i.e. the terminal element of a system
 *
 */
public class Sink extends Element {

	/**
	 * Constructor
	 * @param name
	 */
	public Sink(String name) {
		super(name);
	}
	
	/**
	 * Not supported on this class
	 */
	@Override
	public void connect(Element elem) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Not supported on this class
	 */
	@Override
	public Element getOutput() {
		throw new UnsupportedOperationException();
	}
	
}
