package cn.wulinsong.algorithm;

/**
 * lee-code 1004. 最大连续1的个数 III
 */
public class LongestOnes {

    /**
     * 1，2 滑动窗口
     */
    public int longestOnes1(int[] A, int K) {
        int len = A.length;
        int left = 0, right = 0;
        int lSum = 0, rSum = 0;
        int max = 0;
        while (right < len) {
            rSum += 1 - A[right];
            while (lSum < rSum - K) {
                lSum += 1 - A[left];
                left ++;
            }
            right ++;
            max = Math.max(max, right - left);
        }
        return max;
    }

    public int longestOnes2(int[] A, int K) {
        int len = A.length;
        int left = 0;
        int lSum = 0, rSum = 0;
        int max = 0;
        for (int right = 0; right < len; right ++) {
            rSum += 1 - A[right];
            while (lSum < rSum - K) {
                lSum += 1 - A[left];
                left ++;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }

    /**
     * 二分法
     */
    public int longestOnes3(int[] A, int K) {
        int n = A.length;
        int[] P = new int[n + 1];
        for (int i = 1; i <= n; ++i) {
            P[i] = P[i - 1] + (1 - A[i - 1]);
        }

        int ans = 0;
        for (int right = 0; right < n; ++right) {
            int left = binarySearch(P, P[right + 1] - K);
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    private int binarySearch(int[] P, int target) {
        int low = 0, high = P.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (P[mid] < target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
