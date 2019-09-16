package medianOfTwoSortedArrays;

/**
 * source: https://leetcode-cn.com/problems/median-of-two-sorted-arrays/
 * date: 2019/9/16
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m == 0 && n == 0) return 0.0;
        if (m == 0)
            return n % 2 == 1 ? nums2[n/2] : (nums2[n/2-1] + nums2[n/2]) / 2.0;
        if (n == 0)
            return m % 2 == 1 ? nums1[m/2] : (nums1[m/2-1] + nums1[m/2]) / 2.0;
        return m > n ? findMedianSortedArraysHelper(nums1, m, nums2, n, 0, m-1, 0, n-1)
                : findMedianSortedArraysHelper(nums2, n, nums1, m, 0, n-1, 0, m-1);
    }

    private double findMedianSortedArraysHelper(int[] A, int m,
                                                int[] B, int n,
                                                int lowA, int highA,
                                                int lowB, int highB) {
        int mid = lowA + (highA - lowA) / 2;
        int pos = binarySearch(B, lowB, highB, A[mid]);
        int num = mid + pos;
        if (num == (m+n)/2) {
            if ((m+n)%2 ==1)
                return A[mid];
            int next = 0;
            if (mid > 0 && pos > 0) {
                next = Math.max(A[mid - 1], B[pos - 1]);
            } else if (mid > 0) {
                next = A[mid-1];
            } else if (pos > 0) {
                next = B[pos-1];
            }
            return (A[mid] + next) / 2.0;
        } else if (num < (m+n)/2) {
            lowA = mid + 1;
            lowB = pos;
            return highA - lowA > highB - lowB
                    ? findMedianSortedArraysHelper(A, m, B, n, lowA, highA, lowB, highB)
                    : findMedianSortedArraysHelper(B, n, A, m, lowB, highB, lowA, highA);
        } else {
            highA = mid - 1;
            highB = pos - 1;
            return highA - lowA > highB - lowB
                    ? findMedianSortedArraysHelper(A, m, B, n, lowA, highA, lowB, highB)
                    : findMedianSortedArraysHelper(B, n, A, m, lowB, highB, lowA, highA);
        }
    }

    private int binarySearch(int[] A, int low, int high, int key) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (key == A[mid]) return mid;
            if (key < A[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return low;
    }
}