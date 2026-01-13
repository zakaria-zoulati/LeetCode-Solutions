class Solution {
    public boolean isItPossible(String word1, String word2) {
        int[] a = new int[26]; 
        int[] b = new int[26]; 
        int d1 = 0 ; 
        int d2 = 0 ; 
        for (char c : word1.toCharArray()) {
             a[c - 'a']++ ; 
        }
        for (char c : word2.toCharArray()) {
             b[c - 'a']++ ; 
                
        }
        for(int num : a){
            if( num > 0 ) d1++ ; 
        }
        for(int num : b){
            if( num > 0 ) d2++ ; 
        }
        int n1 = 0 ; 
        int n2 = 0 ; 
        if( Math.abs( d2-d1 ) > 2 ) return false ; 
        for (int i = 0; i < 26; i++) {
            if( a[i] == 0 ) continue ; 
            for (int j = 0; j < 26; j++) {
                if(  b[j] == 0 ) continue ; 
                if( d1!=d2 && i==j ) continue ;
                if( d1==d2 && i==j ) return true ;
                if( a[i] == 1 ) n1-- ;
                if( a[j] == 0 ) n1++ ; 
                if( b[j] == 1 ) n2-- ; 
                if( b[i] == 0  ) n2++ ;
                if( ( d1+ n1 ) == ( d2 + n2 ) ) return true; 
                n1 = 0 ; 
                n2 = 0 ;
            }
        }
        return false;
    }
}
