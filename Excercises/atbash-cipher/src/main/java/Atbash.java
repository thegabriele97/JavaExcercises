
/**
 * 
 * @author Gabriele La Greca
 * 
 */

public class Atbash {
    private static final byte numberOfLetters = 'z' - 'a';
    private static final int rightOffset = (2 * 'a') + numberOfLetters;

    public String encode(String word) {
        return encodeDecode(word, true);
    }

    public String decode(String word) {
        return encodeDecode(word, false);
    }

    private String encodeDecode(String word, boolean encoding) {
        StringBuilder newWord = new StringBuilder(word.length());
        int count = 0;
        
        for (char ch : word.toCharArray()) {

            if (!Character.isLetter(ch) && !Character.isDigit(ch)) {
                continue;
            }

            if (encoding && count >= 5) {
                newWord.append(' ');
                count = 0;
            }

            ch = Character.toLowerCase(ch);
            if (Character.isLetter(ch)) {
                ch = (char)(rightOffset - ch);
            }

            newWord.append(ch);
            count += (encoding) ? 1 : 0;
        }

        return newWord.toString();
    }
}