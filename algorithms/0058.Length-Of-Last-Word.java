/*
 * @lc app=leetcode id=58 lang=java
 *
 * [58] Length of Last Word
 *
 * https://leetcode.com/problems/length-of-last-word/description/
 *
 * algorithms
 * Easy (33.67%)
 * Likes:    1136
 * Dislikes: 82
 * Total Accepted:    764.4K
 * Total Submissions: 2M
 * Testcase Example:  '"Hello World"'
 *
 * Given a string s consisting of words and spaces, return the length of the
 * last word in the string.
 * 
 * A word is a maximal substring consisting of non-space characters only.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "Hello World"
 * Output: 5
 * Explanation: The last word is "World" with length 5.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "   fly me   to   the moon  "
 * Output: 4
 * Explanation: The last word is "moon" with length 4.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "luffy is still joyboy"
 * Output: 6
 * Explanation: The last word is "joyboy" with length 6.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of only English letters and spaces ' '.
 * There will be at least one word in s.
 * 
 * 
 */

// @lc code=start
class Solution {
  public int lengthOfLastWord(String s) {
    // check before execution
    if (s == null || s.length() == 0) {
      return 0;
    }
    // declare the right boundary
    int right = s.length() - 1;
    // when the loop finished, the right will be the index which the last character of the last word
    while (right > -1 && s.charAt(right) == ' ')
      right--;
    int left = right;
    // when the loop finished, the left will be the index which the first character of the last word
    while (left > -1 && s.charAt(left) != ' ')
      left--;
    return right - left;
  }
}
// @lc code=end
