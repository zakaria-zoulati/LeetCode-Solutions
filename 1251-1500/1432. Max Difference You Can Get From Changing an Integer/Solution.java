class Solution {
    public int maxDiff(int num) {
        int copy = num ; 
        int len = 0 ;
        while( copy > 0 ){
            len++ ; 
            copy /= 10 ;
        }
        int[] rep = new int[len] ; 
        copy = num ; 
        int in = 0 ; 
        while( copy > 0 ){
            rep[in++] = copy%10 ; 
            copy /= 10 ; 
        }
        int max = 0 ; 
        in = len-1 ; 
        while( in>=0 && rep[in] == 9 ) in-- ;
        if( in == -1 ){
            max = num ; 
        }else {
            int ele = rep[in] ; 
            for( int i=len-1 ; i>=0 ; --i ){
                max = max*10 + ( rep[i] == ele ? 9 : rep[i] ) ; 
            }
        }
        int min = 0 ;   
        in = len-1 ; 
        while( in>=0 && rep[in] == 1 ) in-- ;
        if( in == -1 ){
            min = num ; 
        }else if(in == len-1) {
            int ele = rep[len-1] ; 
            for( int i=len-1 ; i>=0 ; --i ){
                min = min*10 + ( rep[i] == ele ? 1 : rep[i] ) ; 
            }
        }else {
            while( in >= 0 && rep[in] <= 1 ) --in ;
            if( in < 0 ) {
                min = num ; 
            }else {
                int ele = rep[in] ; 
                for( int i=len-1 ; i>=0 ; --i ){
                    min = min*10 + ( rep[i] == ele ? 0 : rep[i] ) ; 
                }
            }
        }
        int rs = max - min ;
        return rs ; 
    }
}