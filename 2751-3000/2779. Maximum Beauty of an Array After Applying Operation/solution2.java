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
            ++pref[i] ; 
        }
        for(int i=1 ; i<=max ; ++i){
            pref[i] += pref[i-1] ; 
        }
        if( max <= 2*k ){
            return pref[max] ; 
        }
        int i=0 ; 
        while(pref[i]==0) ++i ;  
        rs = pref[ i+k <=max ? i+k : max ] ; 
        i += k ; 
        rs = Math.max( rs ,  -( i>k ? pref[i-k-1] : 0  ) + pref[ ( i+k <=max ? i+k : max )]  ) ; 
        ++i ; 
        for( ; i+k<=max ; ++i ){
            int cu = -pref[i-k-1]  + pref[ i+k ]   ;
            rs = Math.max( rs , cu ) ; 
        }
        return rs ; 
    }
}