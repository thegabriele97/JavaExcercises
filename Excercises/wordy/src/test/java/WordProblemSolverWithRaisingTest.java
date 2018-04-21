
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class WordProblemSolverWithRaisingTest {

    WordProblemSolver word = new WordProblemSolver();

    @Test
    public void testSingle() {
        assertEquals(32, word.solve("What is 2 raised to the 5th power?"));
    }

    @Test
    public void testSingle2() {
        assertEquals(8, word.solve("What is 2 raised to the 3th power?"));
    }

    @Test
    public void testMultiple() {
        assertEquals(64, word.solve("What is 2 raised to the 3th power raised to the 2th power?"));
    }
}