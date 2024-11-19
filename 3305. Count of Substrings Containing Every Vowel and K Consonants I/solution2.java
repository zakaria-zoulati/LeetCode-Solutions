class Solution {
    public int countOfSubstrings(String word, int k) {
        int n = word.length();
        int rs = 0;
        int tar = 0; 
        boolean[] isVowel = new boolean[26];
        for (char c : "aeiou".toCharArray()) {
            isVowel[c - 'a'] = true;
            tar |= ( 1 << c-'a' ) ; 
        }
        for (int p = 0; p+4+k<n; p++) {
            int  m = 0; 
            int c = 0; 
            for (int j = p; j < n; j++) {
                char ch = word.charAt(j);
                if (isVowel[ch - 'a']) {
                    m |= (1 << ch - 'a' );
                } else {
                    ++c; 
                }
                if (c == k && m == tar) {
                    ++rs; 
                    while (j + 1 < n && isVowel[word.charAt(j + 1) - 'a']) {
                        j++;
                        ++rs;
                    }
                    break; 
                }
            }
        }
        return rs;
    }
}
