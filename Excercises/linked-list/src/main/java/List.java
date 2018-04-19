
/**
 * 
 * @author Gabriele La Greca
 * 
 */

public interface List<T> extends Iterable<T> {

    void push(T e);
    T pop();
    void unshift(T e);
    T shift();
}