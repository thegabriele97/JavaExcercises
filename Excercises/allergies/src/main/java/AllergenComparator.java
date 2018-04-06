import java.util.Comparator;

public final class AllergenComparator implements Comparator<Allergen> {
    public static final byte SORT_NORMAL = -1;
    public static final byte SORT_REVERSE = 1;
    
    private byte sorting;

    public AllergenComparator(byte sorting) {

        if (sorting != SORT_NORMAL && sorting != SORT_REVERSE) {
            throw new IllegalArgumentException();
        }

        this.sorting = sorting;
    }

    @Override
    public int compare(Allergen o1, Allergen o2) {
        
        return sorting * (o2.getScore() - o1.getScore());
    }
}