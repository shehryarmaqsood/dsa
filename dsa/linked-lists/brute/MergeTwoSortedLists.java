// Time Complexity: O(n log n) - collecting all values then sorting
// Space Complexity: O(n) - extra list to hold all values

package linked.lists.brute;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * LeetCode 21 - Merge Two Sorted Lists
 * Brute Force Approach:
 * - Collect all values from both lists into one ArrayList.
 * - Sort the combined list.
 * - Build a new linked list from sorted values.
 */
public class MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> values = new ArrayList<>();

        // Collect all values from both lists
        while (list1 != null) { values.add(list1.val); list1 = list1.next; }
        while (list2 != null) { values.add(list2.val); list2 = list2.next; }

        Collections.sort(values); // sort combined values

        // Build new linked list
        ListNode dummy = new ListNode(0);
        ListNode curr  = dummy;
        for (int v : values) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    static void print(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) { sb.append(head.val).append("->"); head = head.next; }
        System.out.println(sb.append("null"));
    }

    public static void main(String[] args) {
        MergeTwoSortedLists sol = new MergeTwoSortedLists();
        ListNode l1 = new ListNode(1); l1.next = new ListNode(2); l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1); l2.next = new ListNode(3); l2.next.next = new ListNode(4);
        print(sol.mergeTwoLists(l1, l2)); // Expected: 1->1->2->3->4->4->null
    }
}
