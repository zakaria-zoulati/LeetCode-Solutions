class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length ; 
        int m = mana.length ; 
        long[] pref = new long[n] ; 
        pref[0] = skill[0] ; 
        for( int i=1 ; i<n ; ++i ){
            pref[i] = pref[i-1] + skill[i] ; 
        }
        long[] f = new long[n] ;
        long prev_t = 0 ; 
        for(int i=1 ; i<m ; ++i){
            f[0] = prev_t + mana[i-1]*pref[0] ; 
            long t = f[0] ; 
            for( int j=1 ; j<n ; ++j){
                f[j] = prev_t + mana[i-1]*pref[j] ;  
                if( t + pref[j-1]*mana[i] < f[j] ){
                    t  = f[j] - pref[j-1]*mana[i] ; 
                }
            }
            prev_t = t ; 
        }
        return prev_t + mana[m-1]*pref[n-1] ; 
    }
}