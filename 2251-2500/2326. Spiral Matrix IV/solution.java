class Solution {
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] rs = new int[m][n];
        int top = 0;
        int bottom = m - 1;
        int left = 0;
        int right = n - 1;

        while (top <= bottom && left <= right) {
            // Move right
            for (int i = left; i <= right; i++) {
                if (head != null) {
                    rs[top][i] = head.val;
                    head = head.next;
                } else {
                    rs[top][i] = -1;
                }
            }
            top++;

            // Move down
            for (int i = top; i <= bottom; i++) {
                if (head != null) {
                    rs[i][right] = head.val;
                    head = head.next;
                } else {
                    rs[i][right] = -1;
                }
            }
            right--;

            
            if (top <= bottom) {  
                for (int i = right; i >= left; i--) {
                    if (head != null) {
                        rs[bottom][i] = head.val;
                        head = head.next;
                    } else {
                        rs[bottom][i] = -1;
                    }
                }
                bottom--;
            }

            
            if (left <= right) {  
                for (int i = bottom; i >= top; i--) {
                    if (head != null) {
                        rs[i][left] = head.val;
                        head = head.next;
                    } else {
                        rs[i][left] = -1;
                    }
                }
                left++;
            }
        }

        return rs;
    }
}
