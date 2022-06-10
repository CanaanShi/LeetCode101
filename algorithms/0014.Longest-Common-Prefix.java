/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 *
 * https://leetcode.com/problems/longest-common-prefix/description/
 *
 * algorithms
 * Easy (37.04%)
 * Likes:    8309
 * Dislikes: 3056
 * Total Accepted:    1.6M
 * Total Submissions: 4.1M
 * Testcase Example:  '["flower","flow","flight"]'
 *
 * Write a function to find the longest common prefix string amongst an array
 * of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lower-case English letters.
 * 
 * 
 */

// @lc code=start
class Solution {
  public String longestCommonPrefix(String[] strs) {
    // get prefix from first string
    for (int index = 0; index < strs[0].length(); index++) {
      char c = strs[0].charAt(index);
      // compare prefix with the other string
      for (int i = 1; i < strs.length; i++) {
        if (index == strs[i].length() || c != strs[i].charAt(index)) {
          return strs[0].substring(0, index);
        }
      }
    }
    return strs[0];
  }
}
// @lc code=end
