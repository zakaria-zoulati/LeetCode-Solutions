class Solution {
    public int sumCounts(List<Integer> nums) {
        int rs = 0 ; 
        int n = nums.size() ; 
        for(int i=0 ; i<n ; ++i){
            HashSet<Integer> set = new HashSet<>();
            set.add( nums.get(i) ) ; 
            rs++ ; 
            for(int j=i+1 ; j<n ; ++j){
                set.add( nums.get(j) ) ; 
                rs += set.size()*set.size() ; 
            }
        }
        return rs ; 
    }
}