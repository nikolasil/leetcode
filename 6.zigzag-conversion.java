/*
 * @lc app=leetcode id=6 lang=java
 *
 * [6] Zigzag Conversion
 */

// @lc code=start
class Solution {
    private boolean notEdgeRows(int row, int numRows) {
        if (row != 0 && row != numRows - 1)
            return true;
        return false;
    }

    private boolean isValidIndex(int index, int length) {
        if (index < length)
            return true;
        return false;
    }

    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;

        StringBuilder answer = new StringBuilder();
        int n = s.length();
        int interval = 2 * numRows - 2;

        for (int row = 0; row < numRows; row++) {
            for (int i = 0; isValidIndex(i + row, n); i += interval) {
                answer.append(s.charAt(i + row));
                if (notEdgeRows(row, numRows) && isValidIndex(i + interval - row, n))
                    answer.append(s.charAt(i + interval - row));
            }
        }
        return answer.toString();
    }
}
// @lc code=end
