/*
 * @lc app=leetcode id=7 lang=java
 *
 * [7] Reverse Integer
 */

// @lc code=start
class Solution {
    public int reverse(int x) {
        int answer = 0;
        int min = Integer.MIN_VALUE / 10;
        int max = Integer.MAX_VALUE / 10;
        int digit;
        while (x != 0) {
            digit = x % 10; // get digit from x
            x /= 10; // remove digit from x

            // check constrains
            if (answer < min || answer > max)
                return 0;
            if (answer == min && digit < -8)
                return 0;
            if (answer == max && digit > 7)
                return 0;

            // update answer
            answer = answer * 10 + digit;
        }
        return answer;
    }
}
// @lc code=end
