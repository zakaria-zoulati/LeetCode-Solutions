import java.util.* ; 
class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length() ; 
        List<Integer> rs = new ArrayList<>() ;
        int[] all = new int[26] ; 
        int start = 0 ; 
        int end = 0 ; 
        for(int i=0 ; i<n ; ++i){
            all[ s.charAt(i) - 'a' ] = i ; 
        }
        for(int i=0 ; i<n ; ++i){
            end = Math.max( all[ s.charAt(i) - 'a' ] ,  end ) ; 
            if( i == end ){
                rs.add( end - start + 1 ) ; 
                start = i+1 ; 
            }
        }
        return rs ; 
    }
}