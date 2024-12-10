class Solution {
    public int[] dailyTemperatures(int[] t) {
        int n = t.length ; 
        int[] rs = new int[n] ; 
        int[] s = new int[n] ; 
        int in = -1 ;  
        s[++in] = n-1 ; 
        for( int i=n-2 ; i>=0 ; --i ){
            while( in != -1 && t[i] >= t[s[in]] ) --in ; 
            if( in != -1 ){
                rs[i] = s[in] - i ; 
            }
            s[++in] = i ; 
        }
        return rs ; 
    }
}