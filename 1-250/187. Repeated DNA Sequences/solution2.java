class Solution {
    public int val( char c ){
        if( c == 'A' ){
            return 0 ; 
        }else if( c == 'C' ){
            return 1 ;
        }else if( c == 'G' ){
            return 2 ; 
        }else {
            return 3 ; 
        }
    }
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> list = new ArrayList<>() ;
        int n = s.length() ; 
        if( n <= 10 ){
            return list ; 
        } 
        HashMap< Integer , int[] > map = new HashMap<>() ; 
        int first = 0 ; 
        for(int i=0 ; i<10 ; ++i){
            first += val( s.charAt(i)) * Math.pow( 5 , i ) ; 
        }
        map.put( first , new int[]{0,0} ) ; 

        for(int i=1 ; i+10 <=n ; ++i){
            first -= val( s.charAt(i-1) ) ; 
            first /= 5 ; 
            first += val( s.charAt(i+9) )*Math.pow(5,9) ; 
            if( map.get(first) == null ){
                map.put( first , new int[]{i,0} ) ; 
            }else if( map.get(first)[1] == 0 ){
                list.add( s.substring( map.get(first)[0] , map.get(first)[0] + 10 ) ) ; 
                map.get( first )[1] = 1  ;
            }
        }   
        return list ; 

    }
}