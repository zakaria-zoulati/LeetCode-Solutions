class Solution {
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<>() ;
        int n = words.length ; 
        String[] chars = new String[26] ; 
        int current = 0 ; 
        chars[current++] = ".-"  ;
        chars[current++] = "-..."  ;
        chars[current++] = "-.-."  ;
        chars[current++] = "-.."  ;
        chars[current++] = "."  ;
        chars[current++] = "..-."  ;
        chars[current++] = "--."  ;
        chars[current++] = "...."  ;
        chars[current++] = ".."  ;
        chars[current++] = ".---" ;
        chars[current++] = "-.-"  ;
        chars[current++] = ".-.."  ;
        chars[current++] = "--"  ;
        chars[current++] = "-."  ;
        chars[current++] = "---"  ;
        chars[current++] = ".--."  ;
        chars[current++] = "--.-"  ;
        chars[current++] = ".-."  ;
        chars[current++] = "..."  ;
        chars[current++] = "-"  ;
        chars[current++] = "..-"  ;
        chars[current++] = "...-"  ;
        chars[current++] = ".--" ;
        chars[current++] = "-..-"  ;
        chars[current++] = "-.--"  ;
        chars[current++] = "--.."  ;

        for( String item : words  ){
            StringBuilder rs = new StringBuilder() ; 
            for( char c : item.toCharArray() ){
                rs.append( chars[ c-'a' ] ) ; 
            }
            set.add( rs.toString() ) ;
        }
        return set.size() ;
    }
}