package cn.wulinsong.algorithm;

/**
 * 59. 螺旋矩阵 II
 */
public class GenerateMatrix {

    public int[][] generateMatrix(int n) {
        int[][] ret = new int[n][n];
        int left = 0, right = n - 1;
        int up = 0, down = n - 1;
        int count = 1;
        while (left <= right && up <= down) {
            for (int i = left; i <= right; i ++) {
                ret[up][i] = count ++;
            }
            up ++;
            for (int i = up; i <= down; i ++) {
                ret[i][right] = count ++;
            }
            right --;
            if (left > right || up > down) {
                break;
            }
            for (int i = right; i >= left; i --) {
                ret[down][i] = count ++;
            }
            down --;
            for (int i = down; i >= up; i --) {
                ret[i][left] = count ++;
            }
            left ++;
        }
        return ret;
    }
}
