class Solution {
    public double largestTriangleArea(int[][] points) {
        double max = Integer.MIN_VALUE;
        
        for(int i = 0; i < points.length; i++) {
            for(int j = 0; j < points.length; j++) {
                for(int k = 0; k < points.length; k++) {
                    if((i != j) && (i != k) && (j != k)) {
                        
                        double leg1 = distance(points[i], points[j]);
                        double leg2 = distance(points[i], points[k]);
                        double leg3 = distance(points[k], points[j]);
                        
                        //Heron's formula
                        double S = (leg1 + leg2 + leg3)/2;
                        double area = Math.sqrt(S*(S - leg1)*(S - leg2)*(S - leg3));
                        
                        if(area > max) {
                            max = area;
                        }
                        
                    }
                }
            }
        }
        
        return max;
    }
  
    public double distance(int[] point1, int[] point2) {
        double a = point1[0] - point2[0];
        double b = point1[1] - point2[1];
        double dist = Math.sqrt((a*a) + (b*b));
        return dist;
    }
}