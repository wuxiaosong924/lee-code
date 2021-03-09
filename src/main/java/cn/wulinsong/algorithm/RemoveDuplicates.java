package cn.wulinsong.algorithm;

import java.util.LinkedList;

/**
 * 1047. 删除字符串中的所有相邻重复项
 *  单调栈
 */
public class RemoveDuplicates {

    public String removeDuplicate(String S) {
        if (S.length() <= 1) {
            return S;
        }
        StringBuilder stack = new StringBuilder();
        stack.append(S.charAt(0));
        int top = 0;
        for (int i = 1; i < S.length(); i ++) {
            if (top >= 0 && S.charAt(i) == stack.charAt(top)) {
                stack.deleteCharAt(top);
                top --;
            } else {
                stack.append(S.charAt(i));
                top ++;
            }
        }
        return stack.toString();
    }

    public String removeDuplicate1(String S) {
        if (S.length() <= 1) {
            return S;
        }
        char[] stack = new char[S.length()];
        int top = -1;
        for (int i = 0; i < S.length(); i ++) {
            if (top >= 0 && S.charAt(i) == stack[top]) {
                top --;
            } else {
                top ++;
                stack[top] = S.charAt(i);
            }
        }
        return new String(stack, 0, top + 1);
    }

    public String removeDuplicates2(String S) {
        if (S.length() <= 1) {
            return S;
        }
        LinkedList<Character> stack = new LinkedList<>();
        stack.push(S.charAt(0));
        for (int i = 1; i < S.length(); i ++) {
            if (!stack.isEmpty() && S.charAt(i) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(S.charAt(i));
            }
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.reverse().toString();
    }
}
