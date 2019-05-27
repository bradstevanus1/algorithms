package keyboard;

public class Keyboard {

    public int solution(String S1, String S2) {
        int newIndex = 0;
        int lastIndex = 0;
        int time = 0;
        for (char letter : S2.toCharArray()) {
            newIndex = getIndex(S1, letter);
            time += Math.abs(newIndex - lastIndex);
            lastIndex = newIndex;
        }
        return time;
    }

    private int getIndex(String s, char letter) {
        for (int i = 0; i <s.length(); i++) {
            if (s.charAt(i) == letter) {
                return i;
            }
        }
        return -1;
    }

}
