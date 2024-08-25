class Solution {
    public boolean equalFrequency(String word) {
        HashSet<Integer> set = new HashSet<>() ; 
        int[] freq = new int[26] ;  
        for( char c : word.toCharArray() ){
            freq[ c - 'a' ]++ ; 
        }
        ok:for( int i=0 ; i<26 ; ++i ){
            if( freq[i] == 0 ) continue ;
            freq[i]--; 
            int a = -1 ; 
            for( int num : freq ){
                if( num == 0 ) continue ;
                else if( a==-1 ) a=num ;
                else {
                    if( a != num ) {
                        freq[i]++ ; 
                        continue ok; 
                    }
                }
            }
            return true ; 
        }
        return false ; 
        
    }
}