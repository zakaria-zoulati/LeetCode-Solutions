class Solution {
    public int minimizedMaximum(int n, int[] q) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b) -> b[0]/b[1] +  ( b[0] % b[1] == 0 ? 0 : 1 )-  a[0]/a[1] - (a[0] % a[1] == 0 ? 0 : 1 )
        ); 
        for(int i : q ){
            pq.add( new int[]{i,1} ) ; 
        }
        int cu = q.length ; 
        while( cu < n ){
            int[] b = pq.poll() ; 
            b[1]++;  
            pq.add(b) ; 
            cu++ ; 
        }
        int[] rs = pq.poll() ; 
        int res = rs[0]/rs[1] + ( rs[0] % rs[1] == 0 ? 0 : 1 ) ; 
        return res ; 
    }
}