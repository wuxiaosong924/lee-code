package cn.wulinsong.algorithm;

import java.util.HashMap;
import java.util.Map;

/**
 * lee-code 697. 数组的度
 */
public class FindShortestSubArray {

    public int findShortestSubArray(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i ++) {
            if (map.containsKey(nums[i])) {
                int[] arr = map.get(nums[i]);
                arr[0] ++;
                arr[2] = i;
            } else {
                map.put(nums[i], new int[] {1, i, i});
            }
        }
        int max = 0, minLen = Integer.MAX_VALUE;
        for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
            if (entry.getValue()[0] > max) {
                max = entry.getValue()[0];
                minLen = entry.getValue()[2] - entry.getValue()[1] + 1;
            } else if (entry.getValue()[0] == max) {
                minLen = Math.min(minLen, entry.getValue()[2] - entry.getValue()[1] + 1);
            }
        }
        return minLen;
    }
}
