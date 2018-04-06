import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Gabriele la Greca
 * 
 */

public class Allergies {
    private static final List<Allergen> SORTED_ALLERGEN_LIST = getSortedAllergenArray();
    private static final int TOTAL_SUM = calcSumOfAllAllergen();
    private List<Allergen> allergies;

    public Allergies(int score) {

        allergies = new ArrayList<Allergen>();

        while (score > TOTAL_SUM) {
            score -= TOTAL_SUM + 1;
        }
        
        for (Allergen a : SORTED_ALLERGEN_LIST) {
            
            if (score <= 0) {
                break;
            }
            
            if (a.getScore() <= score) {
                score -= a.getScore();
                allergies.add(a);
            }
        }

        allergies.sort(new AllergenComparator(AllergenComparator.SORT_NORMAL));
    }

    private static List<Allergen> getSortedAllergenArray() {
        List<Allergen> list = new ArrayList<Allergen>();            
        
        for (Allergen a : Allergen.values()) {
            list.add(a);
        }

        list.sort(new AllergenComparator(AllergenComparator.SORT_REVERSE));
        return list;
    }

    private static int calcSumOfAllAllergen() {
        int sum = 0;
        
        for (Allergen a : Allergen.values()) {
            sum += a.getScore();
        }

        return sum;
    }

    public boolean isAllergicTo(Allergen a) {
        return allergies.contains(a);
    }

    public List<Allergen> getList() {
        return allergies;
    }
}