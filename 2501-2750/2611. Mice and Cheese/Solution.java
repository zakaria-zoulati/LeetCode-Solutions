class Solution {
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length ; 
        int ans = 0 ; 
        for( int reward : reward2 ){
            ans += reward ; 
        }
        if( k == 0 ) return ans;  
        int[] f = new int[2001] ; 
        for( int i=0 ; i<n ; ++i ){
            f[ reward1[i] - reward2[i] + 1000 ]++ ; 
        }
        int in = 2000 ; 
        while( k > 0 ){
            if( f[in] == 0 ){
                in-- ; 
            }else {
                ans += in - 1000 ; 
                k-- ; 
                f[in]-- ; 
            }
        }
        return ans ; 
    }
}