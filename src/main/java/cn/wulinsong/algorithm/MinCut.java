package cn.wulinsong.algorithm;

import java.util.Arrays;

/**
 * 132. 分割回文串 II
 */
public class MinCut {

    /**
     * dp
     */
    public static int minCut(String s) {
        int len = s.length();
        boolean[][] f = new boolean[len][len];
        for (int i = len - 1; i >= 0; i --) {
            for (int j = i + 1; j < len; j ++) {
                f[i][j] = !(s.charAt(i) == s.charAt(j) && !f[i + 1][j - 1]);
            }
        }
        int[] dp = new int[len];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i < len; i ++) {
            if (!f[0][i]) {
                dp[i] = 0;
                continue;
            }
            for (int j = 0; j < i; j ++) {
                if (!f[j + 1][i]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args) {
        System.out.println(minCut("aab"));
    }
}
