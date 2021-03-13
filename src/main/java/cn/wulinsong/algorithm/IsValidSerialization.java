package cn.wulinsong.algorithm;

import java.util.LinkedList;

/**
 * 331. 验证二叉树的前序序列化
 */
public class IsValidSerialization {

    public boolean isValidSerialization(String preorder) {
        LinkedList<Integer> stack = new LinkedList<>();
        stack.push(1);
        int i = 0, n = preorder.length();
        while (i < n) {
            if (stack.isEmpty()) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i ++;
                continue;
            }
            if (preorder.charAt(i) == '#') {
                int pre = stack.pop() - 1;
                if (pre > 0) {
                    stack.push(pre);
                }
                i ++;
            } else {
                while (i < n && preorder.charAt(i) != ',') {
                    i ++;
                }
                int pre = stack.pop() - 1;
                if (pre > 0) {
                    stack.push(pre);
                }
                stack.push(2);
            }
        }
        return stack.isEmpty();
    }

    public boolean isValidSerialization1(String preorder) {
        int i = 0, n = preorder.length();
        int slot = 1;
        while (i < n) {
            if (slot <= 0) {
                return false;
            }
            if (preorder.charAt(i) == ',') {
                i ++;
                continue;
            }
            if (preorder.charAt(i) == '#') {
                slot --;
                i ++;
            } else {
                while (i < n && preorder.charAt(i) != ',') {
                    i ++;
                }
                slot ++; // slot = slot - 1 + 2
            }
        }
        return slot == 0;
    }
}
