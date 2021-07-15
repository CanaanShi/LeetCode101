/*
 * @lc app=leetcode id=791 lang=java
 *
 * [791] Custom Sort String
 *
 * https://leetcode.com/problems/custom-sort-string/description/
 *
 * algorithms
 * Medium (67.01%)
 * Likes:    1369
 * Dislikes: 244
 * Total Accepted:    120K
 * Total Submissions: 179K
 * Testcase Example:  '"cba"\n"abcd"'
 *
 * order and str are strings composed of lowercase letters. In order, no letter
 * occurs more than once.
 * 
 * order was sorted in some custom order previously. We want to permute the
 * characters of str so that they match the order that order was sorted. More
 * specifically, if x occurs before y in order, then x should occur before y in
 * the returned string.
 * 
 * Return any permutation of str (as a string) that satisfies this property.
 * 
 * 
 * Example:
 * Input: 
 * order = "cba"
 * str = "abcd"
 * Output: "cbad"
 * Explanation: 
 * "a", "b", "c" appear in order, so the order of "a", "b", "c" should be "c",
 * "b", and "a". 
 * Since "d" does not appear in order, it can be at any position in the
 * returned string. "dcba", "cdba", "cbda" are also valid outputs.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * order has length at most 26, and no character is repeated in order.
 * str has length at most 200.
 * order and str consist of lowercase letters only.
 * 
 * 
 */
class Solution {
  public String customSortString(final String order, final String str) {
    final int[] count = new int[26];
    for (final char c : str.toCharArray()) {
      ++count[c - 'a'];
    }
    final StringBuilder sb = new StringBuilder();
    for (final char c : order.toCharArray()) {
      while (count[c - 'a']-- > 0) {
        sb.append(c);
      }
    }
    for (char c = 'a'; c <= 'z'; ++c) {
      while (count[c - 'a']-- > 0) {
        sb.append(c);
      }
    }
    return sb.toString();        
  }
}