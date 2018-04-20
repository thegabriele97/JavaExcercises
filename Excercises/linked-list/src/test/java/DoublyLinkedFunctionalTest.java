
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.*;

public class DoublyLinkedFunctionalTest {

    List<Integer> list;

    @Before
    public void setup() {
        list = new DoublyLinkedList<>();

        list.push(2);
        list.push(3);
        list.push(5);
        list.push(4);
    }

    @Test
    public void testIterator() {
        
        Integer[] expected = {2, 3, 5, 4};
        Integer cursor = 0;

        for (Integer e : list) {
            assertEquals(e, expected[cursor++]);
        }
    }

    @Test
    public void testForEachWithLambda() {
        Integer[] expected = {2, 3, 5, 4};
        
        String str1 = new StringBuilder()
                        .append(Arrays.toString(expected))
                        .toString()
                        .replace('[', ' ')
                        .replace(']', ' ')
                        .replace(", ", " ");
        
        StringBuffer str2 = new StringBuffer(' ');

        list.forEach(i -> str2.append(i).append(' '));
        assertEquals(str1.trim(), str2.toString().trim());
    }
}