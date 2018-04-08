
/**
 * 
 * @author Gabriele La Greca
 * 
 */

public class Bob {

    public String hey(String phrase) {
        BobAnswers answer = BobAnswers.IDK;
        
        if (isAQuestion(phrase)) {
            
            if (isYelling(phrase)) {
                answer = BobAnswers.YELL_A_QUESTION;
            } else {
                answer = BobAnswers.QUESTION;
            }

        } else if (isYelling(phrase)) {
            answer = BobAnswers.YELL;
        } else if (phrase.length() == 0 || (countLetters(phrase) == 0 && countStrangerThings(phrase) != 0 && countDigits(phrase) == 0)) {
            answer = BobAnswers.ADDRESS_HIM;
        }

        return answer.getAnswer();
    }

    private boolean isYelling(String phrase) {

        for (char ch : phrase.toCharArray()) {
            if (Character.isLetter(ch) && !Character.isUpperCase(ch)) {
                return false;
            }
        }

        return (countLetters(phrase) > 0);
    }

    private boolean isAQuestion(String phrase) {

        for (int i = phrase.length() - 1; i >= 0; i--) {
            
            if (Character.isLetter(phrase.charAt(i))) {
                break;
            }

            if (phrase.charAt(i) == '?') {
                return true;
            }
        }

        return false;
    }

    private int countLetters(String phrase) {
        int countLetters = 0;

        for (char ch : phrase.toCharArray()) {
            countLetters += (Character.isLetter(ch)) ? 1 : 0;
        }

        return countLetters;
    }

    private int countDigits(String phrase) {
        int countLetters = 0;

        for (char ch : phrase.toCharArray()) {
            countLetters += (Character.isDigit(ch)) ? 1 : 0;
        }

        return countLetters;
    }

    private int countStrangerThings(String phrase) {
        int countLetters = 0;

        for (char ch : phrase.toCharArray()) {
            countLetters += (Character.isSpace(ch)) ? 1 : 0;
        }

        return countLetters;
    }
}