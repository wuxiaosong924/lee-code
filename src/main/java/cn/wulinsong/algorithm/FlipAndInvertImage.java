package cn.wulinsong.algorithm;

/**
 * lee-code 832. 翻转图像
 */
public class FlipAndInvertImage {

    public static int[][] flipAndInvertImage(int[][] A) {
        if (A.length == 1) {
            A[0][0] ^= 1;
            return A;
        }
        int len = A.length;
        for (int i = 0; i < len; i ++) {
            int left = 0, right = len - 1;
            while (left < right) {
                int tmp = A[i][left] ^ 1;
                A[i][left] = A[i][right] ^ 1;
                A[i][right] = tmp;
                left ++;
                right --;
            }
            if (left == right) {
                A[i][left] ^= 1;
            }
        }
        return A;
    }

    public static void main(String[] args) {
        flipAndInvertImage(new int[][] {{1,1,0},{1,0,1},{0,0,0}});
    }
}
