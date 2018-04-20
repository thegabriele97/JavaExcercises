package hydraulic;

import java.util.Iterator;

/**
 * Represents a split element, a.k.a. T element
 * 
 * During the simulation each downstream element will
 * receive a stream that is half the input stream of the split.
 */

public class Split extends Element implements Iterable<Element> {
	private Element[] outputs;

	/**
	 * Constructor
	 * @param name
	 */
	public Split(String name) {
		super(name);
		
		outputs = new Element[2];
	}

	/**
	 * Not supported for Split Class.
	 * Use getOutputs() instead.
	 */
	@Override
	public Element getOutput() {
		throw new UnsupportedOperationException();
	}
    
	/**
	 * returns the downstream elements
	 * @return array containing the two downstream element
	 */
    public Element[] getOutputs(){
        return outputs;
	}
	
	/**
	 * Not supported for Split Class.
	 * Use connect(Element, int) instead.
	 */
	@Override
	public void connect(Element elem) {
		throw new UnsupportedOperationException();
	}

	public void connect(Element elem, int noutput){
		
		if (noutput >= 2 || noutput < 0) {
			throw new IllegalArgumentException("Invalid output.");
		}

		outputs[noutput] = elem;
	}

	@Override
	public double computeOutputFlow(double inputFlow) {
		return (inputFlow / 2);
	}

	@Override
	public String simulate(double inputFlow) {
		throw new UnsupportedOperationException();
	}

	public String simulate(double inputFlow, int noutput) {
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

	@Override
	public Iterator<Element> iterator() {
		
		return new Iterator<Element>() {
			int cursor = 0;

			@Override
			public boolean hasNext() {
				return (cursor < outputs.length);
			}

			@Override
			public Element next() {
				return outputs[cursor++];
			}
		};
	}
}
