class Solution {
    public int maxArea(int[] height) {
        int n = height.length ; 
        int l = 0;
        int r = n-1;
        int rs = 0;
        while(l<r){
            if(height[l] < height[r]){
                int area = (r-l)*height[l];
                rs = Math.max(rs,area);
                int cur = height[l];
                while(height[l] <= cur && l < r) l++;
            }else{
                int area = (r-l)*height[r];
                rs = Math.max(rs,area);
                int cur = height[r];
                while(height[r] <= cur && l < r) r--;
            }
        }
        return rs;
    }
}