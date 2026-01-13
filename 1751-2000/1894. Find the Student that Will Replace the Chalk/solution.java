class Solution {
    public int chalkReplacer(int[] chalk, int k) {
        int n = chalk.length ; 
        long[] cha = new long[n] ; 
        int curr = 0 ;
        for(int num : chalk ){
            cha[ curr++ ] = num ; 
        }
        for(int i=1 ; i<n ; ++i ){
            cha[i] += cha[i-1] ; 
        }
        if( cha[n-1] % k == 0 ) return 0  ; 
        long inter = k % cha[n-1] ; 
        int left  = 0  ;
        int right = n-1 ; 
        while( left < right ){
            int mi = left + ( right - left )/2  ; 
            if( cha[mi] <= inter ){
                left = mi+1  ;
            }else {
                right = mi ;
            }
        }
        return right ;
    }
}