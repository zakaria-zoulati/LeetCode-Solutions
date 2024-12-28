class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length ; 
        if( n == 1 ) return 0 ; 
        int rs = 0 ; 
        int[] back = new int[n+1] ; // The second part (tail) is optional 
        int min = arr[n-1] ; 
        int max = arr[n-1] ; 
        for( int i=n-1 ; i>1 ; --i ){
            if( arr[i] <= min ){
                min = arr[i] ; 
            }else if( arr[i] > max ) {
                max = arr[i] ; 
                min = arr[i] ; 
            }
            back[i] = Math.max( back[i+1] , max - min) ; 
        }
        int mi = arr[0] ;  
        for( int i=1 ; i<n ; ++i ){
           if( arr[i] <= mi ){
                mi = arr[i] ; 
           }else {
                rs = Math.max( arr[i] - mi + back[i+1] , rs ) ; 
           }
        }
        return rs ; 
    }
}