class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        int n = classes.length ; 
        PriorityQueue< int[] > pq = new PriorityQueue<>(
            (a,b) -> Double.compare( (double) (b[0]+1)/(b[1]+1) - (double) b[0]/b[1] , (double) (a[0]+1)/(a[1]+1) - (double) a[0]/a[1]  ) 
        ); 
        for( int[] i : classes ){
            pq.add(i) ; 
        } 
        while( extraStudents-- > 0 ){
            int[] w = pq.poll() ; 
            w[0]++ ; 
            w[1]++ ; 
            pq.add(w) ; 
        }
        double curr = 0 ;  
        while( !pq.isEmpty() ){
            int[] cu = pq.poll() ; 
            curr += (double) cu[0]/cu[1] ; 
        }
        curr /= n ; 
        return curr ; 
    }
}