class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int e , int f, int c , int d) {
       if( a == c ){
            if( e != a ) return 1 ; 
            if( f < Math.min( b , d ) || f > Math.max( b ,d ) ) return 1 ;
       }else if( b == d ){
            if( f != b ) return 1 ; 
            if( e < Math.min( a , c ) || e > Math.max( a , c ) ) return 1 ;  
       }else if( Math.abs( e - c ) == Math.abs( f - d ) ){
            if( Math.abs( a - e ) != Math.abs( b - f ) ) return 1; 
            int x = ( e - c )/( f - d ) ; 
            int y = ( e - a )/( f - b ) ; 
            if( x != y ) return 1 ; 
            if( a < Math.min( c,e ) || a > Math.max( c ,e ) ) return 1 ; 
       }
       return 2 ; 
    }
}