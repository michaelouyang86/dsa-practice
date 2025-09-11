package dsa.problems.list;

// https://leetcode.com/problems/sort-list
public class SortList {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode mid = getMid(head);
        ListNode right = mid.next;
        mid.next = null;
        ListNode leftSorted = sortList(head);
        ListNode rightSorted = sortList(right);
        return merge(leftSorted, rightSorted);
    }

    private ListNode getMid(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode merge(ListNode headA, ListNode headB) {
        ListNode preHead = new ListNode(0);
        ListNode node = preHead;
        while (headA != null && headB != null) {
            if (headA.val <= headB.val) {
                node.next = headA;
                headA = headA.next;
            } else {
                node.next = headB;
                headB = headB.next;
            }
            node = node.next;
        }
        node.next = headA != null ? headA : headB;
        return preHead.next;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }
}
