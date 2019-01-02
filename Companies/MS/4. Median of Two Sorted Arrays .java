class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if ((len1 + len2) % 2 == 0) {
            return (findKth(nums1, 0, nums2, 0, (len1 + len2) / 2) + findKth(nums1, 0, nums2, 0, (len1 + len2) / 2 + 1)) / 2;
        } else {
            return findKth(nums1, 0, nums2, 0, (len1 + len2) / 2 + 1);
        }
    }
    private double findKth(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 >= nums1.length || start2 >= nums2.length) {
            return start1 >= nums1.length ? nums2[start2 + k - 1] : nums1[start1 + k - 1];
        }
        if (k == 1) {
            return Math.min(nums1[start1], nums2[start2]);
        }
        int mid1 = (start1 + k / 2 - 1 >= nums1.length) ? Integer.MAX_VALUE : nums1[start1 + k / 2 - 1];
        int mid2 = (start2 + k / 2 - 1 >= nums2.length) ? Integer.MAX_VALUE : nums2[start2 + k / 2 - 1];
        if (mid1 > mid2) {
            return helper(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        } else {
            return helper(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        }
    }
}