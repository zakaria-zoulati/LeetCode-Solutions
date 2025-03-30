import java.util.* ; 
class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length() ; 
        char[] chars = s.toCharArray() ; 
        int[] max = new int[26] ; 
        for( int i=0 ; i<n ; ++i ){
            max[ chars[i] - 'a' ] = i ; 
        }
        List<Integer> rs = new ArrayList<>() ; 
        for( int i=0 ; i<n ; ++i ){
            int start = i ; 
            int end = max[ chars[i] - 'a' ] ; 
            while( i < end ){
                i++ ; 
                end = Math.max( end , max[ chars[i] - 'a' ] ) ; 
            }
            rs.add( end - start + 1 ) ; 
        }
        return rs ; 
    }
}