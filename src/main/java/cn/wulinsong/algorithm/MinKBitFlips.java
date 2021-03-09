package cn.wulinsong.algorithm;

/**
 * lee-code 995. K 连续位的最小翻转次数
 *  差分法，K + 1 记录前面变化情况
 */
public class MinKBitFlips {

    public int minKBitFlips1(int[] A, int K) {
        int len = A.length;
        int ans = 0;
        int sum = 0;
        int[] diff = new int[len + 1];
        for (int i = 0; i < len; i ++) {
            sum += diff[i];
            if ((sum + A[i]) % 2 == 0) {
                if (i + K > len){
                    return -1;
                }
                ans ++;
                diff[i + K] --;
                sum ++;
            }
        }
        return ans;
    }

    public int minKBitFlips2(int[] A, int K) {
        int len = A.length;
        int cnt = 0;
        int ans = 0;
        int[] diff = new int[len + 1];
        for (int i = 0; i < len; i ++) {
            cnt ^= diff[i];
            if (cnt == A[i]) {
                if (i + K > len) {
                    return -1;
                }
                cnt ^= 1;
                diff[i + K] ^= 1;
                ans ++;
            }
        }
        return ans;
    }

    public int minKBitFlips3(int[] A, int K) {
        int len = A.length;
        int cnt = 0;
        int ans = 0;
        for (int i = 0; i < len; i ++) {
            if (i >= K && A[i - K] > 1) {
                cnt ^= 1;
                A[i - K] -= 2;
            }
            if (cnt == A[i]) {
                if (i + K > len) {
                    return -1;
                }
                ans ++;
                cnt ^= 1;
                A[i] += 2;
            }
        }
        return ans;
    }
}
