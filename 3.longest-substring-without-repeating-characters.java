import java.util.HashMap;

/*
 * @lc app=leetcode id=3 lang=java
 *
 * [3] Longest Substring Without Repeating Characters
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int n = s.length();
        int max = 0;
        int start = 0;
        
        for (int end = 0; end < n; end++) {
            if (map.containsKey(s.charAt(end)))
                start = Math.max(map.get(s.charAt(end)), start);

            max = Math.max(max, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return max;
    }
}
// @lc code=end
// @lc code=end
