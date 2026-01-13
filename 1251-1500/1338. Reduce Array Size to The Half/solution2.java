class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length ; 
        int[] f = new int[n+1] ; 
        Arrays.sort(arr) ; 
        int count = 0 ; 
        for(int i=0 ; i<n ; ++i){
            count = 1 ;
            while( i+1 < n && arr[i+1] == arr[i] ){
                count++ ; 
                i++ ; 
            }
            f[count]++ ; 
        }
        int rs = 0 ; 
        int gone = 0 ; 
        for(int i=n ; gone < n/2 ; ){
            if( f[i] == 0 ) --i ; 
            else {
                f[i]-- ; 
                gone += i ; 
                rs++ ; 
            }
        }
        return rs ; 
    }
}