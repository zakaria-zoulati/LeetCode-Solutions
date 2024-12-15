class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = nums.size() ; 
        int len = 0 ; 
        for( List<Integer> l : nums ){
            len += l.size() ; 
        }
        int[] rs = new int[len] ; 
        PriorityQueue< int[] > pq = new PriorityQueue<>(
            (a,b) -> a[1]==b[1] ? b[0] - a[0] : a[1] - b[1]
        ); 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<nums.get(i).size() ; ++j ){
                pq.add( new int[]{ i , i+j }) ; 
            }
        }
        int i=0 ; 
        while( !pq.isEmpty() ){
            int[] cu = pq.poll() ; 
            rs[i++] = nums.get( cu[0] ).get( cu[1] - cu[0] ) ; 
        }
        return rs ; 
    }
}