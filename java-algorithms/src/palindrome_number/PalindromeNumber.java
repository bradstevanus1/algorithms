package palindrome_number;

import java.util.ArrayList;
import java.util.Collections;

@SuppressWarnings("Duplicates")
public class Solution {

    public boolean isPalindrome(int x) {
        ArrayList<Integer> reversedDigits = toDigitList(x);

        // Can only be a palindrome if number is negative,
        // so remove the signed bit to compare arrys
        if (reversedDigits.get(0) == 0) {
            reversedDigits.remove(0);
        } else {
            return false;
        }
        ArrayList<Integer> originalDigits = new ArrayList<>(reversedDigits);
        Collections.reverse(reversedDigits);
        return (originalDigits.equals(reversedDigits));
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


}
