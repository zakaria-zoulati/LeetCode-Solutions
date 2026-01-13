class Solution {
    public List<String> printVertically(String s) {
        String[] all = s.split( " " ) ; 
        int n = all.length ; 
        List<String> list = new ArrayList<>() ; 
        int max = 0 ; 
        for( String item : all ){
            max = Math.max( max , item.length() ) ; 
        }
        for( int i=0 ; i<max ; ++i ){
            StringBuilder rs = new StringBuilder() ; 
            int cache = 0 ; 
            for( String item : all ){
                if( item.length() -1 < i ){
                    cache++ ; 
                }else{
                    for( int j=0 ; j<cache ; ++j ){
                        rs.append( " " ) ; 
                    }
                    cache = 0 ; 
                    rs.append( item.charAt(i) ) ; 
                }
            }
            list.add( rs.toString() ) ; 
        }
        return list ; 
    }
}