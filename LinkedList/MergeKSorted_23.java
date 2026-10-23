package LinkedList;

import java.util.PriorityQueue;

public class MergeKSorted_23 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val-b.val);
        for(ListNode listHead: lists) {
            if(listHead!=null) pq.offer(listHead);
        }

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();

            temp.next = node;
            temp = temp.next;

            if (node.next != null) {
                pq.offer(node.next);
            }
        }

        return dummy.next;
    }
}
