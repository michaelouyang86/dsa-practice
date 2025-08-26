package dsa.problems.list;

// https://leetcode.com/problems/linked-list-cycle
public class LinkedListCycle {
    public boolean hasCycleOriginal(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode pointer1 = head;
        ListNode pointer2 = head.next;
        while (!pointer1.equals(pointer2)) {
            pointer1 = pointer1.next;
            if (pointer2.next == null || pointer2.next.next == null) {
                return false;
            }
            pointer2 = pointer2.next.next;
        }
        return true;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedListCycle linkedListCycle = new LinkedListCycle();
        ListNode head = new ListNode(1);
        System.out.println(head.val);
        System.out.println(linkedListCycle.hasCycle(head));
    }
}
