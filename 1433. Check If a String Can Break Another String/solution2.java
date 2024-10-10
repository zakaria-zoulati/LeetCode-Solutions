class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int[] f1 = new int[26] ; 
        int[] f2 = new int[26] ; 
        for( char c : s1.toCharArray() ){
            f1[ c - 'a' ]++ ; 
        }
        for( char c : s2.toCharArray() ){
            f2[ c - 'a' ]++ ; 
        }
        return check( f1 , f2 ) || check( f2 , f1 ) ; 
    }
    public boolean check( int[] a , int[] b ){  
        int diff = 0 ; 
        for(int i=0 ; i<26 ; ++i){   
            diff += a[i] ; 
            if( b[i] == 0 ) continue ; 
            if( diff < b[i] ) return false ; 
            diff -= b[i] ; 
        }
        return true ; 
    }
}