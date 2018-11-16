package com.huststl.year18.nov.day16;


//leetcode 004题 难度 hard

import java.util.Arrays;

public class Main004 {

    public double findMedianSortedArrays01(int[] nums1,int[] nums2){

        int m = nums1.length,n = nums2.length,
                left = (m+n+1)/2,right = (m+n+2)/2;

        return (findKth01(nums1,0,nums2,0,left) + findKth01(nums1,0,nums2,0,right)) / 2.0;
    }

    private int findKth01(int[] nums1, int i, int[] nums2, int j, int k) {

        if( i >= nums1.length )
            return nums2[j+k-1];

        if( j>=nums2.length)
            return nums1[i+k-1];

        if(k == 1)
            return Math.min(nums1[i],nums2[j]);

        int midVal1 = (i+k/2-1 < nums1.length)?nums1[i+k/2-1]:Integer.MAX_VALUE;

        int midVal2 = (j+k/2-1 < nums2.length)?nums2[j+k/2-1]:Integer.MAX_VALUE;

        if(midVal1 < midVal2){
            return findKth01(nums1,i+k/2,nums2,j,k-k/2);
        }else {
            return findKth01(nums1,i,nums2,j+k/2,k-k/2);
        }
    }


    //法2
    public class Solution {
        public double findMedianSortedArrays02(int[] nums1, int[] nums2) {
            int m = nums1.length, n = nums2.length, left = (m + n + 1) / 2, right = (m + n + 2) / 2;
            return (findKth(nums1, nums2, left) + findKth(nums1, nums2, right)) / 2.0;
        }
        int findKth(int[] nums1, int[] nums2, int k) {
            int m = nums1.length, n = nums2.length;
            if (m == 0) return nums2[k - 1];
            if (n == 0) return nums1[k - 1];
            if (k == 1) return Math.min(nums1[0], nums2[0]);
            int i = Math.min(m, k / 2), j = Math.min(n, k / 2);
            if (nums1[i - 1] > nums2[j - 1]) {
                return findKth(nums1, Arrays.copyOfRange(nums2, j, n), k - j);
            } else {
                return findKth(Arrays.copyOfRange(nums1, i, m), nums2, k - i);
            }
        }
    }



    //法三
    public double findMedianSortedArrays03(int[] nums1, int[] nums2) {
        int m = nums1.length, n = nums2.length;
        if (m < n) return findMedianSortedArrays03(nums2, nums1);
        if (n == 0) return (nums1[(m - 1) / 2] + nums1[m / 2]) / 2.0;
        int left = 0, right = 2 * n;
        while (left <= right) {
            int mid2 = (left + right) / 2;
            int mid1 = m + n - mid2;
            double L1 = mid1 == 0 ? Double.MIN_VALUE : nums1[(mid1 - 1) / 2];
            double L2 = mid2 == 0 ? Double.MIN_VALUE : nums2[(mid2 - 1) / 2];
            double R1 = mid1 == m * 2 ? Double.MAX_VALUE : nums1[mid1 / 2];
            double R2 = mid2 == n * 2 ? Double.MAX_VALUE : nums2[mid2 / 2];
            if (L1 > R2) left = mid2 + 1;
            else if (L2 > R1) right = mid2 - 1;
            else return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;
        }
        return -1;
    }
}
