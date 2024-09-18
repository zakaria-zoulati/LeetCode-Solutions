class Solution {
    public long smallestNumber(long num) {
        if( num == 0L  ) return 0 ; 
        int[] all = new int[10] ; 
        String inter =  String.valueOf( num ) ; 
        for( char c : inter.toCharArray() ){
            if( c != '-' ){
                all[ c - '0' ]++ ;
            }
        }
        if( num < 0L ){
            long rs = 0L ; 
            for(int i=9 ; i>=0 ; --i){
                while( all[i]-- > 0 ){
                    rs = rs*10 + i ; 
                }
            }
            return -rs ; 
        }
        long rs = 0L ; 
        boolean flag = ( all[0] != 0 ) ; 
        for(int i=1 ; i<=9 ; ++i){
            if( all[i] > 0 && flag ){
                rs = i ; 
                all[i]-- ; 
                while( all[0]-- > 0 ){
                    rs *= 10 ; 
                }
                while( all[i]-- > 0 ){
                    rs = rs*10 + i ; 
                }
                flag = false ;
            }else {
                while( all[i]-- > 0 ){
                    rs = rs*10 + i ; 
                }
            }
        }
        return rs ; 
    }
}