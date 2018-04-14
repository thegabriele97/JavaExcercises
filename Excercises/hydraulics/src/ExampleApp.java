import hydraulic.*;

public class ExampleApp {

	public static void main(String args[]) {
		
		HSystem s = new HSystem();
	
		// 1) the elements of the system are defined and added
		Source src = new Source("Src");
		s.addElement(src);
		Tap r = new Tap("R");
		s.addElement(r);
		Split t = new Split("T");
		Sink sink1 = new Sink("sink A");
		s.addElement(sink1);
		Sink sink2 = new Sink("sink B");
		s.addElement(sink2);
		
		// 2) elements are then connected
		src.connect(r);
		r.connect(t);
		t.connect(sink1,0);
		t.connect(sink2,1);
		
		// 3) simulation parameters are then defined
		src.setFlow(20);
		r.setOpen(true);
		
		// 4) simulation starts
		s.simulate();
		
		// 5) print the system layout
		System.out.println(s.layout());
	}
}
