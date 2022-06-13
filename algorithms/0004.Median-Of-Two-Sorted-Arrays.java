/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 *
 * https://leetcode.com/problems/median-of-two-sorted-arrays/description/
 *
 * algorithms
 * Hard (32.15%)
 * Likes:    17031
 * Dislikes: 2053
 * Total Accepted:    1.4M
 * Total Submissions: 4.1M
 * Testcase Example:  '[1,3]\n[2]'
 *
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return
 * the median of the two sorted arrays.
 * 
 * The overall run time complexity should be O(log (m+n)).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: nums1 = [1,3], nums2 = [2]
 * Output: 2.00000
 * Explanation: merged array = [1,2,3] and median is 2.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: nums1 = [1,2], nums2 = [3,4]
 * Output: 2.50000
 * Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -10^6 <= nums1[i], nums2[i] <= 10^6
 * 
 * 
 */

// @lc code=start
class Solution {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    // define an array whose length is the sum of the lengths of the two parameters arrays
    int[] union = new int[nums1.length + nums2.length];
    // fill the new array in ascending order
    for (int i = 0, p1 = 0, p2 = 0; i < union.length; i++) {
      // if p2 equal the length of (nums2 or nums1[p1] less than nums2[p2] && p1 not
      // equal to the length of the nums1)
      if (p2 == nums2.length || (p1 != nums1.length && nums1[p1] < nums2[p2])) {
        union[i] = nums1[p1];
        p1++;
      } else {
        union[i] = nums2[p2];
        p2++;
      }
    }
    // mid = (start + end ) / 2
    int mid = union.length - 1 >> 1;
    double res;
    // if the length of the new array is an add number, the result is the mid
    // else, the result is (union[mid] + union[mid +1]) / 2
    if (union.length % 2 == 1) {
      res = union[mid];
    } else {
      res = (double) (union[mid] + union[mid + 1]) / 2;
    }
    return res;
  }
}
// @lc code=end
