class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        if (n == 1) {
            return triangle.get(0).get(0);
        } else if (n == 2) {
            return triangle.get(0).get(0) + Math.min(triangle.get(1).get(0), triangle.get(1).get(1));
        }
        for (int i = 1; i < n; i++) {
            triangle.get(i).set(0, triangle.get(i).get(0) +  triangle.get(i-1).get(0) );
            for (int j = 1; j <= i-1; j++) {
                    triangle.get(i).set(j , triangle.get(i).get(j) +  Math.min( triangle.get(i-1).get(j-1) ,triangle.get(i-1).get(j)    )) ; 
            }
            triangle.get(i).set(i, triangle.get(i).get(i) +  triangle.get(i-1).get(i-1)  );
               
        }
        int min = Integer.MAX_VALUE;
        for ( int i=0 ; i<n ; i++  ) {
            min = Math.min(min,  triangle.get(n-1).get(i)  );
        }
        return min;
}
}
