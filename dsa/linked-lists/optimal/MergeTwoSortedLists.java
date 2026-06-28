// Time Complexity: O(n + m) - single pass through both lists
// Space Complexity: O(1) - in-place pointer rewiring, no extra list

package linked.lists.optimal;

/**
 * LeetCode 21 - Merge Two Sorted Lists
 * Optimal Approach (Two-Pointer In-Place Merge):
 * - Use a dummy head node and a current pointer.
 * - At each step, pick the smaller node from list1 or list2 and advance that pointer.
 * - No sorting or extra array needed. O(1) extra space.
 */
public class MergeTwoSortedLists {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0); // sentinel node to simplify edge cases
        ListNode curr  = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                curr.next = list1; // pick from list1
                list1 = list1.next;
            } else {
                curr.next = list2; // pick from list2
                list2 = list2.next;
            }
            curr = curr.next; // advance current pointer
        }

        // Attach remaining nodes (at most one list is non-null here)
        curr.next = (list1 != null) ? list1 : list2;

        return dummy.next; // skip sentinel
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
