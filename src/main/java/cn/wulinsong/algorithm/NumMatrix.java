package cn.wulinsong.algorithm;

/**
 * lee-code 304. 二维区域和检索 - 矩阵不可变
 */
public class NumMatrix {
    private int[][] prefix;

    /**
     * 二维前缀和
     */
    public NumMatrix(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        prefix = new int[row + 1][col + 1];
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                prefix[i + 1][j + 1] = prefix[i + 1][j] + prefix[i][j + 1] - prefix[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return prefix[row2 + 1][col2 + 1] - prefix[row1][col2 + 1] - prefix[row2 + 1][col1] + prefix[row1][col1];
    }

    /**
     * 一维前缀和
     */
    public void init(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        prefix = new int[row][col + 1];
        for (int i = 0; i < row; i ++) {
            for (int j = 0; j < col; j ++) {
                prefix[i][j + 1] = prefix[i][j] + matrix[i][j];
            }
        }
    }

    public int sumRegion1(int row1, int col1, int row2, int col2) {
        int sum = 0;
        while (row1 <= row2) {
            sum += prefix[row1][col2 + 1] - prefix[row1][col1];
            row1 ++;
        }
        return sum;
    }
}
