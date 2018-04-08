
/**
 * 
 * @author Gabriele La Greca
 * 
 */

public class Binary {
    private byte[] number;

    public Binary(String number) {
        int index = 0;
        
        this.number = new byte[number.length()];

        for (char ch : number.toCharArray()) {

            if (!Character.isDigit(ch) || Character.getNumericValue(ch) > 1) {
                this.number = new byte[1];
                this.number[0] = 0;
                break;
            }

            this.number[index++] = (byte)Character.getNumericValue(ch);
        }
    }

    public int getDecimal() {
        int value = 0;
        
        for (int i = 0; i < number.length; i++) {
            value += (number[i] == 1) ? (int)Math.pow(2, number.length - i - 1) : 0;
        }

        return value;
    }
}