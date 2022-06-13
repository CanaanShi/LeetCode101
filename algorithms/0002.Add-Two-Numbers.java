/*
 * @lc app=leetcode id=2 lang=java
 *
 * [2] Add Two Numbers
 *
 * https://leetcode.com/problems/add-two-numbers/description/
 *
 * algorithms
 * Medium (36.38%)
 * Likes:    18798
 * Dislikes: 3806
 * Total Accepted:    2.8M
 * Total Submissions: 7.3M
 * Testcase Example:  '[2,4,3]\n[5,6,4]'
 *
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order, and each of their nodes
 * contains a single digit. Add the two numbers and return the sum as a linked
 * list.
 * 
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in each linked list is in the range [1, 100].
 * 0 <= Node.val <= 9
 * It is guaranteed that the list represents a number that does not have
 * leading zeros.
 * 
 * 
 */

// @lc code=start
/**
 * Definition for singly-linked list. public class ListNode { int val; ListNode
 * next; ListNode() {} ListNode(int val) { this.val = val; } ListNode(int val,
 * ListNode next) { this.val = val; this.next = next; } }
 */
class Solution {
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    // before the start, easy to return result
    ListNode preHead = new ListNode(-1);
    // easy to move pointer
    ListNode prev = preHead;
    // take the tens place number
    int carry = 0;
    // terminate the loop when l1 == null && l2 ==null
    while (l1 != null || l2 != null) {
      // prevent NPE
      int x = l1 == null ? 0 : l1.val;
      int y = l2 == null ? 0 : l2.val;
      // sum the l1 value , l2 value and the tens number from last sum
      int sum = x + y + carry;
      // get the tens number
      carry = sum / 10;
      // get the units number
      sum %= 10;
      // point to the next
      prev.next = new ListNode(sum);

      // move the pointer
      prev = prev.next;
      if (l1 != null) l1 = l1.next;
      if (l2 != null) l2 = l2.next;
    }
    // when the loop ends, the carry may still have a value, point the pointer to Carry
    if (carry == 1) {
      prev.next = new ListNode(carry);
    }
    // return the result
    return preHead.next;
  }
}
// @lc code=end
