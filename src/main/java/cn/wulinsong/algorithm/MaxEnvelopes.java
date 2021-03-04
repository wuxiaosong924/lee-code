package cn.wulinsong.algorithm;

import java.util.Arrays;

/**
 * 354. 俄罗斯套娃信封问题
 */
public class MaxEnvelopes {

    /**
     * 二分发
     */
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes.length <= 1) {
            return envelopes.length;
        }
        Arrays.sort(envelopes, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]);
        return longestLTS(envelopes);
    }

    private int longestLTS(int[][] envelopes) {
        int[] dp = new int[envelopes.length];
        int len = 0;
        for (int[] envelope : envelopes) {
            int idx = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if (idx < 0) {
                idx = - (idx + 1);
            }
            dp[idx] = envelope[1];
            if (len == idx) {
                len ++;
            }
        }
        return len;
    }
    /*
     * dp
     */
    public int maxEnvelopes1(int[][] envelopes) {
        if (envelopes.length <= 1) {
            return envelopes.length;
        }
        Arrays.sort(envelopes, (o1, o2) -> o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1]);
        int max = 1;
        int len = envelopes.length;
        int[] dp = new int[len];
        for (int i = 0; i < len; i ++) {
            for (int j = 0; j < i; j ++) {
                if (envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i] + 1);
        }
        return max;
    }
}
