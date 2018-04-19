
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * @author Gabriele La Greca
 * 
 */

public class Flattener {

    @SuppressWarnings("unchecked")
    public<T> List<T> flatten(List<T> list) {
        List<T> flattedList = new LinkedList<>();
        
        for (T e : list) {
            if (e != null) {
                if (e instanceof List) {
                    flattedList.addAll(flatten((List<T>)e));
                    continue;
                }

                flattedList.add(e);
            }
        }

        return flattedList;
    }
}