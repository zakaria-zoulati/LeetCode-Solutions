class Solution {
    public long minTime(int[] skill, int[] mana) {
        int n = skill.length ; 
        int m = mana.length ; 
        long[] pref = new long[n] ; 
        pref[0] = skill[0] ; 
        for( int i=1 ; i<n ; ++i ){
            pref[i] = pref[i-1] + skill[i] ; 
        }
        long prev_t = 0 ; 
        long prev = -1 ; 
        for(int i=1 ; i<m ; ++i){
            prev = prev_t + mana[i-1]*pref[0] ;
            long t = prev ;  
            for( int j=1 ; j<n ; ++j){
                prev = prev_t + mana[i-1]*pref[j] ;  
                long curr = prev - pref[j-1]*mana[i] ; 
                if( t < curr ){
                    t  = curr ; 
                }
            }
            prev_t = t ; 
        }
        long ans = prev_t + mana[m-1]*pref[n-1]  ; 
        return ans ; 
    }
}