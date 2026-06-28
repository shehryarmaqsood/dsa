// Time Complexity: O(n) - single pass through the list
// Space Complexity: O(n) - storing values in a list then rebuilding

package linked.lists.brute;

import java.util.ArrayList;
import java.util.List;

/**
 * LeetCode 83 - Remove Duplicates from Sorted List
 * Brute Force Approach:
 * - Collect all unique values from the sorted list into an ArrayList.
 * - Rebuild the linked list from the unique values.
 */
public class RemoveDuplicatesFromSortedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode deleteDuplicates(ListNode head) {
        List<Integer> unique = new ArrayList<>();
        ListNode curr = head;

        // Collect only unique values (list is sorted, so duplicates are adjacent)
        while (curr != null) {
            if (unique.isEmpty() || unique.get(unique.size() - 1) != curr.val) {
                unique.add(curr.val);
            }
            curr = curr.next;
        }

        // Rebuild linked list from unique values
        ListNode dummy = new ListNode(0);
        ListNode builder = dummy;
        for (int val : unique) {
            builder.next = new ListNode(val);
            builder = builder.next;
        }
        return dummy.next;
    }

    static void print(ListNode head) {
        StringBuilder sb = new StringBuilder();
        while (head != null) { sb.append(head.val).append("->"); head = head.next; }
        System.out.println(sb.append("null"));
    }

    public static void main(String[] args) {
        RemoveDuplicatesFromSortedList sol = new RemoveDuplicatesFromSortedList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1); head.next.next = new ListNode(2);
        print(sol.deleteDuplicates(head)); // Expected: 1->2->null
    }
}
