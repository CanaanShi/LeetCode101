/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 *
 * https://leetcode.com/problems/container-with-most-water/description/
 *
 * algorithms
 * Medium (53.06%)
 * Likes:    17555
 * Dislikes: 968
 * Total Accepted:    1.5M
 * Total Submissions: 2.9M
 * Testcase Example:  '[1,8,6,2,5,4,8,3,7]'
 *
 * You are given an integer array height of length n. There are n vertical
 * lines drawn such that the two endpoints of the i^th line are (i, 0) and (i,
 * height[i]).
 * 
 * Find two lines that together with the x-axis form a container, such that the
 * container contains the most water.
 * 
 * Return the maximum amount of water a container can store.
 * 
 * Notice that you may not slant the container.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array
 * [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the
 * container can contain is 49.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: height = [1,1]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * n == height.length
 * 2 <= n <= 10^5
 * 0 <= height[i] <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
  public int maxArea(int[] height) {
    int ans = 0;
    int left = 0;
    int right = height.length - 1;
    while (left < right) {
      // calculate the area, container height depend on the lower side
      int area = (right - left) * Math.min(height[left], height[right]);
      // compare current area with history area
      ans = Math.max(ans, area);
      // if left lower than right, move the left pointer, else move the right
      if (height[left] < height[right]) {
        left++;
      } else {
        right--;
      }
    }
    return ans;
  }
}
// @lc code=end

