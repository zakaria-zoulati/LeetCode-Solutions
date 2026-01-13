class Solution {
    public int numSplits(String s) {
        int[] R=new int[26];
        int[] L=new int[26];
        int cr=0, cl=0,rs=0;
        for(char c:s.toCharArray()) {
            if (++R[c-'a']==1) {
                ++cr;
            }
        }
        for(char c:s.toCharArray()) {
            if (++L[c-'a']==1) {
                ++cl;
            }
            if (--R[c-'a']==0) {
                --cr;
            }
            if (cr==cl) {
                ++rs;
            }
        }
        return rs;
    }
}