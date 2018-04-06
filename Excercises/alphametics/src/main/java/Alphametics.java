import java.util.Arrays;
import java.util.LinkedHashMap;

/**
 * 
 * @author Gabriele La Greca
 * 
 */

public class Alphametics {
    private String[] puzzle;
    private LinkedHashMap<Character, Integer> corrispondence;

    public Alphametics(String puzzle) {
        int i = 0;

        this.corrispondence = new LinkedHashMap<>();
        this.puzzle = puzzle.replace('+', ' ')
                            .replaceAll("==", " ")
                            .toUpperCase()
                            .split("   ");

        for (Character ch : puzzle.toCharArray()) {
            if (Character.isLetter(ch) && !corrispondence.containsKey(ch)) {
                corrispondence.put(ch, i++);
            }
        }
    }

    public LinkedHashMap<Character, Integer> solve() throws UnsolvablePuzzleException {
        int[] sol = new int[10];
        boolean[] taked = new boolean[sol.length];
        LinkedHashMap<Character, Integer> finalSolution;

        Arrays.fill(sol, -1);

        if (!genSol(0, sol, taked)) {
            throw new UnsolvablePuzzleException(true);
        }

        finalSolution = new LinkedHashMap<>();

        for (Character ch : corrispondence.keySet()) {
            finalSolution.put(ch, sol[corrispondence.get(ch)]);
        }

        return finalSolution;
    }

    private boolean genSol(int pos, int[] sol, boolean[] taked) {
        
        if (pos >= corrispondence.size()) {
            return checkSol(sol);
        }

        for (int i = 0; i < 10; i++) {

            if (!taked[i]) {

                if (i == 0 && !checkIfFirstCharacterIsNotZero(pos)) {
                    continue;
                }

                taked[i] = true;
                sol[pos] = i;

                if (genSol(pos + 1, sol, taked)) {
                    return true;
                }

                //backtrack
                sol[pos] = -1;
                taked[i] = false;
            }
        }

        return false;
    }

    private boolean checkIfFirstCharacterIsNotZero(int actualPos) {

        for (String x : puzzle) {
            if (actualPos == corrispondence.get(x.charAt(0))) {
                return false;
            }
        }

        return true;
    }

    private boolean checkSol(int[] sol) {
        int sum = 0;

        for (int i = 0; i < puzzle.length - 1; i++) {
            sum += stringToIntegerValue(puzzle[i], sol);
        }

        sum -= stringToIntegerValue(puzzle[puzzle.length - 1], sol);
        return (sum == 0);
    }

    private int stringToIntegerValue(String x, int[] possibleValues) {
        int value = 0;

        for (char ch : x.toCharArray()) {
            int index = corrispondence.get(ch);

            value = (value * 10) + possibleValues[index];
        }

        return value;
    }
}