package cn.wulinsong.algorithm;

/**
 * lee-code 338. 比特位计数
 */
public class CountBits {

    public int[] countBits1(int num) {
        int[] ret = new int[num + 1];
        for (int i = 1; i <= num; i ++) {
            ret[i] = count(i);
        }
        return ret;
    }

    private int count(int i) {
        int count = 0;
        while (i > 0) {
            count ++;
            i &= i - 1;
        }
        return count;
    }

    public int[] countBits2(int num) {
        int[] ret = new int[num + 1];
        for (int i = 1; i <= num; i ++) {
            ret[i] = ret[i >> 1] + (i & 1);
        }
        return ret;
    }

    public int[] countBits3(int num) {
        int[] bits = new int[num + 1];
        for (int i = 1; i <= num; i ++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }
}
