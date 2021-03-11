package cn.wulinsong.algorithm;

import java.util.LinkedList;

/**
 * 227. 基本计算器 II
 */
public class CalculateBase {

    public static int calculate(String s) {
        int n = s.length();
        LinkedList<Integer> stack = new LinkedList<>();
        int preSign = '+';
        char curr;
        for (int i = 0; i < n; i ++) {
            curr = s.charAt(i);
            if (curr == ' ') {
                continue;
            }
            if (Character.isDigit(curr) || i == n - 1) {
                int num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i --;
                if (preSign == '+') {
                    stack.push(num);
                } else if (preSign == '-') {
                    stack.push(- num);
                } else {
                    int pre = stack.pop();
                    if (preSign == '*') {
                        pre *= num;
                    } else {
                        pre /= num;
                    }
                    stack.push(pre);
                }
            } else {
                preSign = curr;
            }
        }

        int ret = 0;
        while (!stack.isEmpty()) {
            ret += stack.poll();
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(calculate("0-2147483647"));
        System.out.println(calculate("3 + 2*2"));
    }

    public static int calculate1(String s) {
        LinkedList<Character> ops = new LinkedList<>();
        LinkedList<Integer> digit = new LinkedList<>();
        for (int i = 0; i < s.length(); i ++) {
            char curr = s.charAt(i);
            if (curr == ' ') {
                continue;
            }
            if (curr == '+' || curr == '-' || curr == '*' || curr == '/') {
                ops.push(curr);
            } else {
                int num = 0;
                while (i < s.length() && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i ++;
                }
                i --;
                if (!ops.isEmpty() && (ops.peek() == '*' || ops.peek() == '/')) {
                    int pre = digit.pop();
                    if (ops.pop() == '*') {
                        pre *= num;
                    } else {
                        pre /= num;
                    }
                    digit.push(pre);
                } else {
                    digit.push(num);
                }
            }
        }
        int ret = digit.removeLast();
        while (!ops.isEmpty()) {
            char op = ops.removeLast();
            long second = digit.removeLast();
            if (op == '-') {
                ret -= second;
            } else {
                ret += second;
            }
        }
        return ret;
    }
}
