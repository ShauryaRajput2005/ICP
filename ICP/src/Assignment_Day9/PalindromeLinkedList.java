package Assignment_Day9;

public class PalindromeLinkedList {
	static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode prev = null, curr = slow;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        ListNode left = head, right = prev;
        while (right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);
        System.out.println(isPalindrome(head1)); // true

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println(isPalindrome(head2)); // false
    }
}