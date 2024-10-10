package LeetCode;

public class LeetCode04_findMedianSortedArrays {
    // 这个方法复杂度为O(m+n)
    public static void main(String[] args) {
        int[] nums1 = {1,3};
        int[] nums2 = {2,4};
        double res = 1d;
        int len1 = nums1.length;
        int len2 = nums2.length;
        int len = len1 + len2;
        int[] total = new int[len];
        int i = 0;
        int j = 0;
        while (i + j < len) {
            if (i == len1) {
                total[i+j] = nums2[j];
                j++;
            } else if (j == len2) {
                total[i+j] = nums1[i];
                i++;
            } else if (nums1[i] <= nums2[j]) {
                total[i+j] = nums1[i];
                i++;
            } else {
                total[i+j] = nums2[j];
                j++;
            }
        }

        if (len %2 == 0) {
            System.out.println((total[len / 2 -1] + total[len / 2]) / 2);
        } else {
            System.out.println(total[(len - 1) / 2]);
        }

        for (int k : total) {
            System.out.println(k);
        }
    }

    // 这个方法时间复杂度为log(min(m,n))
    public double findMediaSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int left = 0, right = m;
        // median1: 前一部分的最大值
        // median2: 后一部分的最小值
        int median1 = 0, median2 = 0;

        while (left <= right) {
            // 前一部分包含 nums1[0 .. i-1] 和 nums2[0 .. j-1]
            // 后一部分包含 nums1[i .. m-1] 和 nums2[j .. n-1]
            int i = (left + right) / 2;
            int j = (m + n + 1) / 2 - i;

            // nums_im1, nums_i, nums_jm1, nums_j 分别表示 nums1[i-1], nums1[i], nums2[j-1], nums2
            int nums_im1 = (i == 0 ? Integer.MIN_VALUE : nums1[i - 1]);
            int nums_i = (i == m ? Integer.MAX_VALUE : nums1[i]);
            int nums_jm1 = (j == 0 ? Integer.MIN_VALUE : nums2[j - 1]);
            int nums_j = (j == n ? Integer.MAX_VALUE : nums2[j]);

            if (nums_im1 <= nums_j) {
                median1 = Math.max(nums_im1, nums_jm1);
                median2 = Math.min(nums_i, nums_j);
                left = i + 1;
            } else {
                right = i - 1;
            }
        }
        return (m + n) % 2 == 0 ? (median1 + median2) / 2.0 : median1;
    }
}
