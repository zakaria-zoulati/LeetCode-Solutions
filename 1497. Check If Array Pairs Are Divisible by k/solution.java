class Solution {
    public boolean canArrange(int[] arr, int k) {
        if( k == 1 ) return true ; 
        int[] freq = new int[k] ;
        for(int num : arr){
            while( num < 0 ){
                num += 10000*k  ; 
            }
            freq[ ( num % k) ]++ ; 
        }
        if( freq[0] % 2 != 0  ) return false ; 
        int left = 1 ; 
        int right = k-1 ; 
        while( left < right ){
            if( (freq[right] !=  freq[left])   ){
                return false ;
            }
            left++ ; 
            right-- ; 
        }
        if( left == right && freq[left] % 2 != 0 ){
            return false ;
        }

        return true ; 
    }
}