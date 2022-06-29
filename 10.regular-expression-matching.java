/*
 * @lc app=leetcode id=10 lang=java
 *
 * [10] Regular Expression Matching
 */

// @lc code=start
class Solution {

    private boolean isDot(String pattern, int patternIndex) {
        if (pattern.charAt(patternIndex) == '.')
            return true;
        return false;
    }

    private boolean isStar(String pattern, int patternIndex) {
        if (pattern.charAt(patternIndex) == '*')
            return true;
        return false;
    }

    private boolean checkCharactersMatching(String text, int textIndex, String pattern, int patternIndex) {
        if (pattern.charAt(patternIndex) == text.charAt(textIndex) || isDot(pattern, patternIndex))
            return true;
        return false;
    }
    private void setDiagnonal(boolean[][] dp, int textIndex, int patternIndex) {
        dp[textIndex][patternIndex] = dp[textIndex - 1][patternIndex - 1];
    }

    private void setFirstOccuranceOfStar(boolean[][] dp, int textIndex, int patternIndex) {
        dp[textIndex][patternIndex] = dp[textIndex][patternIndex - 2];
    }

    private void setOccuranceOfStar(boolean[][] dp, int textIndex, int patternIndex) {
        dp[textIndex][patternIndex] = checkStarZeroOccurance(dp, textIndex, patternIndex)
                || checkStarPrevOccurance(dp, textIndex, patternIndex)
                || checkStarLastOccurance(dp, textIndex, patternIndex);
    }
    
    private boolean checkStarZeroOccurance(boolean[][] dp, int textIndex, int patternIndex) {
        return dp[textIndex][patternIndex - 2];
    }

    private boolean checkStarPrevOccurance(boolean[][] dp, int textIndex, int patternIndex) {
        return dp[textIndex][patternIndex - 1];
    }

    private boolean checkStarLastOccurance(boolean[][] dp, int textIndex, int patternIndex) {
        return dp[textIndex - 1][patternIndex];
    }

    public boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[0][0] = true;

        for (int j = 1; j <= pattern.length(); j++)
            if (isStar(pattern, j - 1) && dp[0][j - 2])
                dp[0][j] = true;

        for (int textIndex = 1; textIndex <= text.length(); textIndex++) {
            for (int patternIndex = 1; patternIndex <= pattern.length(); patternIndex++) {

                if (checkCharactersMatching(text, textIndex - 1, pattern, patternIndex - 1)) {
                    setDiagnonal(dp, textIndex, patternIndex);
                } else if (isStar(pattern, patternIndex - 1)) {
                    if (!checkCharactersMatching(text, textIndex - 1, pattern, patternIndex - 2))
                        setFirstOccuranceOfStar(dp, textIndex, patternIndex);
                    else
                        setOccuranceOfStar(dp, textIndex, patternIndex);

                }

            }
        }
        return dp[text.length()][pattern.length()];
    }
}
// @lc code=end
