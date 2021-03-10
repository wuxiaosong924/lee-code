package cn.wulinsong.algorithm;

import java.util.LinkedList;

/**
 * 224. 基本计算器
 *  括号展开 + 盏
 *      sign 记录之前操作，遇到'(' 入栈之前的sign，遇到')' 出栈
 *      '+' 则使用括号之前的操作， '-' 取相反
 */

public class Calculate {

    public static int calculate(String s) {
        LinkedList<Integer> ops = new LinkedList<>();
        ops.push(1);
        int i = 0, n = s.length();
        int sign = 1;
        int ret = 0;
        while (i < n) {
            char curr = s.charAt(i);
            if (curr == ' ') {
                i ++;
            } else if (curr == '+') {
                sign = ops.peek();
                i ++;
            } else if (curr == '-') {
                sign = - ops.peek();
                i ++;
            } else if (curr == '(') {
                ops.push(sign);
                i ++;
            } else if (curr == ')') {
                ops.pop();
                i ++;
            } else {
                long num = 0;
                while (i < n && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i ++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(calculate("1 + 2 + 3 - 4"));
        System.out.println(calculate(" 2-1 + 2 "));
        System.out.println(calculate("(1+(4+5+2)-3)+(6+8)"));
    }
}
