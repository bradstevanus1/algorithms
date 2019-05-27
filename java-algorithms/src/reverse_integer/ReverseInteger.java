package reverse_integer;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("Duplicates")
public class ReverseInteger {

    public int reverse(int x) {
        ArrayList<Integer> digits = toDigitList(x);
        Collections.reverse(digits);
        return toNumber(digits);
    }

    private ArrayList<Integer> toDigitList(int x) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        String number = String.valueOf(x);

        // Add a sign value at the beginning of the array list,
        // where 1 indicates negative and 0 indicates positive
        if (number.charAt(0) == '-') {
            arrayList.add(1);
            number = removeChar(number, '-');
        } else {
            arrayList.add(0);
        }
        for (int i = 0; i < number.length(); i++) {
            int digit = Character.getNumericValue(number.charAt(i));
            arrayList.add(digit);
        }
        return arrayList;
    }

    private String removeChar(String number, char c) {
        StringBuilder result = new StringBuilder(number.length() - 1);
        for (int i = 0; i < number.length(); i++) {
            char character = number.charAt(i);
            if (character == c) continue;
            result.append(character);
        }
        return result.toString();
    }

    private int toNumber(ArrayList<Integer> digits) {
        int number = 0;
        for (int i = 0; i < digits.size() - 1; i++) {
            int power = (digits.size() - 2) - i;  // Account for the signed bit at end of list
            long baseTenValue = (long) digits.get(i) * (long) Math.pow(10, power);
            if (baseTenValue > Integer.MAX_VALUE || baseTenValue < Integer.MIN_VALUE) return 0;
            if (number + baseTenValue < 0) return 0;
            number += (int) baseTenValue;
        }
        if (digits.get(digits.size() - 1) == 1) {
            number = -number;
        }
        return number;
    }

}
