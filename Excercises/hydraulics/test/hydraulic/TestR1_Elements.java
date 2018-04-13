package hydraulic;


import org.junit.Test;

import hydraulic.*;
import junit.framework.TestCase;


public class TestR1_Elements extends TestCase {
	
	@Test
	public void testEmptySystem(){
		HSystem s = new HSystem();
		
		Element[] elements = s.getElements();
		
		assertEquals(0,elements.length);
		
	}

	@Test
	public void testGetElements () {
		HSystem s = new HSystem();
		Element el1 = new Source("Test");		
		Element el2 = new Source("Test 1");		
		
		
		try {
			s.addElement(el1);
			s.addElement(el2);
		} catch (Exception e) {

		}
		
		
		Element[] elements = s.getElements();
		
		//assertEquals(2,elementi.length);
		
		assertTrue(el1==elements[0]
					|| el1==elements[1]);
	}
}
