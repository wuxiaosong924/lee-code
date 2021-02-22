package cn.wulinsong.algorithm;

/**
 * lee-code 978  最长湍流子数组
 */
public class MaxTurbulence {

    public static int maxTurbulenceSize(int[] arr) {
        if (arr.length <= 1) {
            return arr.length;
        }
        int max = 1;
        int dp0 = 1, dp1 = 1;
        for (int i = 1, len = arr.length; i < len; i ++) {
            if (arr[i] > arr[i - 1]) {
                dp0 = dp1 + 1;
                dp1 = 1;
            } else if (arr[i] < arr[i - 1]) {
                dp1 = dp0 + 1;
                dp0 = 1;
            } else {
                dp0 = 1;
                dp1 = 1;
            }
            max = Math.max(dp0, Math.max(max, dp1));
        }
        return max;
    }

    public static int maxTurbulenceSize1(int[] arr) {
        if (arr.length <= 1) {
            return arr.length;
        }
        int max = 1;
        int len = arr.length - 1;
        int left = 0, right = 0;
        while (right < len) {
            if (left == right) {
                if (arr[right] == arr[right + 1]) {
                    left ++;
                }
                right ++;
            } else {
                if (arr[right - 1] > arr[right] && arr[right] < arr[right + 1]) {
                    right ++;
                } else if (arr[right - 1] < arr[right] && arr[right] > arr[right + 1]) {
                    right ++;
                } else
                    left = right;
            }
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
