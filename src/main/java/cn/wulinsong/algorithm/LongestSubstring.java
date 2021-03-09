package cn.wulinsong.algorithm;

/**
 * lee-code 395. 至少有 K 个重复字符的最长子串
 *  分割 + dfs
 */
public class LongestSubstring {

    public static int longestSubstring(String s, int k) {
        return dfs(s, 0, s.length() - 1, k);
    }

    private static int dfs(String s, int l, int r, int k) {
        if (r - l + 1 < k) {
            return 0;
        }
        int[] chars = new int[26];
        for (int i = l; i <= r; i ++) {
            chars[s.charAt(i) - 'a'] ++;
        }
        char split = 0;
        for (int i = 0; i < 26; i ++) {
            if (chars[i] > 0 && chars[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        if (split == 0) {
            return r - l + 1;
        }
        int ret = 0;
        while (l <= r) {
            while (l <= r && s.charAt(l) == split) {
                l ++;
            }
            if (l > r) {
                break;
            }
            int start = l;
            while (l <= r && s.charAt(l) != split) {
                l ++;
            }
            if (l - start >= k) {
                int length = dfs(s, start, l - 1, k);
                ret = Math.max(ret, length);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(longestSubstring("aaabb", 3));
    }

}
