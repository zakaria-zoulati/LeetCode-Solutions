class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length ; 
        Arrays.sort(nums) ; 
        int curr = 0 ; 
        PriorityQueue< int[] > pq = new PriorityQueue<>( (a,b ) -> b[1] - a[1] ) ; 
        for(int i=0 ; i<n ; ++i){
            curr++  ;
            while( i+1 <n && nums[i+1] == nums[i]  ){
                i++ ; curr++; 
            }
            pq.add( new int[]{ nums[i] , curr } ) ; 
            curr = 0 ;
        }
        int[] rs = new int[k] ; 
        for(int i=0 ; i<k ;  ++i){
            rs[i] = pq.poll()[0] ; 
        }

        return rs ; 

    }
}