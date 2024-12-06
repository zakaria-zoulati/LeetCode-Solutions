class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        int b = banned.length ; // The length of The banned array
        HashSet<Integer> set = new HashSet<>() ; 
        for( int i:banned ){
            if( i<=n ){
                set.add(i) ;
            }    
        }
        int len = n - set.size() ; 
        if( len == 0 ) return  0 ; 
        int[] help = new int[len] ;  
        int j=0 ; // The pointer in The result array 
        for( int i=1 ; i<=n ; ++i ){
           if( !set.contains(i) ){
                help[j] += i ; 
                if( j+1<len ){
                    help[j+1] += help[j] ; 
                }
                ++j ; 
           }
        }

        // Do a simple Binary search 
        int left = 0 ; 
        int right = len -1  ; 
        while( left <= right ){
            int mid = left + (right - left)/2 ; 
            if( help[mid] == maxSum ){
                return mid + 1  ;
            }else if( help[mid] > maxSum ){
                right = mid - 1 ; 
            }else {
                left = mid + 1  ; 
            }
        }
        return left ; 
    }
}