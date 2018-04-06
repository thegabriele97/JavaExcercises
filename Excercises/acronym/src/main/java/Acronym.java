
/**
 * 
 * @author Gabriele la Greca
 * 
 */

public class Acronym {
    private String acronym;

    public Acronym(String phrase) {
        StringBuilder buffer = new StringBuilder();

        for (int i = 0; i < phrase.length(); i++) {
            if (Character.isLetter(phrase.charAt(i))) {
                if (i == 0 || !Character.isLetter(phrase.charAt(i - 1))) {
                    buffer.append(Character.toUpperCase(phrase.charAt(i)));
                }
            }
        }

        acronym = buffer.toString();
    }

    public String get() {
        return acronym;
    }
}