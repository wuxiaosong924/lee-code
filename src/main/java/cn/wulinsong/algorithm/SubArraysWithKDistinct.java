package cn.wulinsong.algorithm;

/**
 * lee-code 992. K 个不同整数的子数组
 */
public class SubArraysWithKDistinct {

    public static int subarraysWithKDistinct(int[] A, int K) {
        return atMostKDistinct(A, K) - atMostKDistinct(A, K - 1);
    }

    private static int atMostKDistinct(int[] A, int K) {
        int ret = 0;
        int count = 0;
        int left = 0, right = 0;
        int len = A.length;
        int[] freq = new int[len + 1];
        while (right < len) {
            if (freq[A[right]] == 0) {
                count ++;
            }
            freq[A[right]] ++;
            right ++;
            while (count > K) {
                freq[A[left]] --;
                if (freq[A[left]] == 0) {
                    count --;
                }
                left ++;
            }
            ret += right - left;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(subarraysWithKDistinct(new int[] {1, 2, 1, 2, 3}, 2));
    }
}
