package cn.wulinsong.algorithm;

/**
 * lee-code 867. 转置矩阵
 */
public class Transpose {

    public int[][] transpose(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] ret = new int[col][row];
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                ret[j][i] = matrix[i][j];
            }
        }
        return ret;
    }
}
