import add_two_numbers.AddTwoNumbers;
import add_two_numbers.ListNode;
import two_sum.TwoSum;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        AddTwoNumbers solution = new AddTwoNumbers();
        int[] values = {2, 4, 6, 8};
        ListNode firstNode = AddTwoNumbers.create(values);
        AddTwoNumbers.printList(firstNode);
    }

}
