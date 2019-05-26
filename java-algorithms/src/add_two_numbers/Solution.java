package add_two_numbers;

public class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        int carry = 0;
        while (!(l1 == null && l2 == null)) {
            int num1 = (l1 == null) ? 0 : l1.val;
            int num2 = (l2 == null) ? 0 : l2.val;
            int summation = num1 + num2 + carry;
            sum.val = (summation > 9) ? summation - 10 : summation;
            carry = (summation > 9) ? 1 : 0;
            ListNode next = new ListNode(0);
            sum.next = next;
            sum = next;
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        return sum;
    }

    public static void printList(ListNode listNode) {
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }
}
