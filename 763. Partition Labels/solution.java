class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length() ; 
        List<Integer> rs = new ArrayList<>() ;
        int start = 0 ; 
        int end = s.lastIndexOf( s.charAt(0) ) ; 
        for( int i= start; i<n ; ++i ){
            if( i == end ){
                rs.add( end - start + 1) ; 
                if( i+1<n ){
                    start = i+1 ; 
                    end = s.lastIndexOf( s.charAt( i+1 ) ) ; 
                }
                continue ; 
            }
            end = Math.max( end , s.lastIndexOf( s.charAt(i) ) ) ; 
        }
        return rs ; 
    }
}