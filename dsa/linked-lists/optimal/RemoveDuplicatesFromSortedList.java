// Time Complexity: O(n) - single pass, in-place
// Space Complexity: O(1) - only pointer manipulation, no extra list

package linked.lists.optimal;

/**
 * LeetCode 83 - Remove Duplicates from Sorted List
 * Optimal Approach (Single Pointer In-Place):
 * - Use one pointer; when current.val == current.next.val, skip the next node.
 * - Modifies the original list without extra space.
 */
public class RemoveDuplicatesFromSortedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;

        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next; // skip the duplicate node
            } else {
                curr = curr.next; // move forward only if no duplicate
            }
        }
        return head;
    }

    static void print(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) { sb.append(head.val).append("->"); head = head.next; }
        System.out.println(sb.append("null"));
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList sol = new RemoveDuplicatesFromSortedList();

        ListNode h1 = new ListNode(1);
        h1.next = new ListNode(1); h1.next.next = new ListNode(2);
        print(sol.deleteDuplicates(h1)); // Expected: 1->2->null

        ListNode h2 = new ListNode(1);
        h2.next = new ListNode(1); h2.next.next = new ListNode(2);
        h2.next.next.next = new ListNode(3); h2.next.next.next.next = new ListNode(3);
        print(sol.deleteDuplicates(h2)); // Expected: 1->2->3->null
    }
}
