package cn.wulinsong.algorithm;

/**
 * lee-code 1052. 爱生气的书店老板
 */
public class MaxSatisfied {

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        int total = 0;
        int len = customers.length;
        for (int i = 0; i < len; i ++) {
            if (grumpy[i] == 0) {
                total += customers[i];
            }
        }
        int incr = 0;
        for (int i = 0; i < X; i ++) {
            incr += customers[i] * grumpy[i];
        }
        int maxIncr = incr;
        for (int i = X; i < len; i ++) {
            incr += customers[i] * grumpy[i] - customers[i - X] * grumpy[i - X];
            maxIncr = Math.max(maxIncr, incr);
        }
        return total + maxIncr;
    }
}
