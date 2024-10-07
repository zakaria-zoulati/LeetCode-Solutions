class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] rs = new int[k][2] ; 
        int n = points.length ; 
        PriorityQueue<int[]> q = new PriorityQueue<>( (a,b) -> ( -a[0]*a[0] - a[1]*a[1] + b[0]*b[0] + b[1]*b[1] )) ; 
        for(int[] pt : points ){
            if( q.size() < k  ){
                q.add( pt ) ; 
            }else {
                int a = q.peek()[0] ; 
                int b = q.peek()[1] ; 
                int d1 = a*a + b*b ; 
                int d2 = pt[0]*pt[0] + pt[1]*pt[1] ;
                if( d1 > d2 ){
                    q.poll() ; 
                    q.add( pt ) ; 
                }
            }
        }
        int i=0; 
        while( !q.isEmpty() ){
            rs[i++] = q.poll() ; 
        }
        return rs ; 
    }
}