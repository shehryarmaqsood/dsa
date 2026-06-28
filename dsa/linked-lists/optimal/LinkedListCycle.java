// Time Complexity: O(n) - fast pointer traverses at most 2n steps
// Space Complexity: O(1) - only two pointers, no extra data structure

package linked.lists.optimal;

/**
 * LeetCode 141 - Linked List Cycle
 * Optimal Approach (Floyd's Cycle Detection - Fast/Slow Pointers):
 * - slow moves 1 step at a time; fast moves 2 steps.
 * - If there's a cycle, fast will eventually lap slow and they'll meet.
 * - If no cycle, fast reaches null first.
 * - O(1) space vs O(n) for HashSet approach.
 */
public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head; // moves 1 step
        ListNode fast = head; // moves 2 steps

        while (fast != null && fast.next != null) {
            slow = slow.next;       // advance slow by 1
            fast = fast.next.next;  // advance fast by 2

            if (slow == fast) {
                return true; // they met — cycle exists
            }
        }
        return false; // fast reached end — no cycle
    }

    public static void main(String[] args) {
        LinkedListCycle sol = new LinkedListCycle();

        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n2; // cycle
        System.out.println(sol.hasCycle(n1)); // Expected: true

        ListNode m1 = new ListNode(1);
        m1.next = new ListNode(2);
        System.out.println(sol.hasCycle(m1)); // Expected: false
    }
}
