/*
 * @lc app=leetcode id=33 lang=java
 *
 * [33] Search in Rotated Sorted Array
 *
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 *
 * algorithms
 * Medium (36.53%)
 * Likes:    11235
 * Dislikes: 788
 * Total Accepted:    1.2M
 * Total Submissions: 3.3M
 * Testcase Example:  '[4,5,6,7,0,1,2]\n0'
 *
 * There is an integer array nums sorted in ascending order (with distinct
 * values).
 * 
 * Prior to being passed to your function, nums is possibly rotated at an
 * unknown pivot index k (1 <= k < nums.length) such that the resulting array
 * is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
 * (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3
 * and become [4,5,6,7,0,1,2].
 * 
 * Given the array nums after the possible rotation and an integer target,
 * return the index of target if it is in nums, or -1 if it is not in nums.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 * Example 3:
 * Input: nums = [1], target = 0
 * Output: -1
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 5000
 * -10^4 <= nums[i] <= 10^4
 * All values of nums are unique.
 * nums is an ascending array that is possibly rotated.
 * -10^4 <= target <= 10^4
 * 
 * 
 */

class Solution {
  public int search(int[] nums, int target) {
    // parameter verification
    if (nums == null || nums.length == 0) {
      return -1;
    }
    // declare left boarder
    int left = 0;
    // declare right boarder
    int right = nums.length - 1;
    // determinate condition: left > right
    while (left <= right) {
      int mid = left + ((right - left) >> 1);
      if (nums[mid] == target) {
        return mid;
      }
      // Confirm whether the nums[mid] is in the first quadrant or the third quadrant
      // first quadrant
      if (nums[left] <= nums[mid]) {
        // the left side is ordered
        if (nums[left] <= target && target < nums[mid]) {
          // shift right to the left
          right = mid - 1;
        } else if (nums[left] > target || target > nums[mid]) {
          left = mid + 1;
        }
        // third quadrant
      } else if (nums[left] > nums[mid]) {
        // the right side is ordered
        if (nums[mid] < target && target <= nums[right]) {
          // shift left to the right
          left = mid + 1;
        } else if (nums[mid] > target || target > nums[right]) {
          right = mid - 1;
        }
      }
    }
    return -1;
  }
}
