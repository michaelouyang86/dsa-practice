package dsa.problems.list;

// https://leetcode.com/problems/reverse-linked-list-ii
public class ReverseLinkedListII {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode previous = null;
        ListNode current = head;

        for (int i = 0; i < left - 1; i++) {
            previous = current;
            current = current.next;
        }

        ListNode reversePrevious = previous;
        ListNode reverseEnd = current;
        ListNode reverseNext = current.next;
        for (int i = 0; i < right - left; i++) {
            previous = current;
            current = reverseNext;
            reverseNext = current.next;
            current.next = previous;
        }

        if (reversePrevious != null) {
            reversePrevious.next = current;
        }
        reverseEnd.next = reverseNext;

        return left == 1 ? current : head;
    }

    private class ListNode {
        ListNode next;
    }
}
