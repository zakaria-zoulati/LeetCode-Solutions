class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int n = arr.length ; 
        int[] sec = arr.clone() ; 
        Arrays.sort( sec ) ;
        HashMap<Integer,Integer> map = new HashMap<>() ; 
        int rank = 1 ; 
        for(int i=0 ; i<n ; ++i){
            while( i+1<n && sec[i+1] == sec[i] ){
                i++ ; 
            }
            map.put( sec[i] , rank++ ) ; 
        } 

        for(int i=0 ; i<n ; ++i){
            arr[i] = map.get( arr[i] ) ; 
        }

        return arr ; 

    }
}