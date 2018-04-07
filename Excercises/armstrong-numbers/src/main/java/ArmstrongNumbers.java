import java.util.Arrays;

/**
 * 
 * @author Gabriele La Greca
 * 
 */

public class ArmstrongNumbers {
	private static final byte DEFAULT_ARRAY_DIM = 4;

	public boolean isArmstrongNumber(int numberToCheck) {
		int[] digits = nextDivision(numberToCheck, 10);
		int sum = 0;

		for (int i = 0; i < digits.length; i++) {
			sum += (int)Math.pow(digits[i], digits.length);
		}

		return (sum == numberToCheck);
	}

	private static int[] nextDivision(int op1, int op2) {
		int currentDimension = DEFAULT_ARRAY_DIM;
		int index = 0;
		int[] digits = new int[currentDimension];

		while (op1 >= op2) {
			
			int x = op1 / op2;
			digits[index++] = op1 % op2;
			op1 = x;

			if (op1 >= op2 && index >= currentDimension) {
				currentDimension *= 2;
				digits = Arrays.copyOf(digits, currentDimension);
			}
		}

		digits[index++] = op1;
		return reverseArray(Arrays.copyOf(digits, index));
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
}