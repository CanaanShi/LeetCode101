/*
 * @lc app=leetcode id=69 lang=java
 *
 * [69] Sqrt(x)
 *
 * https://leetcode.com/problems/sqrtx/description/
 *
 * algorithms
 * Easy (35.81%)
 * Likes:    2881
 * Dislikes: 2836
 * Total Accepted:    882.9K
 * Total Submissions: 2.4M
 * Testcase Example:  '4'
 *
 * Given a non-negative integer x, compute and return the square root of x.
 * 
 * Since the return type is an integer, the decimal digits are truncated, and
 * only the integer part of the result is returned.
 * 
 * Note: You are not allowed to use any built-in exponent function or operator,
 * such as pow(x, 0.5) or x ** 0.5.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: x = 4
 * Output: 2
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: x = 8
 * Output: 2
 * Explanation: The square root of 8 is 2.82842..., and since the decimal part
 * is truncated, 2 is returned.
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= x <= 2^31 - 1
 * 
 * 
 */

class Solution {
  public int mySqrt(int x) {
    // Parameter verification
    if (x < 2) {
      return x;
    }
    // declare left border
    int left = 1;
    // declare right border
    int right = (x >> 1) + 1;
    // terminate condition: left > right
    while (left <= right) {
      int mid = left + ((right + left) >> 1);
      // Preventing type overflow
      if (mid == x / mid) {
        return mid;
        // mid * mid < x, shift left border to the right
      } else if (mid < x / mid) {
        left = mid + 1;
        // mid * mid > x , shift right border to the left
      } else if (mid > x / mid) {
        right = mid - 1;
      }
    }
    // left > right,
    return right;
  }
}
