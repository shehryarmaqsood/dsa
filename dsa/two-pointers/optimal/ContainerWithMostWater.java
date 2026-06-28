// Time Complexity: O(n) - single pass with two pointers
// Space Complexity: O(1) - only two pointers and max variable

package two.pointers.optimal;

/**
 * LeetCode 11 - Container With Most Water
 * Optimal Approach (Greedy Two Pointers):
 * - Start with pointers at both ends (maximum width).
 * - Always move the pointer pointing to the shorter line inward.
 * - Rationale: moving the taller side can never increase area; moving shorter might.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int left     = 0;
        int right    = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int h     = Math.min(height[left], height[right]); // water height
            int width = right - left;                           // current width
            maxWater  = Math.max(maxWater, h * width);

            // Move the pointer with the shorter line to try for larger area
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }

    public static void main(String[] args) {
        ContainerWithMostWater sol = new ContainerWithMostWater();
        System.out.println(sol.maxArea(new int[]{1,8,6,2,5,4,8,3,7})); // Expected: 49
        System.out.println(sol.maxArea(new int[]{1,1}));                 // Expected: 1
    }
}
