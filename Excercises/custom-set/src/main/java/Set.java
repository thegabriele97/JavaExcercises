
/**
 * 
 * Set Interface
 * 
 * @author Gabriele La Greca
 * 
 */

public interface Set<T> extends Iterable<T> {

    /* generics methods for items management */
    boolean add(T item);
    int size();

    /* boolean methods for checks */
    boolean isEmpty();
    boolean contains(T item);
    boolean isSubset(Set<T> set);
    boolean isDisjoint(Set<T> set);
    
    @Override
    boolean equals(Object obj);

    /* generics methods for Set Operations */
    Set<T> getDifference(Set<T> otherSet);
    Set<T> getUnion(Set<T> otherSet);
    Set<T> getIntersection(Set<T> otherSet);
}