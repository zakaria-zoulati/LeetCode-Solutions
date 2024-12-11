class Solution {
    public int maximumBeauty(int[] nums, int k) {
        int n = nums.length ; 
        int max = 0 ; 
        for(int i : nums ){
            max = Math.max( max, i ) ; 
        }
        int[] pref = new int[max+1] ; 
        int rs = 1 ; 
        for(int i : nums){
            pref[i]++ ; 
        }
        for(int i=1 ; i<=max ; ++i){
            pref[i] += pref[i-1]; 
        }
        int i=0 ; 
        while( pref[i]==0) ++i ;  
        if( max-i+1 <= 2*k){
            return pref[max] ;            
        }
        int win=pref[i+2*k] ; 
        rs = Math.max(rs , win); 
        ++i ; 
        for( ;i+2*k <= max ; ++i ){
            win = pref[i+2*k]-pref[i-1] ; 
            rs = Math.max(rs , win);  
        }
        return rs ; 
    }
}