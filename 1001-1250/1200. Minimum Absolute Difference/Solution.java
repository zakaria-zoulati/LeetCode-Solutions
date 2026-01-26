import java.util.* ; 

class Solution {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        Arrays.sort( arr ) ; 
        List<List<Integer>> ans = new ArrayList<>() ; 

        int diff = Integer.MAX_VALUE ; 
        for( int i=1 ; i<arr.length ; ++i ){
            diff = Math.min( diff , arr[i] - arr[i-1] ) ; 
        }

        for( int i=1 ; i<arr.length ; ++i ){
            if( arr[i] - arr[i-1] == diff ){
                List<Integer> curr = new ArrayList<>() ; 
                curr.add( arr[i-1] ) ; 
                curr.add( arr[i] ) ; 
                ans.add( curr) ; 
            }
        }

        return ans ; 
    }
}