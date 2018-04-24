
/**
 * I made this in order to use less possible standard
 * classes and interfaces given by Java Library.
 * 
 * @see java.function.Predicate
 */
public interface Predicate<T> {

    /**
     * Functional method
     */
    public boolean apply(T e);
    
    /**
     * 
     */
    public static <T> Predicate<T> negPredicate(Predicate<T> toNeg) {
        return (e -> !toNeg.apply(e));
    }
}