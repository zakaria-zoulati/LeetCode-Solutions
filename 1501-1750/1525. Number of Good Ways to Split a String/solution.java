class Solution {
    public int numSplits(String s) {
        int n =s.length(); 
        int[] f =new int[26]; 
        int b =0;
        for (char c : s.toCharArray()) {
            ++f[c-'a']; 
            b |= 1<<(c -'a'); 
        }
        int rs=0; 
        int c=0; 
        for (int i=0;i<n;++i) {
            int in = s.charAt(i)-'a'; 
            c |=(1<<in); 
            --f[in]; 
            if (f[in]==0) {
                b ^=(1<<in); 
            }
            if(Integer.bitCount(c)==Integer.bitCount(b)) ++rs; 
        } 
        return rs; 
    }
}
