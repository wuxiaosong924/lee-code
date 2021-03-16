package cn.wulinsong.algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 * 54. 螺旋矩阵
 */
public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ret = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return ret;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int left = 0, right = n - 1;
        int up = 0, down = m - 1;
        while (left <= right && up <= down) {
            for (int i = left; i <= right; i ++) {
                ret.add(matrix[up][i]);
            }
            up ++;

            for (int i = up; i <= down; i ++) {
                ret.add(matrix[i][right]);
            }
            right --;

            if (left > right || up > down) {
                break;
            }

            for (int i = right; i >= left; i --) {
                ret.add(matrix[down][i]);
            }
            down --;

            for (int i = down; i >= up; i --) {
                ret.add(matrix[i][left]);
            }
            left ++;
        }
        return ret;
    }
}
