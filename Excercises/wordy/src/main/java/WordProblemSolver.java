import java.util.function.BinaryOperator;

/**
 * 
 * @author Gabriele la Greca
 * 
 */
public class WordProblemSolver {
    private static final String ERR_ARG = "I'm sorry, I don't understand the question!";
    
    private static final String FIRST_PART = "What is ";
    private static final String POST_PH = " by";
    private static final String PH_RAISED = "raised to the";
    private static final String PH_THPOWER = "th power";
    
    private static final String OP_ADD = "plus";
    private static final String OP_SUB = "minus";
    private static final String OP_MUL = "multiplied";
    private static final String OP_DIV = "divided";
    private static final String OP_CUBE = "cubed";

    public int solve(String question) {
        
        String[] ph = question.substring(FIRST_PART.length(), question.length() - 1)
                              .replaceAll(OP_MUL + POST_PH, OP_MUL)
                              .replaceAll(OP_DIV + POST_PH, OP_DIV)
                              .replaceAll(PH_RAISED, OP_CUBE)
                              .replaceAll(PH_THPOWER, "")
                              .split(" ");

        try {
            return parse(ph, 0);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERR_ARG);
        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException(ERR_ARG);
        }
    }

    private int parse(String[] ph, int start) {

        if (start + 1 >= ph.length) {
            return Integer.parseInt(ph[start + 0]);
        }

        int a = Integer.parseInt(ph[start + 0]);
        BinaryOperator<Integer> op = getOp(ph[start + 1]);
        int b = Integer.parseInt(ph[start + 2]);

        ph[start + 2] = String.valueOf(op.apply(a, b));
        return parse(ph, start + 2);
    }

    private BinaryOperator<Integer> getOp(String toParse) {
        BinaryOperator<Integer>  op = (a, b) -> null;

        if (toParse.equals(OP_ADD)) {
            op = (a, b) -> a + b;
        } else if (toParse.equals(OP_SUB)) {
            op = (a, b) -> a - b;
        } else if (toParse.equals(OP_MUL)) {
            op = (a, b) -> a * b;
        } else if (toParse.equals(OP_DIV)) {
            op = (a, b) -> a / b;
        } else if (toParse.equals(OP_CUBE)) {
            op = (a, b) -> (int)Math.pow(a, b);
        }

        return op;
    }
}