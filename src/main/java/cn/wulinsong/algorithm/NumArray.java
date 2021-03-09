package cn.wulinsong.algorithm;

/**
 * lee-code 303. 区域和检索 - 数组不可变
 *  前缀和
 */
public class NumArray {

    private int[] sum;

    public NumArray(int[] nums) {
        int len = nums.length;
        sum = new int[len + 1];
        for (int i = 0; i < nums.length; i ++) {
            sum[i + 1] = nums[i] + sum[i];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
