class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {
        int n = s1.length() ; 
        int[] f1 = new int[26] ; 
        int[] f2 = new int[26] ; 
        for( int i=0 ; i<n ; ++i ){
            f1[ s1.charAt(i) - 'a' ]++ ; 
            f2[ s2.charAt(i) - 'a' ]++ ; 
        }
        return check( f1 , f2 ) || check( f2 , f1 ) ; 
    }
    public boolean check( int[] a , int[] b ){  
        int diff = 0 ; 
        for(int i=0 ; i<26 ; ++i){   
            diff += a[i] ; 
            if( b[i] == 0 ) continue ; 
            if( diff  < b[i] ) return false ; 
            diff -= b[i] ; 
        }
        return true ; 
    }
}