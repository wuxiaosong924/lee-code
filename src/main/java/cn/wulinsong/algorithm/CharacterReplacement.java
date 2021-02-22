package cn.wulinsong.algorithm;

/**
 * lee-code 424. 替换后的最长重复字符
 */
public class CharacterReplacement {

    public int characterReplacement(String s, int k) {
        int len = s.length();
        int left = 0, right = 0;
        int[] freq = new int[26];
        int max = 0, maxCnt = 0;
        while (right < len) {
            int curr = s.charAt(right) - 'A';
            freq[curr] ++;
            maxCnt = Math.max(maxCnt, freq[curr]);
            right ++;
            if (right - left > maxCnt + k) {
                freq[s.charAt(left) - 'A'] --;
                left ++;
            } else {
                max = Math.max(max, right - left);
            }
        }
        return max;
    }
}
