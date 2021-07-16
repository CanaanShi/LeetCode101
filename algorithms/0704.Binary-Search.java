/*
 * @lc app=leetcode id=704 lang=java
 *
 * [704] Binary Search
 *
 * https://leetcode.com/problems/binary-search/description/
 *
 * algorithms
 * Easy (54.80%)
 * Likes:    1571
 * Dislikes: 68
 * Total Accepted:    292.3K
 * Total Submissions: 533.4K
 * Testcase Example:  '[-1,0,3,5,9,12]\n9'
 *
 * Given an array of integers nums which is sorted in ascending order, and an
 * integer target, write a function to search target in nums. If target exists,
 * then return its index. Otherwise, return -1.
 *
 * You must write an algorithm with O(log n) runtime complexity.
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [-1,0,3,5,9,12], target = 9
 * Output: 4
 * Explanation: 9 exists in nums and its index is 4
 *
 *
 * Example 2:
 *
 *
 * Input: nums = [-1,0,3,5,9,12], target = 2
 * Output: -1
 * Explanation: 2 does not exist in nums so return -1
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= nums.length <= 10^4
 * -10^4 < nums[i], target < 10^4
 * All the integers in nums are unique.
 * nums is sorted in ascending order.
 *
 *
 */

class Solution {
  /**
   * @param nums is the object of array
   * @param target   is the element to be searched
   */
  int binarySearch(int[] nums, int target) {
    // the range between left and right is [left,right]
    int left = 0;
    int right = nums.length - 1;

    /*
     * if while(left < right){
     * 		loop body;
     * }
     * return nums[left] == target?left:-1;
     */

    // when left == tight + 1,foramat is [right+1,right],
    // the while(left <= right) stop, and return -1.
    while (left <= right) {
      int mid = left + (right - left) / 2;
      if (nums[mid] == target) {
        return mid;
      } else if (nums[mid] < target) {
        // search range becomes to [mid+1,right]
        left = mid + 1;
      } else if (nums[mid] > target) {
        // search range becomes to [left,mid-1]
        right = mid - 1;
      }
    }
    return - 1;
  }
}
