class Solution2 {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;
        int[] dirs = {-1, 0, 1, 0, -1};
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(entrance);
        maze[entrance[0]][entrance[1]] = '+';
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                int x = cur[0], y = cur[1];
                if ((x == 0 || x == m - 1 || y == 0 || y == n - 1) && !(x == entrance[0] && y == entrance[1])) {
                    return steps;
                }
                for (int j = 0; j < 4; j++) {
                    int newX = x + dirs[j];
                    int newY = y + dirs[j + 1];
                    if (newX >= 0 && newX < m && newY >= 0 && newY < n && maze[newX][newY] == '.') {
                        maze[newX][newY] = '+';
                        queue.offer(new int[] {newX , newY});
                    }
                }
            }
            steps++;
        }
        return -1;
    }

}