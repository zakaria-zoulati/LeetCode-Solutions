class Solution {
    double radius,x_center,y_center;
    static final double PI = 3.141592653589;
    public Solution(double radius, double x_center, double y_center) {
        this.radius =radius;
        this.x_center = x_center;
        this.y_center = y_center;
        
    }
    public double[] randPoint() {
        double theta =  2 * PI * Math.random();
        double length = Math.sqrt(Math.random())* radius;
        double []res = new double[2];
        double x = x_center + length*Math.cos(theta);
        double y = y_center + length*Math.sin(theta);
        res[0]=x;
        res[1]=y;
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(radius, x_center, y_center);
 * double[] param_1 = obj.randPoint();
 */