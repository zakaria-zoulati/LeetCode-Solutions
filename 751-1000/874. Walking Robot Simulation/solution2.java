class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0, currDir = 0;
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; 
        HashSet<String> obstacleSet = new HashSet<>();
        for (int[] obs : obstacles) {
            obstacleSet.add(obs[0] + "," + obs[1]);
        }
        
        int maxDistSquared = 0;
        for (int command : commands) {
            if (command == -1) {
                currDir = (currDir + 1) % 4;
            } else if (command == -2) {
                currDir = (currDir + 3) % 4;
            } else {
                for (int step = 0; step < command; step++) {
                    int nextX = x + directions[currDir][0];
                    int nextY = y + directions[currDir][1];
                    String nextPosition = nextX + "," + nextY;
                    
                    if (!obstacleSet.contains(nextPosition)) {
                        x = nextX;
                        y = nextY;
                        maxDistSquared = Math.max(maxDistSquared, x * x + y * y);
                    } else {
                        break; 
                    }
                }
            }
        }
        
        return maxDistSquared;
    }
}
