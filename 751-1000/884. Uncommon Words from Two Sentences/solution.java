class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
       HashMap< String , Integer > map = new HashMap<>()  ;
       int count = 0 ; 
       for( String item : s1.split(" ") ){
            Integer c = map.get(item) ; 
            if( c == null ){
                map.put( item , 1 ) ;
                count++; 
            }
            else if( c == 1 ){
                map.put( item , 2 ) ; 
                count-- ; 
            }
       }

       for( String item : s2.split(" ") ){
            Integer c = map.get(item) ; 
            if( c == null ){
                map.put( item , 1 ) ;
                count++; 
            }
            else if( c == 1 ){
                map.put( item , 2 ) ; 
                count-- ; 
            }
       }

       String[] rs = new String[count] ; 
       int p = 0 ;  
       for( String item : map.keySet() ){
            if( map.get(item) == 1 ){
                rs[p++] = item ; 
            }
       }

       return rs ; 
        
    }
}