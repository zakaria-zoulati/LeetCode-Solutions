import java.util.*;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] arr) {
        HashMap<String, Integer> map = new HashMap<>();
        for (int[] row : arr) {
            StringBuilder in = new StringBuilder();
            int f = row[0];
            for (int val : row) {
                in.append(val == f ? '1' : '0');
            }
            String key = in.toString();
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int rs = 0 ; 
        for( Integer in : map.values() ){
            rs = Math.max( rs , in ) ; 
        }
        return rs ; 
    }
}
