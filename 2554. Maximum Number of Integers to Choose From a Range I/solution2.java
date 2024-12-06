class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int b = banned.length ; // The length of The banned array
        boolean[] f = new boolean[n+1] ;  
        int len = n ; 
        for( int i:banned ){
            if( i<=n && !f[i] ){
                f[i] = true ; 
                len--; 
            }    
        }
        if( len == 0 ) return  0 ; 
        int[] rs = new int[len] ;  
        int j=0 ; // The pointer in The result array 
        for( int i=1 ; i<=n ; ++i ){
           if( !f[i] ){
                rs[j++] = i ; 
           }
        }

        // Do a simple prefix sum 
        for( int i=1 ; i<len ; ++i ){
            rs[i] += rs[i-1] ; 
        }

        // Do a simple Binary search 
        int left = 0 ; 
        int right = len -1  ; 
        while( left <= right ){
            int mid = left + (right - left)/2 ; 
            if( rs[mid] == maxSum ){
                return mid + 1  ;
            }else if( rs[mid] > maxSum ){
                right = mid - 1 ; 
            }else {
                left = mid + 1  ; 
            }
        }
        return left ; 
    }
}