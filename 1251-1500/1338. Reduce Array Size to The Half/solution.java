class Solution {
    public int minSetSize(int[] arr) {
        int n = arr.length ; 
        PriorityQueue< Integer > q = new PriorityQueue<>( (a,b) -> b-a  ) ; 
        Arrays.sort(arr) ; 
        int count = 0 ; 
        for(int i=0 ; i<n ; ++i){
            count = 1 ;
            while( i+1 < n && arr[i+1] == arr[i] ){
                count++ ; 
                i++ ; 
            }
            q.add(count) ;
        }
        int rs = 0 ; 
        int gone = 0 ; 
        while( gone < n/2  ){
            gone += q.poll() ; 
            rs++ ; 
        }
        return rs ; 
    }
}