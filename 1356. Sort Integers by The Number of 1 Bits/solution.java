class Solution {
    public int count(int n){
        int rs  = 0 ; 
        while( n!= 0 ){
            if( ( n & 1 ) == 1 ){
                rs++ ;
            }
            n >>= 1 ; 
        }
        return rs ; 
    }
    public int[] sortByBits(int[] arr) {
        int n = arr.length ; 
        ArrayList<ArrayList<Integer>>  list = new ArrayList<>() ; 
        for(int i=0 ; i<32 ; i++){
            list.add( new ArrayList<>()  ) ;  
        }
        Arrays.sort( arr ) ; 
        for(int i=0 ; i<n ; i++ ){
            list.get( count( arr[i] ) ).add( arr[i] ) ; 
        }
        int current = 0 ;
        for(int i=0 ; i<32 ;i++){
            for(int j=0 ; j< list.get(i).size() ; j++ ){
                arr[current++] = list.get(i).get(j) ; 
            }
        }
        return arr ; 
    }
}