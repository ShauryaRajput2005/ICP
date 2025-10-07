package Assignment_Day9;

public class ReorderList {
	  static class ListNode {
	        int val;
	        ListNode next;
	        ListNode(int val) { this.val = val; }
	    }

	    public static void reorderList(ListNode head) {
	        if (head == null || head.next == null) return;

	        ListNode slow = head, fast = head;
	        while (fast != null && fast.next != null) {
	            slow = slow.next;
	            fast = fast.next.next;
	        }

	        ListNode prev = null, curr = slow.next;
	        slow.next = null;
	        while (curr != null) {
	            ListNode next = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = next;
	        }

	        ListNode first = head, second = prev;
	        while (second != null) {
	            ListNode t1 = first.next;
	            ListNode t2 = second.next;
	            first.next = second;
	            second.next = t1;
	            first = t1;
	            second = t2;
	        }
	    }

	    public static void printList(ListNode head) {
	        while (head != null) {
	            System.out.print(head.val + " ");
	            head = head.next;
	        }
	        System.out.println();
	    }

	    public static void main(String[] args) {
	        ListNode head = new ListNode(1);
	        head.next = new ListNode(2);
	        head.next.next = new ListNode(3);
	        head.next.next.next = new ListNode(4);
	        head.next.next.next.next = new ListNode(5);

	        reorderList(head);
	        printList(head); // Output: 1 5 2 4 3
	    }
	}

