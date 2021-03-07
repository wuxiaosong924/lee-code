package cn.wulinsong.algorithm;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 503. 下一个更大元素 II
 */
public class NextGreaterElements {

    public static int[] nextGreaterElements2(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();
        int len = nums.length;
        int[] ret = new int[len];
        Arrays.fill(ret, -1);
        for (int i = 0; i < len; i ++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i]) {
                ret[stack.poll()] = nums[i];
            }
            stack.push(i);
        }
        for (int num : nums) {
            while (!stack.isEmpty() && nums[stack.peek()] < num) {
                ret[stack.poll()] = num;
            }
            if (stack.size() == 1) {
                break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(nextGreaterElements2(new int[] {1,2,1}));
    }

    public int[] nextGreaterElements1(int[] nums) {
        LinkedList<Integer> stack = new LinkedList<>();
        int len = nums.length;
        int[] ret = new int[len];
        Arrays.fill(ret, -1);
        for (int i = 0, n = len * 2 - 1; i < n; i ++) {
            while (!stack.isEmpty() && nums[stack.peek()] < nums[i % len]) {
                ret[stack.poll()] = nums[i % len];
            }
            stack.push(i % n);
        }
        return ret;
    }
}
