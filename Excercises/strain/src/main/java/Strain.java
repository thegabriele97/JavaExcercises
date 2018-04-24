
import java.util.List;
import java.util.ArrayList;

/**
 * 
 * @author Gabriele La Greca
 * 
 */
public class Strain {

    /**
     * Only an example to show how to use Stream & Lambda expressions
     */
    public static <T> List<T> keepWithStream(List<T> source, Predicate<T> p) {
        List<T> finalList = new ArrayList<>();

        source.stream()
              .filter(p::apply)
              .forEach(finalList::add);

        return finalList;
    }

    public static <T> List<T> keep(List<T> source, Predicate<T> p) {
        List<T> finalList = new ArrayList<>();

        for (T e : source) {
            if (p.apply(e)) {
                finalList.add(e);
            }
        }

        return finalList;
    }

    public static <T> List<T> discard(List<T> source, Predicate<T> p) {
        return keep(source, Predicate.negPredicate(p));
    }
}