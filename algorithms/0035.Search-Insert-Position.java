/*
 * @lc app=leetcode id=35 lang=java
 *
 * [35] Search Insert Position
 *
 * https://leetcode.com/problems/search-insert-position/description/
 *
 * algorithms
 * Easy (42.76%)
 * Likes:    8170
 * Dislikes: 418
 * Total Accepted:    1.5M
 * Total Submissions: 3.5M
 * Testcase Example:  '[1,3,5,6]\n5'
 *
 * Given a sorted array of distinct integers and a target value, return the
 * index if the target is found. If not, return the index where it would be if
 * it were inserted in order.
 * 
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums = [1,3,5,6], target = 5
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums = [1,3,5,6], target = 2
 * Output: 1
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: nums = [1,3,5,6], target = 7
 * Output: 4
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums contains distinct values sorted in ascending order.
 * -10^4 <= target <= 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
  public int searchInsert(int[] nums, int target) {
    // check param before execution
    if (nums == null || nums.length == 0) {
      return 0;
    }
    // check for specific case
    if(nums[nums.length - 1] < target){
      return nums.length;
    }
    // init left and right bounary
    int left = 0;
    int right = nums.length -1 ;
    // when left >= right, end the loop
    while(left < right){
      int mid = left + (right - left >> 1);
      // if the element equals target, return index directly
      if (nums[mid] == target) {
        return mid;
        // if element less than target, move the left border to mid + 1
      } else if (nums[mid] < target) {
        left = mid +1;
        // element greater than target, move the right border to the mid
      } else {
        right = mid;
      }
    }
    // in this case,left border move step by 1. when loop finished, left equals right
    return left;
  }

  public int searchInsert1(int[] nums, int target) {
    return searchInsertRecursion(nums, target, 0, nums.length);
  }

  private int searchInsertRecursion(int[] nums, int target, int left, int right) {
    // left border greater than or equal to right boundary, return left boundary
    // take the move the bounary: left
    if (left >= right) {
      return left;
    }
    // init the mid of the search range
    int mid = left + (right - left >> 1);
    // get the target index
    if (nums[mid] == target) {
      return mid;
    } else if (nums[mid] < target) {
      // tail recursion.
      // move the left boundary to the mid + 1
      return searchInsertRecursion(nums, target, mid + 1, right);
    } else {
      // move the right boundary to the mid
      return searchInsertRecursion(nums, target, left, mid);
    }
  }
}
// @lc code=end
