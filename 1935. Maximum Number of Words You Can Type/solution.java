class Solution {
    public int canBeTypedWords(String text, String brokenLetters) {
        int n = text.length() ; 
        boolean[] check = new boolean[26] ; 
        for( char c : brokenLetters.toCharArray() ){
            check[ c - 'a' ] = true ; 
        }
        int rs = 0 ;
        for(int i=0 ; i<n ; ++i){
            boolean flag = true ; 
            if( check[ text.charAt(i) - 'a' ] ){
                    flag = false ; 
            }
            while( i+1<n && text.charAt(i+1) != ' '){
                ++i ; 
                if( flag && check[ text.charAt(i) - 'a' ] ){
                    flag = false ; 
                }
            }
            if( flag ) rs++ ; 
            i++ ; 
        }

        return rs  ;

    }
}