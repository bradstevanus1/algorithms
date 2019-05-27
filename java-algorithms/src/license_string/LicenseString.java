package license_string;

public class LicenseString {

    public String solution(String S, int K) {
        // Removes all dashes currently in the string.
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            char character = S.charAt(i);
            if (character == '-') continue;
            string.append(character);
        }
        // Builds a new string with hyphens between characters,
        // separating string into substrings of size K.
        StringBuilder output = new StringBuilder(string.length());
        for (int i = 0; i < string.length(); i++) {
            char character = string.charAt(i);
            if (i != 0 && i % K == 0) {
                output.append('-');
                output.append(character);
            } else {
                output.append(character);
            }
        }

        // Turn StringBuilder into string and set to upper case
        String result = output.toString().toUpperCase();

        if (output.length() > K) {
            char character = output.charAt(output.length() - 1);
            int count = 0;
            while (character != '-') {
                count++;
                character = output.charAt(output.length() - (count + 1));
            }
            while (count < 3) {
                result = moveHypensLeft(result);
                count++;
            }
        }

        return result;
    }

    private static String moveHypensLeft(String string) {
        StringBuilder result = new StringBuilder(string.length());
        for (int i = 0; i < string.length(); i++) {
            if (i + 1 < string.length() && string.charAt(i + 1) == '-') {
                result.append('-');
                result.append(string.charAt(i));
                i++;
            } else {
                result.append(string.charAt(i));
            }
        }
        return result.toString();
    }

}
