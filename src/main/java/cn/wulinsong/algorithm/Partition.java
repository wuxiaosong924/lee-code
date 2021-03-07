package cn.wulinsong.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 131. 分割回文串
 */
public class Partition {

    boolean[][] f1;
    List<List<String>> ret1 = new ArrayList<>();
    LinkedList<String> ans1 = new LinkedList<>();
    int n1;

    /**
     * dp
     */
    public List<List<String>> partition(String s) {
        n1 = s.length();
        f1 = new boolean[n1][n1];
        for (int i = n1 - 1; i >= 0; i --) {
            for (int j = i + 1; j < n1; j ++) {
                f1[i][j] = !(s.charAt(i) == s.charAt(j) && !f1[i + 1][j - 1]);
            }
        }
        dfs1(s, 0);
        return ret1;
    }

    private void dfs1(String s, int i) {
        if (i == n1) {
            ret1.add(new ArrayList<>(ans1));
            return;
        }
        for (int j = i; j < n1; j ++) {
            if (!f1[i][j]) {
                ans1.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans1.removeLast();
            }
        }
    }

    int[][] f;
    List<List<String>> ret = new ArrayList<List<String>>();
    List<String> ans = new ArrayList<String>();
    int n;

    /**
     * 记忆化搜索
     */
    public List<List<String>> partition1(String s) {
        n = s.length();
        f = new int[n][n];

        dfs(s, 0);
        return ret;
    }

    public void dfs(String s, int i) {
        if (i == n) {
            ret.add(new ArrayList<String>(ans));
            return;
        }
        for (int j = i; j < n; ++j) {
            if (isPalindrome(s, i, j) == 1) {
                ans.add(s.substring(i, j + 1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

    public int isPalindrome(String s, int i, int j) {
        if (f[i][j] != 0) {
            return f[i][j];
        }
        if (i >= j) {
            f[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)) {
            f[i][j] = isPalindrome(s, i + 1, j - 1);
        } else {
            f[i][j] = -1;
        }
        return f[i][j];
    }
}
