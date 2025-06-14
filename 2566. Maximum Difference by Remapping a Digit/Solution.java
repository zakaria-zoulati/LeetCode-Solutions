class Solution {
    public int minMaxDifference(int num) {
        int copy = num ; 
        int len = 0 ; 
        while( copy > 0 ){
            copy /= 10 ; 
            len++ ; 
        }
        int[] arr = new int[len] ; 
        int in = len-1 ; 
        copy = num ; 
        while( copy > 0 ){
            arr[in--] = copy%10 ; 
            copy /= 10; 
        }
        int max = 0  ; 
        in = 0 ;
        while( in < len && arr[in] == 9 ) {
            max = max*10 + 9 ; 
            in++ ; 
        }
        if( in<len ){
            int remp = arr[in] ; 
            while( in < len ){
                max = max*10 + ( arr[in] == remp ? 9 : arr[in] ) ; 
                in++ ; 
            }
        }
        int min = 0 ;  
        int remp = arr[0] ; 
        for( int i=0 ; i<len ; ++i ){
            min = min*10 + ( arr[i] == remp ? 0 : arr[i] ) ; 
        }
        return max - min; 
    }
}