package dsa.problems.list;

// https://leetcode.com/problems/reverse-linked-list
public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode previous = null;
        ListNode current = head;
        ListNode next = head.next;
        while (true) {
            current.next = previous;
            previous = current;
            current = next;
            if (current == null) {
                break;
            }
            next = next.next;
        }
        return previous;
    }

    private class ListNode {
        ListNode next;
    }
}
