package cn.wulinsong.algorithm;

import java.util.LinkedList;
import java.util.TreeMap;

/**
 * lee-code 1438. 绝对差不超过限制的最长连续子数组
 */
public class LongestSubarray {

    public int longestSubarray1(int[] nums, int limit) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int len = nums.length;
        int max = 0;
        int left = 0, right = 0;
        while (right < len) {
            treeMap.put(nums[right], treeMap.getOrDefault(nums[right], 0) + 1);
            while (treeMap.firstKey() + limit < treeMap.lastKey()) {
                int leftCount = treeMap.get(nums[left]);
                if (leftCount == 1) {
                    treeMap.remove(nums[left]);
                } else {
                    treeMap.put(nums[left], leftCount - 1);
                }
                left ++;
            }
            right ++;
            max = Math.max(max, right - left);
        }
        return max;
    }

    public int longestSubarray2(int[] nums, int limit) {
        LinkedList<Integer> maxQueue = new LinkedList<>();
        LinkedList<Integer> minQueue = new LinkedList<>();
        int len = nums.length;
        int max = 0;
        int left = 0, right = 0;
        while (right < len) {
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < nums[right]) {
                maxQueue.pollLast();
            }
            while (!minQueue.isEmpty() && minQueue.peekLast() > nums[right]) {
                minQueue.pollLast();
            }
            maxQueue.add(nums[right]);
            minQueue.add(nums[right]);
            while (!maxQueue.isEmpty() && !minQueue.isEmpty() && maxQueue.peekFirst() > minQueue.peekFirst() + limit) {
                if (maxQueue.peekFirst() == nums[left]) {
                    maxQueue.pollFirst();
                }
                if (minQueue.peekFirst() == nums[left]) {
                    minQueue.pollFirst();
                }
                left ++;
            }
            right ++;
            max = Math.max(max, right - left);
        }
        return max;
    }
}
