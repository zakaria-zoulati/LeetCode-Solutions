class Solution {
    public class Trie {
        Trie[] childs;
        boolean isEnd;
        public Trie() {
            childs = new Trie[26];
            isEnd = false;
        }
        public void insert(String s, int in) {
            if (in == s.length()) {
                this.isEnd = true;
                return;
            }
            int ind = s.charAt(in) - 'a';
            if (childs[ind] == null) {
                childs[ind] = new Trie();
            }
            childs[ind].insert(s, in + 1);
        }
        public void check(String word, int start, boolean[] dp) {
            Trie curr = this;
            for (int i = start; i < word.length(); ++i) {
                int index = word.charAt(i) - 'a';
                if (curr.childs[index] == null) break;
                curr = curr.childs[index];
                if (curr.isEnd) {
                    dp[i + 1] = true;
                }
            }
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Trie trie = new Trie();
        for (String word : wordDict) {
            trie.insert(word, 0);
        }
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < n; ++i) {
            if (dp[i]) {
                trie.check(s, i, dp);
            }
        }
        return dp[n];
    }
}
