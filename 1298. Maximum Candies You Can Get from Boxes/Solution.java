import java.util.*;

class Solution {
    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int n = status.length ; 
        boolean[] isSeen = new boolean[n] ; 
        Queue<Integer> q = new ArrayDeque<>() ; 
        int rs = 0 ; 
        for( int curr : initialBoxes ){
            isSeen[curr] = true ; 
            if( status[curr] == 1 ){
                q.add(curr) ; 
                rs += candies[curr] ; 
            }
        }
        while( !q.isEmpty() ){
            int curr = q.poll() ;  
            for( int i : keys[curr] ){
                if( status[i] == 1 ) continue ; 
                status[i] = 1 ; 
                if( isSeen[i]  ){
                    q.add(i) ; 
                    rs += candies[i] ; 
                }
            }
            for( int i : containedBoxes[curr] ){
                if( isSeen[i] ) continue ; 
                isSeen[i] = true ; 
                if( status[i] == 1 ){
                    q.add(i) ; 
                    rs += candies[i] ; 
                }
            }
        }
        return rs ; 
    }
}