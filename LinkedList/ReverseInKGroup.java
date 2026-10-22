package LinkedList;

public class ReverseInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (k == 1) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode prevGroupEnd = dummy;

        while (true) {
            ListNode groupSt = prevGroupEnd.next;
            ListNode groupEnd = groupSt;

            // Find the kth node
            for (int i = 1; i < k && groupEnd != null; i++) {
                groupEnd = groupEnd.next;
            }

            // Fewer than k nodes remain
            if (groupEnd == null) break;

            ListNode nextGroupSt = groupEnd.next;
            groupEnd.next = null;
            // Reverse the current group
            reverse(groupSt);

            // Connect the previous group to the reversed group
            prevGroupEnd.next = groupEnd;

            // The old start is now the group's tail
            groupSt.next = nextGroupSt;
            prevGroupEnd = groupSt;
        }

        return dummy.next;
    }

    public void reverse(ListNode head) {
        ListNode temp = head;
        ListNode prev = null;

        while(temp!=null) {
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
    }
}
