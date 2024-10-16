class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>() ; 
        int n = nums.length ; 
        for(int i=0 ; i<n ;++i){
            StringBuilder rs = new StringBuilder() ; 
            rs.append( nums[i] ) ; 
            boolean flag = false ; 
            int last = -1 ; 
            while( i+1 < n && nums[i+1] == nums[i]+1 ){
                ++i ; 
                flag = true ; 
                last = nums[i] ; 
            }
            if( flag ){
                rs.append( "->" ) ; 
                rs.append(last) ; 
            }
            list.add( rs.toString() ) ; 
        }
        return list ; 
    }
}