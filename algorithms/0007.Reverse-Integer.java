/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 *
 * https://leetcode.com/problems/reverse-integer/description/
 *
 * algorithms
 * Easy (26.07%)
 * Likes:    5165
 * Dislikes: 7786
 * Total Accepted:    1.6M
 * Total Submissions: 6.3M
 * Testcase Example:  '123'
 *
 * Given a signed 32-bit integer x, return x with its digits reversed. If
 * reversing x causes the value to go outside the signed 32-bit integer range
 * [-2^31, 2^31 - 1], then return 0.
 *
 * Assume the environment does not allow you to store 64-bit integers (signed
 * or unsigned).
 *
 *
 * Example 1:
 * Input: x = 123
 * Output: 321
 * Example 2:
 * Input: x = -123
 * Output: -321
 * Example 3:
 * Input: x = 120
 * Output: 21
 * Example 4:
 * Input: x = 0
 * Output: 0
 *
 *
 * Constraints:
 *
 *
 * -2^31 <= x <= 2^31 - 1
 *
 *
 */

class Solution {
  public int reverse(int x) {
    int ans = 0;
    while (x != 0) {
      // take the last number
      int tail = x % 10;
      // if ans > MAX_VALUE / 10, there is still tail to add,so memory overflows
      // if ans == MAX_VALUE / 10, and tail > 7 ,it memory overflows, because 7 is digits of 2 ^ 31 - 1
      if (ans > Integer.MAX_VALUE / 10 || (ans == Integer.MAX_VALUE / 10 && tail > 7)) {
        return 0;
      }
      // if ans < Min_VALUE / 10, there is still tail to add, so memory overflows
      // if ans == MIN_VALUE / 10, and tail < -8,it memory overflows, because -8 is digits of -2 ^ 31
      if (ans < Integer.MIN_VALUE / 10 || (ans == Integer.MIN_VALUE / 10 && tail < - 8)) {
        return 0;
      }
      ans = ans * 10 + tail;
      x /= 10;
    }
    return ans;
  }


  public int reverse1(int x) {
    int result = 0;
    while (x != 0) {
      int tail = x % 10;
      int last = result * 10 + tail;
      if (last / 10 != result) {
        return 0;
      }
      result = last;
      x /= 10;
    }
    return result;
  }

  public int reverse2(int x) {
    int sign = x > 0 ? 1 : -1;
    x = x > 0 ? x : -x;
    int result = 0;
    while (x > 0) {
      if (Integer.MAX_VALUE / 10 < result || (Integer.MAX_VALUE - x % 10) < result * 10) {
        return 0;
      }
      result = result * 10 + x % 10;
      x /= 10;
    }
    return sign * result;
  }

  public int reverse3(int x){
    int result = 0;
    while (x != 0) {
      int tail;
      tail = x % 10;
      // greater than the max or less than the min will overflow
      if (Integer.MAX_VALUE / 10 < result || Integer.MIN_VALUE / 10 > result) {
        return 0;
      }
      result = result * 10 + tail;
      x /= 10;
    }
    return result;
  }
}