
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