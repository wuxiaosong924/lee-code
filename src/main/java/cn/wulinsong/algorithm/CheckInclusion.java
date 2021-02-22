package cn.wulinsong.algorithm;

/**
 * lee-code 567. 字符串的排列
 */
public class CheckInclusion {

    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if (n > m) {
            return false;
        }
        int[] chars = new int[26];
        for (int i = 0; i < n; i ++) {
            chars[s1.charAt(i) - 'a'] --;
        }
        int left = 0, right = 0;
        while (right < m) {
            int idx = s2.charAt(right) - 'a';
            chars[idx] ++;
            while (chars[idx] > 0) {
                chars[s2.charAt(left) - 'a'] --;
                left ++;
            }
            if (right - left + 1 == n) {
                return true;
            }
            right ++;
        }
        return false;
    }
}
