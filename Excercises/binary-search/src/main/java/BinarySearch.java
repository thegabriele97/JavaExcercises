import java.util.List;;

/**
 * 
 * @author Gabriele La Greca
 * 
 */

public class BinarySearch<T extends Comparable<T>> {
    private List<T> collection;

    public BinarySearch(List<T> collection) {
        this.collection = collection;
    }

    //TODO:
    public int indexOf(T key) {

        if (collection.isEmpty()) {
            return -1;
        }

        return BinarySearchRecursive(key, 0, collection.size() - 1);
    }

    private int BinarySearchRecursive(T key, int l, int r) {

        int k = (l + r) / 2;
        int cmp = key.compareTo(collection.get(k));

        if (cmp == 0) {
            return k;
        } else {
            if (r <= l) {
                return -1;
            } else if (cmp < 0) {
                return BinarySearchRecursive(key, l, --k);
            } else if (cmp > 0) {
                return BinarySearchRecursive(key, ++k, r);
            }
        }

        return -1;
    }
}