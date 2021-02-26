package cn.wulinsong.algorithm;

import java.util.*;

/**
 * lee-code 1178. 猜字谜
 */
public class FindNumOfValidWords {

    public static List<Integer> findNumOfValidWords1(String[] words, String[] puzzles) {
        Map<Integer, Integer> maskFreqMap = new HashMap<>();
        for (String word : words) {
            int mask = 0;
            for (int i = 0; i < word.length(); i ++) {
                mask |= 1 << (word.charAt(i) - 'a');
            }
            if (Integer.bitCount(mask) <= 7)
                maskFreqMap.put(mask, maskFreqMap.getOrDefault(mask, 0) + 1);
        }
        List<Integer> ret = new ArrayList<>(puzzles.length);
        for (String puzzle : puzzles) {
            int mask = 0;
            for (int i = 1; i < 7; i ++) {
                mask |= 1 << (puzzle.charAt(i) - 'a');
            }
            int total = 0;
            int subset = mask;
            do {
                int s = subset | 1 << (puzzle.charAt(0) - 'a');
                total += maskFreqMap.getOrDefault(s, 0);
                subset = (subset - 1) & mask;
            } while (subset != mask);
            ret.add(total);
        }
        return ret;
    }

    TrieNode root;

    public List<Integer> findNumOfValidWords2(String[] words, String[] puzzles) {
        root = new TrieNode();

        for (String word : words) {
            // 将 word 中的字母按照字典序排序并去重
            char[] arr = word.toCharArray();
            Arrays.sort(arr);
            StringBuffer sb = new StringBuffer();
            for (int i = 0; i < arr.length; ++i) {
                if (i == 0 || arr[i] != arr[i - 1]) {
                    sb.append(arr[i]);
                }
            }
            // 加入字典树中
            add(root, sb.toString());
        }

        List<Integer> ans = new ArrayList<Integer>();
        for (String puzzle : puzzles) {
            char required = puzzle.charAt(0);
            char[] arr = puzzle.toCharArray();
            Arrays.sort(arr);
            ans.add(find(new String(arr), required, root, 0));
        }
        return ans;
    }

    public void add(TrieNode root, String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); ++i) {
            char ch = word.charAt(i);
            if (cur.child[ch - 'a'] == null) {
                cur.child[ch - 'a'] = new TrieNode();
            }
            cur = cur.child[ch - 'a'];
        }
        ++cur.frequency;
    }

    // 在回溯的过程中枚举 puzzle 的所有子集并统计答案
    // find(puzzle, required, cur, pos) 表示 puzzle 的首字母为 required, 当前搜索到字典树上的 cur 节点，并且准备枚举 puzzle 的第 pos 个字母是否选择（放入子集中）
    // find 函数的返回值即为谜底的数量
    public int find(String puzzle, char required, TrieNode cur, int pos) {
        // 搜索到空节点，不合法，返回 0
        if (cur == null) {
            return 0;
        }
        // 整个 puzzle 搜索完毕，返回谜底的数量
        if (pos == 7) {
            return cur.frequency;
        }

        // 选择第 pos 个字母
        int ret = find(puzzle, required, cur.child[puzzle.charAt(pos) - 'a'], pos + 1);

        // 当 puzzle.charAt(pos) 不为首字母时，可以不选择第 pos 个字母
        if (puzzle.charAt(pos) != required) {
            ret += find(puzzle, required, cur, pos + 1);
        }

        return ret;
    }

    static class TrieNode {
        int frequency;
        TrieNode[] child;

        public TrieNode() {
            frequency = 0;
            child = new TrieNode[26];
        }
    }
}
