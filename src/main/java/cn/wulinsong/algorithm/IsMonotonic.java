package cn.wulinsong.algorithm;

/**
 * lee-code 896. 单调数列
 */
public class IsMonotonic {

    public boolean isMonotonic(int[] A) {
        if (A.length <= 2) {
            return true;
        }
        boolean up = true, down = true;
        for (int i = 1; i < A.length; i ++) {
            if (A[i] > A[i - 1]) {
                down = false;
            }else if (A[i] < A[i - 1]) {
                up = false;
            }
            if (!(up || down)) {
                return false;
            }
        }
        return true;
    }
}
