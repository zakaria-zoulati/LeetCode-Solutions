class Solution {
    public int prefixConnected(String[] words, int k) {
        int n = words.length ; 
        Map<String,Integer> m = new HashMap<>() ; 
        for( String s : words ){
                if( s.length() < k ) continue ; 
                if(m.get( s.substring( 0 , k ) ) == null ){
                    m.put( s.substring( 0 , k )  , 1 )  ; 
                }else {
                    m.put( s.substring( 0 , k )  , m.get( s.substring( 0 , k ) ) + 1 )  ; 
                }
        }
        int ans = 0 ; 
        for( Integer v : m.values() ){
            if( v >= 2 ) ans++ ; 
        }
        return ans ; 
    }
}