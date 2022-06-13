import java.util.Map;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 *
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/description/
 *
 * algorithms
 * Medium (31.91%)
 * Likes:    24736
 * Dislikes: 1082
 * Total Accepted:    3.4M
 * Total Submissions: 10.2M
 * Testcase Example:  '"abcabcbb"'
 *
 * Given a string s, find the length of the longest substring without repeating
 * characters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not
 * a substring.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= s.length <= 5 * 10^4
 * s consists of English letters, digits, symbols and spaces.
 * 
 * 
 */

// @lc code=start
class Solution {
  public int lengthOfLongestSubstring(String s) {
    // check param
    if (s == null || s.length() == 0)
      return 0;
    // init return result
    int res = 0;
    // the character of s : the index of character
    // last character position
    Map<Character, Integer> map = new HashMap<>();
    // declare the left boundary
    int left = 0;
    // travel the string
    for (int index = 0; index < s.length(); index++) {
      // get the character at the index position
      char c = s.charAt(index);
      // if containsKey, means repetition, the left bound of no repetition string need
      // be reset,
      // take the max value in the left boundary and the repetition index + 1
      // Add 1 to indicate no repetition from the last character position
      if (map.containsKey(c)) {
        left = Math.max(left, map.get(c) + 1);
      }
      // the res take the max value from old res and the (index + 1) - left
      res = Math.max(res, index + 1 - left);
      // put the character and the index of the character
      map.put(c, index);
    }
    return res;
  }
}
// @lc code=end
