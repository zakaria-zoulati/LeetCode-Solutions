class Solution {
    static String[] rows = new String[]{ 
        "qwertyuiopQWERTYUIOP" , "asdfghjklASDFGHJKL" , "zxcvbnmZXCVBNM"
    } ;
    public boolean check( String w ){
        for( String row : rows ){
            int count = 0 ; 
            for( char c : w.toCharArray() ){
                if( row.indexOf( c ) == -1 ){
                    break ;
                }
                count++ ; 
            }
            if( count == w.length() ) return true ; 
        }
        return false ; 
    }
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>() ; 
        for( String w : words ){
            if( check( w ) ){
                list.add( w ) ; 
            }
        }
        String[] ans = new String[ list.size() ] ; 
        for( int i=0 ; i<list.size() ; ++i ){
            ans[i] = list.get(i) ; 
        }
        return ans ; 
    }
}