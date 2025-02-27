class Solution {    
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length ; 
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }
        int max = 2 ; 
        for (int i = 0; i< n ; ++i) {
            if( arr[i]*Math.pow( 1.618 , max -1 ) > arr[n-1] ) break ; 
            for (int j = i + 1; j < n; ++j) {
                int a = arr[i] ; 
                int b = arr[j] ; 
                int len = 2 ; 
                while(set.contains(a + b)) {
                    int tmp = a+b ; 
                    a = b ; 
                    b = tmp ;
                    len++ ; 
                }
                max = Math.max( max , len ) ; 
            }
        }

        return max > 2 ? max : 0 ; 
    }
}