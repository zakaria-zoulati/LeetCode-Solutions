class Solution {
    public boolean buddyStrings(String s, String goal) {
        if( s.length() != goal.length()  || s.length() == 1  ){
            return false ; 
        }
        if( s.equals(goal) ){
            int[] a = new int[26] ; 
            for( char c : s.toCharArray() ){
                if( a[c-'a'] == 1 ) return true ; 
                a[ c-'a' ]++ ; 
            }
            return false ; 
        }
        int n = s.length() ; 
        int swaps = 0 ; 
        int a = 0 ; 
        int b = 0 ; 
        for(int i=0; i<n ; ++i){
            if( s.charAt(i) != goal.charAt(i) ){
                swaps++ ; 
                if( swaps == 1 ){
                    a=i ;
                }else if( swaps == 2 ){
                    b=i ;
                }else {
                    return false ; 
                }
            }
        }
        if ( swaps == 2 && s.charAt(a) == goal.charAt(b) && s.charAt(b) == goal.charAt(a) ){
            return true; 
        }
        return false ; 
    }
}