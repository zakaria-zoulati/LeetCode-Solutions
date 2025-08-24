class Solution {
    public int[] maxValue(int[] nums) {
        int n = nums.length;
        int[] rs = new int[n];
        int[] prefixMax = new int[n] ; 
        int[] suffixMin = new int[n] ; 
        prefixMax[0] = 0 ; 
        suffixMin[n-1] = nums[n-1] ;
        for( int i=1 ; i<n ; ++i ){
            if( nums[i] > nums[ prefixMax[i-1] ] ){
                prefixMax[i] = i ; 
            }else {
                prefixMax[i] = prefixMax[i-1] ; 
            }
        }
        for( int i=n-2 ; i>=0 ; --i ){
            suffixMin[i] = Math.min( suffixMin[i+1] , nums[i] ) ; 
        }
        for( int i=n-1 ; i>=0 ; --i ){ 
            rs[i] = nums[i] ; 
            if( i+1<n && suffixMin[i+1] < nums[i] ){
                int l = i+1 ; 
                int r = n-1 ; 
                while( l< r ){
                    int mid = l+(r-l+1)/2 ; 
                    if( suffixMin[mid] < nums[i] ){
                        l = mid  ; 
                    }else {
                        r = mid - 1 ;
                    }
                }
                rs[i] = Math.max( rs[i] , rs[prefixMax[l]] ) ; 

            }
        }
        for( int i=1 ; i<n ; ++i ){
            if( prefixMax[i] != i  ){
                rs[i] = Math.max( rs[i] , rs[ prefixMax[i] ] ) ; 
            }
        }
        return rs;
    }
}