import java.util.Deque;
import java.util.Map;

/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 *
 * https://leetcode.com/problems/valid-parentheses/description/
 *
 * algorithms
 * Easy (40.23%)
 * Likes:    13428
 * Dislikes: 603
 * Total Accepted:    2.3M
 * Total Submissions: 5.6M
 * Testcase Example:  '"()"'
 *
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
 * ']', determine if the input string is valid.
 * 
 * An input string is valid if:
 * 
 * 
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: s = "()"
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: s = "()[]{}"
 * Output: true
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: s = "(]"
 * Output: false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= s.length <= 10^4
 * s consists of parentheses only '()[]{}'.
 * 
 * 
 */

// @lc code=start
class Solution {
  public boolean isValid(final String s) {
    if (s == null || s.length() == 0 || s.length() % 2 == 1) {
      return false;
    }
    final Map<Character, Character> pairsMap = new HashMap<>(4);
    pairsMap.put('}', '{');
    pairsMap.put(']', '[');
    pairsMap.put(')', '(');
    final Deque<Character> stack = new LinkedList<>();
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (pairsMap.containsKey(c)) {
        if (stack.isEmpty() || stack.peek() != pairsMap.get(c)) {
          return false;
        }
        stack.pop();
      } else {
        stack.push(c);
      }
    }
    return stack.isEmpty();
  }
}
// @lc code=end
