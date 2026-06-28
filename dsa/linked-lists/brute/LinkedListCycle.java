// Time Complexity: O(n) - visit each node once
// Space Complexity: O(n) - storing visited nodes in a HashSet

package linked.lists.brute;

import java.util.HashSet;

/**
 * LeetCode 141 - Linked List Cycle
 * Brute Force Approach:
 * - Store every visited node in a HashSet.
 * - If we encounter a node already in the set, there's a cycle.
 */
public class LinkedListCycle {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public boolean hasCycle(ListNode head) {
        HashSet<ListNode> visited = new HashSet<>();

        ListNode curr = head;
        while (curr != null) {
            if (visited.contains(curr)) {
                return true; // seen this node before — cycle detected
            }
            visited.add(curr);
            curr = curr.next;
        }
        return false; // reached end of list — no cycle
    }

    public static void main(String[] args) {
        LinkedListCycle sol = new LinkedListCycle();

        // Cycle: 3->2->0->-4->back to 2
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2; n2.next = n3; n3.next = n4; n4.next = n2; // cycle
        System.out.println(sol.hasCycle(n1)); // Expected: true

        // No cycle: 1->2
        ListNode m1 = new ListNode(1);
        m1.next = new ListNode(2);
        System.out.println(sol.hasCycle(m1)); // Expected: false
    }
}
