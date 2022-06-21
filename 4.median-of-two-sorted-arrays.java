/*
 * @lc app=leetcode id=4 lang=java
 *
 * [4] Median of Two Sorted Arrays
 */

// @lc code=start
class Solution {
    private int[] createMergedSortedArray(int[] nums1,int l1, int[] nums2, int l2, int totalLength) {
        int merged[] = new int[totalLength];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < l1 && j < l2) {
            if (nums1[i] < nums2[j])
                merged[k++] = nums1[i++];
            else
                merged[k++] = nums2[j++];
        }
        while (i < l1)
            merged[k++] = nums1[i++];
        while (j < l2)
            merged[k++] = nums2[j++];

        return merged;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int l1 = nums1.length;
        int l2 = nums2.length;
        int n = l1 + l2;
        int merged[] = createMergedSortedArray(nums1, l1, nums2, l2, n);

        if (n % 2 != 0)
            return merged[n / 2];
        return (merged[(n - 1) / 2] + merged[n / 2]) / 2.0;
    }
}
// @lc code=end
