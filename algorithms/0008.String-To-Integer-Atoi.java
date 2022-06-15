import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 *
 * https://leetcode.com/problems/string-to-integer-atoi/description/
 *
 * algorithms
 * Medium (15.88%)
 * Likes:    1793
 * Dislikes: 5245
 * Total Accepted:    1M
 * Total Submissions: 6.2M
 * Testcase Example:  '"42"'
 *
 * Implement the myAtoi(string s) function, which converts a string to a 32-bit
 * signed integer (similar to C/C++'s atoi function).
 *
 * The algorithm for myAtoi(string s) is as follows:
 *
 *
 * Read in and ignore any leading whitespace.
 * Check if the next character (if not already at the end of the string) is '-'
 * or '+'. Read this character in if it is either. This determines if the final
 * result is negative or positive respectively. Assume the result is positive
 * if neither is present.
 * Read in next the characters until the next non-digit character or the end of
 * the input is reached. The rest of the string is ignored.
 * Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If
 * no digits were read, then the integer is 0. Change the sign as necessary
 * (from step 2).
 * If the integer is out of the 32-bit signed integer range [-2^31, 2^31 - 1],
 * then clamp the integer so that it remains in the range. Specifically,
 * integers less than -2^31 should be clamped to -2^31, and integers greater
 * than 2^31 - 1 should be clamped to 2^31 - 1.
 * Return the integer as the final result.
 *
 *
 * Note:
 *
 *
 * Only the space character ' ' is considered a whitespace character.
 * Do not ignore any characters other than the leading whitespace or the rest
 * of the string after the digits.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: s = "42"
 * Output: 42
 * Explanation: The underlined characters are what is read in, the caret is the
 * current reader position.
 * Step 1: "42" (no characters read because there is no leading whitespace)
 * ⁠        ^
 * Step 2: "42" (no characters read because there is neither a '-' nor '+')
 * ⁠        ^
 * Step 3: "42" ("42" is read in)
 * ⁠          ^
 * The parsed integer is 42.
 * Since 42 is in the range [-2^31, 2^31 - 1], the final result is 42.
 *
 *
 * Example 2:
 *
 *
 * Input: s = "   -42"
 * Output: -42
 * Explanation:
 * Step 1: "   -42" (leading whitespace is read and ignored)
 * ⁠           ^
 * Step 2: "   -42" ('-' is read, so the result should be negative)
 * ⁠            ^
 * Step 3: "   -42" ("42" is read in)
 * ⁠              ^
 * The parsed integer is -42.
 * Since -42 is in the range [-2^31, 2^31 - 1], the final result is -42.
 *
 *
 * Example 3:
 *
 *
 * Input: s = "4193 with words"
 * Output: 4193
 * Explanation:
 * Step 1: "4193 with words" (no characters read because there is no leading
 * whitespace)
 * ⁠        ^
 * Step 2: "4193 with words" (no characters read because there is neither a '-'
 * nor '+')
 * ⁠        ^
 * Step 3: "4193 with words" ("4193" is read in; reading stops because the next
 * character is a non-digit)
 * ⁠            ^
 * The parsed integer is 4193.
 * Since 4193 is in the range [-2^31, 2^31 - 1], the final result is 4193.
 *
 *
 *
 * Constraints:
 *
 *
 * 0 <= s.length <= 200
 * s consists of English letters (lower-case and upper-case), digits (0-9), '
 * ', '+', '-', and '.'.
 *
 *
 */

// @lc code=start
class Solution {
    // way 1: iterator
    public int myAtoi(String s) {
        // check param before execution
        if (s == null || s.length() == 0) {
            return 0;
        }
        int length = s.length();
        int index = 0;
        // determine the length of the whitespace prefix
        while (index < length && s.charAt(index) == ' ') {
            index++;
        }
        // if the string fill with whitespace, return 0
        if (index == length) {
            return 0;
        }
        // check sign only once
        boolean negative = false;
        if (s.charAt(index) == '-') {
            negative = true;
            index++;
        } else if (s.charAt(index) == '+') {
            index++;
        }
        int res = 0;
        while (index < length) {
            char c = s.charAt(index);
            // if non-digit character appears, break the loop
            if (c < '0' || c > '9') {
                break;
            }
            // convert the character to literal int value by sub '0'
            int tail = c - '0';
            // determine the boundary
            if (! negative && res > (Integer.MAX_VALUE - tail) / 10) {
                return Integer.MAX_VALUE;
            } else if (negative && - res < (Integer.MIN_VALUE + tail) / 10) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + tail;
            index++;
        }
        // return the number according to the negative flag or not
        return negative ? - res : res;
    }

    // way 2: Deterministic Finite Automaton
    public int myAtoi1(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // init a new automaton with the state of start
        Automaton automaton = new Automaton();
        for (int i = 0; i < s.length(); i++) {
            automaton.echo(s.charAt(i));
        }
        return automaton.negative ? - automaton.res : automaton.res;
    }

    static class Automaton {
        private static final String START = "start";
        private static final String SIGNED = "signed";
        private static final String DIGIT = "digit";
        private static final String END = "end";
        /**
         * key: state stage
         * value: the step of the state
         */
        private static final Map<String, String[]> stateMap = new HashMap<>();

        boolean negative = false;
        int res = 0;
        private String state = START;

        public Automaton() {
            /**
             * when state is start<br/>
             * character is whitespace, go to start<br/>
             * character is + or -, go to signed<br/>
             * character is 0~9, go to digit<br/>
             * character does not match all of the above, go to end<br/>
             */
            stateMap.put(START, new String[]{START, SIGNED, DIGIT, END});
            /**
             * when state is signed or digit<br/>
             * character is 0~9, go to digit<br/>
             * character is other case, go to end<br/>
             */
            stateMap.put(SIGNED, new String[]{END, END, DIGIT, END});
            stateMap.put(DIGIT, new String[]{END, END, DIGIT, END});
            /**
             * when state is end<br/>
             * whatever the value of the character , go to end
             */
            stateMap.put(END, new String[]{END, END, END, END});
        }

        public void echo(final char c) {
            // After a state change, it is impossible to go back to the previous state
            state = stateMap.get(state)[getStep(c)];
            if (DIGIT.equals(state)) {
                int tail = c - '0';
                if (! negative && res > (Integer.MAX_VALUE - tail) / 10) {
                    res = Integer.MAX_VALUE;
                } else if (negative && - res < (Integer.MIN_VALUE + tail) / 10) {
                    res = Integer.MIN_VALUE;
                } else {
                    res = res * 10 + tail;
                }
            } else if (SIGNED.equals(state)) {
                negative = c == '-';
            }
        }

        private int getStep(final char c) {
            if (c == ' ') {
                return 0;
            } else if (c == '+' || c == '-') {
                return 1;
            } else if (c >= '0' && c <= '9') {
                return 2;
            } else {
                return 3;
            }
        }
    }
}
// @lc code=end
