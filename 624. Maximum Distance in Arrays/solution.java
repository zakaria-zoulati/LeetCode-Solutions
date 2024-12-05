import java.util.*; 
class Solution {
    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size() ; 
        int rs = 0 ; 
        PriorityQueue<int[]> p1 = new PriorityQueue<>(  
            (a,b) -> b[1] - a[1]  // To return The maximum element
        );
        PriorityQueue<int[]> p2 = new PriorityQueue<>(  
            (a,b) -> a[0] - b[0] 
        );
        int i=0 ; 
        for( List<Integer> l : arrays  ){
            p1.add( new int[]{ l.get(0) , l.get( l.size() - 1 ) , i } ) ; 
            p2.add( new int[]{ l.get(0) , l.get( l.size() - 1 ) , i++ } ) ; 
        }
        int[] a = p1.poll() ; 
        int[] b = p2.poll() ; 
        if( a[2] != b[2] ){
            return a[1] - b[0] ; 
        }else {
            int[] a1 = p1.poll() ; 
            int[] b1 = p2.poll() ; 
            return Math.max( a[1] - b1[0] , a1[1] - b[0] ) ; 
        }
    }
}