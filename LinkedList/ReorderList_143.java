package LinkedList;

public class ReorderList_143 {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode slow = head, fast = head;

        // 1. Find the middle
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // 2. Split the list into two halves
        ListNode curr2 = slow.next;
        slow.next = null;

        // 3. Reverse the second half
        ListNode prev = null;

        while (curr2 != null) {
            ListNode next = curr2.next;
            curr2.next = prev;
            prev = curr2;
            curr2 = next;
        }

        // prev is now the head of the reversed second half

        // 4. Merge the two halves alternately
        ListNode curr1 = head;
        curr2 = prev;

        while (curr2 != null) {
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;

            curr1.next = curr2;
            curr2.next = next1;

            curr1 = next1;
            curr2 = next2;
        }
    }
}
