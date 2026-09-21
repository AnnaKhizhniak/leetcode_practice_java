package app;

import java.util.Arrays;

public class Solution {
  static void main(String[] args) {
    Solution solution = new Solution();

    solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2});
  }

  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int mergedArrayLength = nums1.length + nums2.length;
    if (nums1.length > 1000
        && nums2.length > 1000
        && mergedArrayLength < 1 || mergedArrayLength > 2000) {
      return 0.0;
    }

    int[] mergedArrays = new int[mergedArrayLength];


    for (int i = 0; i < nums1.length; i++) {
      mergedArrays[i] = nums1[i];
    }

    for (int j = 0; j < nums2.length; j++) {
      mergedArrays[nums1.length + j] = nums2[j];
    }

    Arrays.sort(mergedArrays);

    double arrayLengthMedian = mergedArrayLength % 2 != 0
        ? mergedArrays[(mergedArrayLength / 2)]
        : (double) (mergedArrays[(mergedArrayLength / 2) - 1] + mergedArrays[(mergedArrayLength / 2)]) / 2;

    return arrayLengthMedian;
  }
}

/*
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106

 */