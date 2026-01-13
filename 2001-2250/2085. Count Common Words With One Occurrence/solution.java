class Solution {
    public int countWords(String[] words1, String[] words2) {
        HashMap<String , int[] > map = new HashMap<>() ; 
        int i = 0 ; 
        int rs = 0 ;  
        for( String item : words1 ){
            if( map.get( item ) == null )
                map.put( item , new int[]{ i , i , -1 , -1 } ) ; 
            else {
                map.get( item )[1] = i ; 
            }
            i++ ; 
        }
        i = 0; 
        for( String item : words2 ){
            if( map.get( item ) == null || map.get(item)[0] != map.get(item)[1] ) continue ; 
            if( map.get(item)[2] == -1 ){
                map.get(item)[2] = i ; 
                map.get(item)[3] = i ; 
            }else {
                map.get(item)[3] = i ;  
            }
            i++  ;
        }
        for( String item : map.keySet() ){
            if( map.get( item )[2] != -1 && map.get(item)[2] == map.get(item)[3] ) rs++ ; 
        }
        return rs ; 
    }
}