class Solution {
    public void swap( int[][] arr , int i ){
        int m = arr[0].length ; 
        for(int j=0 ; j<m ; j++){
            arr[i][j] = 1 -  arr[i][j]  ;
        }
        int left = 0 ; int right = m-1 ; 
        while( left < right ){
            int temp = arr[i][left] ; 
            arr[i][left] = arr[i][right] ; 
            arr[i][right] = temp ; 
            left++;
            right-- ;
        }
     }
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length ; 
        for(int i=0; i<n ; i++){
            swap( image , i ) ; 
        }
        return image ; 
    }
}