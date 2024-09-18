package LeetCode;

public class LeetCode04_findMedianSortedArrays {
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
}
