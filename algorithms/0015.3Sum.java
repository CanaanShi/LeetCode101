/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 *
 * https://leetcode.com/problems/3sum/description/
 *
 * algorithms
 * Medium (28.88%)
 * Likes:    11856
 * Dislikes: 1160
 * Total Accepted:    1.4M
 * Total Submissions: 4.8M
 * Testcase Example:  '[-1,0,1,2,-1,-4]'
 *
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 *
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 * Input: nums = []
 * Output: []
 * Example 3:
 * Input: nums = [0]
 * Output: []
 *
 *
 * Constraints:
 *
 *
 * 0 <= nums.length <= 3000
 * -10^5 <= nums[i] <= 10^5
 *
 *
 */


class Solution {
  public List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> outputArr = new LinkedList();

    for (int i = 0; i < nums.length - 2; i++) {
      if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
        int low = i + 1;
        int high = nums.length - 1;
        int sum = 0 - nums[i];

        while (low < high) {
          if (nums[low] + nums[high] == sum) {
            outputArr.add(Arrays.asList(nums[i], nums[low], nums[high]));
            while (low < high && nums[low] == nums[low + 1]) {
              low++;
            }
            while (low < high && nums[high] == nums[high - 1]) {
              high--;
            }
            low++;
            high--;

          } else if (nums[low] + nums[high] > sum) {
            high--;
          } else {
            low++;
          }
        }
      }
    }
    return outputArr;
  }
}