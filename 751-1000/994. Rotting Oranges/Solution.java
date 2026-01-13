class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return 0;
        Queue<int[]> queue = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2)
                    queue.offer(new int[]{i,j});
                else if(grid[i][j] == 1)
                    fresh++;
            }
        }
        if(fresh == 0) return 0;
        int minute = 0;
        int [][] dirs = new int[][]{{0,1},{0,-1},{-1,0},{1,0}}; // U D L R
        while(!queue.isEmpty()){
            int level = queue.size();
            for(int i=0;i<level;i++){
                int [] current = queue.poll();
                int row = current[0];
                int col = current[1];
                for(int[] dir:dirs){
                    int nr = row + dir[0];
                    int nc = col + dir[1];
                    if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                        queue.offer(new int[]{nr,nc});
                        grid[nr][nc] = 2;
                        fresh--;
                    }
                }
            }
            minute++;
        }
        return fresh != 0 ? -1 :minute-1;
    }
}