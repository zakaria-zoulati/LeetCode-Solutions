import java.util.* ; 
class Solution {
    public int maxNumberOfFamilies(int n, int[][] arr) {
        int len = arr.length; 
        Arrays.sort(arr, (a, b) -> a[0] - b[0]); 
        int rs = 2 * n; 
        for (int i = 0; i < len; ++i) {
            rs -= 2; 
            int curr = 0; 
            int r = arr[i][0]; 
            curr |= (1 << (10 - arr[i][1])); 
            
            while (i + 1 < len && arr[i + 1][0] == r) {
                i++; 
                curr |= (1 << (10 - arr[i][1])); 
            }
            boolean left = (curr & 0b0000011110) == 0;
            boolean mid = (curr & 0b0001111000) == 0;
            boolean right = (curr & 0b0111100000) == 0;
            if (left && right) {
                rs += 2;
            } else if (left || mid || right) {
                rs += 1;
            }
        }
        return rs; 
    }
}
