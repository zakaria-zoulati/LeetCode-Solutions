class Solution {
    boolean check( int ans ){
        int[] f = new int[10] ; 
        while( ans > 0 ) {
            f[ans%10]++ ; 
            ans /= 10 ; 
        }
        if( f[0] > 0 ) return false ;  
        for( int i=1 ; i<10 ; ++i ){
            if( f[i] > 0 &&  f[i] != i ) return false ; 
        }
        return true ; 
    }
    public int nextBeautifulNumber(int n) {
        if( n == 0 ) return 1 ; 
        else if( n == 1 || n < 22 ) return 22 ; 
        if( n >= 55_555 && n < 1_22_333 ) return 1_22_333 ; 
        if( n >= 666_666  ) return 1_22_4444 ; 
        if( n >= 555_551 ) return 666_666 ; 
        if( n >= 555_515 ) return 555_551 ; 
        if( n >= 555_155 ) return 555_515 ; 
        if( n >= 551_555 ) return 555_155 ; 
        if( n >= 515_555 ) return 551_555 ; 
        if( n >= 4444_22 ) return 515_555 ; 
        if( n >= 4442_42 ) return 4444_22 ;
        if( n >= 4442_24 ) return 4442_42 ; 
        if( n >= 442_442 ) return 4442_24 ; 
        if( n >= 442_424 ) return 442_442 ; 
        if( n >= 442_244 ) return 442_424 ; 
        if( n >= 424_442 ) return 442_244 ; 
        if( n >= 424_424 ) return 424_442 ; 
        if( n >= 424_244 ) return 424_424 ; 
        if( n >= 422_444 ) return 424_244 ; 
        if( n >= 333_221 ) return 422_444 ; 
        int ans = n+1 ;  
        while( !check(ans) ) ans++ ; 
        return ans ; 
    }
}