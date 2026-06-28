// Time Complexity: O(n^2) - try every pair of lines
// Space Complexity: O(1) - only tracking max area

package two.pointers.brute;

/**
 * LeetCode 11 - Container With Most Water
 * Brute Force Approach:
 * - Try every pair of vertical lines (i, j).
 * - Area = min(height[i], height[j]) * (j - i).
 * - Track the maximum area found.
 */
public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int maxWater = 0;

        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int water = Math.min(height[i], height[j]) * (j - i); // bounded by shorter line
                maxWater = Math.max(maxWater, water);
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
