/*
 * @lc app=leetcode id=67 lang=java
 *
 * [67] Add Binary
 *
 * https://leetcode.com/problems/add-binary/description/
 *
 * algorithms
 * Easy (48.06%)
 * Likes:    5191
 * Dislikes: 565
 * Total Accepted:    858.1K
 * Total Submissions: 1.7M
 * Testcase Example:  '"11"\n"1"'
 *
 * Given two binary strings a and b, return their sum as a binary string.
 * 
 * 
 * Example 1:
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= a.length, b.length <= 10^4
 * a and b consist only of '0' or '1' characters.
 * Each string does not contain leading zeros except for the zero itself.
 * 
 * 
 */

// @lc code=start
class Solution {
  public String addBinary(String a, String b) {
    // check before execution
    if (b.length() == 0) {
      return a;
    }
    int carry = 0;
    StringBuilder result = new StringBuilder();
    // reverse plus two string
    for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
      int sum = carry;
      sum += i >= 0 ? a.charAt(i) - '0' : 0;
      sum += j >= 0 ? b.charAt(j) - '0' : 0;
      // if sum = 2,0 add 0, else add 1
      result.append(sum % 2);
      // carry the next
      carry = sum / 2;
    }
    // travel finished, but carry still have value
    if (carry == 1) {
      result.append(carry);
    }
    // reverse the result
    return result.reverse().toString();
  }
}
// @lc code=end
