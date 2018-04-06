import java.util.Arrays;

/**
 * 
 * @author Gabriele La Greca
 * 
 */

public class BaseConverter {
    private static final String EXCEPTION_MSG_ERR_BASE = "Bases must be at least 2.";
    private static final String EXCEPTION_MSG_ERR_NEGATIVE = "Digits may not be negative.";
    private static final String EXCEPTION_MSG_ERR_DIG_LESS_BASE = "All digits must be strictly less than the base.";
    private static final int INITIAL_ARRAY_DIMENSION = 2;

    private int[] number;
    private int base;

    public BaseConverter(int base, int[] number) throws NullPointerException, IllegalArgumentException {
        
        checkArguments(base, number);

        this.base = base;
        this.number = number;
    }

    public int[] convertToBase(int base) throws IllegalArgumentException {
        int[] newNumber;
        
        if (base <= 1) {
            throw new IllegalArgumentException(EXCEPTION_MSG_ERR_BASE);
        }

        if (base == this.base) {
            newNumber = this.number;
        } else {
            newNumber = nextDivision(getDecimalNumber(), base);
        }
        
        return newNumber;
    }

    private int getDecimalNumber() {
        int decimal = 0;

        for (int i = 0; i < number.length; i++) {
            decimal += number[i] * powInt(base, number.length - i - 1);
        }

        return decimal;
    }

    private static void checkArguments(int base, int[] number) throws NullPointerException, IllegalArgumentException {
        
        if (number == null) {
            throw new NullPointerException();
        }

        if (base < 2) {
            throw new IllegalArgumentException(EXCEPTION_MSG_ERR_BASE);
        }

        for (int x : number) {
            if (x < 0) {
                throw new IllegalArgumentException(EXCEPTION_MSG_ERR_NEGATIVE);
            }

            if (x >= base) {
                throw new IllegalArgumentException(EXCEPTION_MSG_ERR_DIG_LESS_BASE);
            }
        }
    }

    private static int powInt(int a, int b) {
        return (int)Math.pow(a, b);
    }

    private static int[] reverseArray(int[] array) {
        int[] a = Arrays.copyOf(array, array.length);

        for (int i = 0; i < a.length / 2; i++) {
            int tmp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = tmp;
        }

        return a;
    }

    private static int[] nextDivision(int op1, int op2) {
        int[] resultOfDivision = new int[INITIAL_ARRAY_DIMENSION];
        int index = 0;
        int currDimension = INITIAL_ARRAY_DIMENSION;

        while (op1 >= op2) {
            int x = op1 / op2;
            resultOfDivision[index++] = op1 % op2;

            op1 = x;

            if (index >= currDimension) {
                currDimension *= 2;
                resultOfDivision = Arrays.copyOf(resultOfDivision, currDimension);
            }
        }

        resultOfDivision[index++] = op1;
        return reverseArray(Arrays.copyOf(resultOfDivision, index));
    }
}