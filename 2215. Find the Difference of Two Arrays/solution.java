class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List< List<Integer>> rs = new ArrayList<>() ; 
        List<Integer> l1 = new ArrayList<>() ;
        List<Integer> l2 = new ArrayList<>() ;
        boolean[] freq1 = new boolean[2001] ; 
        boolean[] freq2 = new boolean[2001] ; 
        for(int i : nums1 ){
            freq1[i+1000] = true  ;
        }
        for(int i : nums2 ){
           freq2[i+1000] = true ; 
        }
        for(int i = 0 ; i< 2001 ; ++i ){
            if( freq1[i] && !freq2[i] ){
                l1.add( i-1000 ) ; 
            }
            else if( freq2[i] && !freq1[i] ){
                l2.add( i-1000 ) ;
            }
        } 

        rs.add( l1 ) ; 
        rs.add( l2 ) ;

        return rs ;  
    }
}