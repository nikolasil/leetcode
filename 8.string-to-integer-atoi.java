import java.util.Arrays;

/*
 * @lc app=leetcode id=8 lang=java
 *
 * [8] String to Integer (atoi)
 */

// @lc code=start
class Solution {
    public int myAtoi(String s) {
        int sign = 1;
        int answer = 0;
        int index = 0;
        int n = s.length();
        int digit;
        int max = Integer.MAX_VALUE / 10;
        int maxMOD = Integer.MAX_VALUE % 10;

        while (index < n && s.charAt(index) == ' ') {
            index++;
        }

        if (index < n) {
            if (s.charAt(index) == '-') {
                sign = -1;
                index++;
            } else if (s.charAt(index) == '+')
                index++;
        }
        
        while (index < n && Character.isDigit(s.charAt(index))) {
            digit = s.charAt(index) - '0';

            if (answer > max || (answer == max && digit > maxMOD))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;

            answer = 10 * answer + digit;
            index++;
        }

        return sign * answer;
    }
}
// @lc code=end
