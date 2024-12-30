class Solution {
    public String answerString(String word, int m) {
        if(m==1) return word;
        int n = word.length();
        int maxlen = (n-m+1);
        char max = word.charAt(0);
        String res = "";
        for(int i=0; i<n; i++) {
            if(word.charAt(i) >= max) {
                String curr = word.substring(i, Math.min(i+maxlen, n));
                if(curr.compareTo(res) > 0) res = curr;
                max = word.charAt(i);
            }
        }
        return res;
    }
}