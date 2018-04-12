package org.gabriele97;

import org.gabriele97.display.Display;
import org.gabriele97.display.Drawable;
import org.gabriele97.display.Position;
import org.gabriele97.display.figures.*;

public class Esempio {
	
	public static void main(String[] args) {
		try {
			
			
			Display s = new Display(10,30);
			
			//polimorfismo
			Point p1 = new Point('*');
			Drawable p2 = new Point('+');
			
			
			
			s.draw(p1, new Position(6, 24));
			s.draw(p2, new Position(7, 7));
			

			Drawable r1 = new Rectangle(3, 3, 'x');
			Rectangle r2 = new Rectangle(3, 2, 'a');
			Rectangle r3 = new Rectangle(4, 4, 'o');

			Triangle t1 = new Triangle(3, 3, 'm');
			
			s.draw(r1, new Position(3, 8));
			s.draw(r2, new Position(0, 0));
			s.draw(r3, new Position(1, 1));

			s.draw(t1, new Position(1, 22));
			
			
			Drawable q1 = new Square(3, 'X');
			s.draw(q1, new Position(2, 9));
			
			
			DrawingsSet gruppo1 = new DrawingsSet();
			
			
			gruppo1.add(r2,0,0);
			gruppo1.add(r3, 1, 1);
			
			s.draw(gruppo1, new Position(5, 3));
			
			s.display();
			
			//secondo schermo pi� piccolo 
			
			Display s2 = new Display(7,7);
			s2.draw(p1, new Position(1, 1));
			s2.draw(r2, new Position(2,2));
			
			s2.display();

		
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
