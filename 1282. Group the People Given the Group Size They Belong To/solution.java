class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        List<List<Integer>> rs = new ArrayList<>() ; 
        int n = groupSizes.length ; 
        ArrayList<Integer>[] inter = new ArrayList[n+1] ; 
        for(int i=0 ;i<n ; ++i){
            if( inter[ groupSizes[i] ]   == null ){
                inter[ groupSizes[i] ] = new ArrayList<>()  ; 
            }
            inter[ groupSizes[i] ].add(i) ;
            if( inter[ groupSizes[i] ].size() == groupSizes[i] ){
                rs.add( inter[ groupSizes[i] ] )  ;
                inter[ groupSizes[i] ] = null  ; 
            }
        }
        return rs ; 
    }
}