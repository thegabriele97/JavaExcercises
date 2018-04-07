import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Gabriele La Greca
 * 
 */

public class Anagram {
    private String word;

    public Anagram(String word) {
        this.word = word;
    }

    public List<String> match(List<String> possibleMatches) {
        List<String> finalSolution = new ArrayList<>();
        String oldWord = word;

        word = word.replace(word.charAt(0), Character.toLowerCase(word.charAt(0)));
        generateAnagrams(0, new char[word.length()], new boolean[word.length()], finalSolution, possibleMatches);
        word = oldWord;

        return finalSolution;
    }

    private void generateAnagrams(int pos, char[] sol, boolean[] taked, List<String> solution, List<String> possibleMatches) {

        if (pos >= word.length()) {

            String matching = searchForAMatch(new String(sol), possibleMatches);
            if (matching != null) {
                solution.add(matching);
            }

            return;
        }

        for (int i = 0; i < word.length(); i++) {
            if (!taked[i]) {
                taked[i] = true;
                sol[pos] = word.charAt(i);

                generateAnagrams(pos + 1, sol, taked, solution, possibleMatches);

                taked[i] = false;
            }
        }
    }

    private String searchForAMatch(String anagram, List<String> possibleMatches) {

        for (String possibleMatch : possibleMatches) {
            if (anagram.equalsIgnoreCase(possibleMatch) && anagram.substring(1).equals(possibleMatch.substring(1))) {
                return possibleMatch;
            }
        }

        return null;
    }
}