/*
 * @lc app=leetcode id=17 lang=java
 *
 * [17] Letter Combinations of a Phone Number
 *
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * algorithms
 * Medium (50.81%)
 * Likes:    11002
 * Dislikes: 709
 * Total Accepted:    1.2M
 * Total Submissions: 2.3M
 * Testcase Example:  '"23"'
 *
 * Given a string containing digits from 2-9 inclusive, return all possible
 * letter combinations that the number could represent. Return the answer in
 * any order.
 * 
 * A mapping of digits to letters (just like on the telephone buttons) is given
 * below. Note that 1 does not map to any letters.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: digits = "23"
 * Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: digits = ""
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: digits = "2"
 * Output: ["a","b","c"]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 0 <= digits.length <= 4
 * digits[i] is a digit in the range ['2', '9'].
 * 
 * 
 */

// @lc code=start
class Solution {
  public List<String> letterCombinations(String digits) {
    final LinkedList<String> deque = new LinkedList<>();
    // check before execution
    if (digits.isEmpty())
      return deque;
    // init the number-string letterMapping
    final String[] letterMapping = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    // add the empty string to avoid the NPE and to the first loop in the while loop
    // when i == 0;
    deque.add("");
    for (int i = 0; i < digits.length(); i++) {
      // get the number at the index position
      int number = digits.charAt(i) - '0';
      // the length of the first element is equal to the index, the operation is
      // required
      // why operation when equal? the length of the string should equal to index + 1
      while (deque.peekFirst().length() == i) {
        // get the first element to be operated on
        final String first = deque.pollFirst();
        for (char letter : letterMapping[number].toCharArray()) {
          // add the element to the end
          // avoid affecting the deque.peekFirst()
          deque.addLast(first + letter);
        }
      }
    }
    return deque;
  }
}
// @lc code=end
