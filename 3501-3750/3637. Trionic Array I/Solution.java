class Solution {
    public boolean isTrionic(int[] arr) {
        int n = arr.length ; 
        for( int i=1 ; i<n ; ++i ){
            if( arr[i] == arr[i-1] ) return false ; 
        }
        int i=0 ; 
        int j=n-1 ; 
        while( i+1<n && arr[i+1] > arr[i] ) i++ ; 
        if( i == n-1 || i==0 ) return false ; 
        while( arr[j-1] < arr[j] ) j-- ; 
        if( j == n-1 ) return false ; 
        while( i< j ){
            if( arr[i+1] > arr[i] ) return false ; 
            i++ ; 
        }
        return true ; 
    }
}