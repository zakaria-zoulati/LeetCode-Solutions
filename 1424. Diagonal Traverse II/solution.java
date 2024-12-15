class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        int n = nums.size() ; 
        int len = 0 ; 
        for( List<Integer> l : nums ){
            len += l.size() ; 
        }
        int[] rs = new int[len] ; 
        PriorityQueue< int[] > pq = new PriorityQueue<>(
            (a,b) -> {
                int x = a[0] + a[1]; 
                int y = b[0] + b[1] ; 
                if( x > y ){
                    return 1 ; 
                }else if( x < y ){
                    return -1 ; 
                }else {
                    return a[0] < b[0] ? 1 : -1  ; 
                }
            }
        ); 
        for( int i=0 ; i<n ; ++i ){
            for( int j=0 ; j<nums.get(i).size() ; ++j ){
                pq.add( new int[]{ i , j , nums.get(i).get(j) } ) ; 
            }
        }

        int i=0 ; 
        while( !pq.isEmpty() ){
            rs[ i++ ] = pq.poll()[2] ; 
        }
        return rs ; 
    }
}