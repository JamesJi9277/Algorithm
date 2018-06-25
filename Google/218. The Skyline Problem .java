class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<int[]>();
        if (buildings == null || buildings.length == 0 || buildings[0].length == 0) {
            return res;
        }
        BuildingPoint[] buildingPoints = new BuildingPoint[buildings.length * 2];
        int index = 0;
        for (int[] building : buildings) {
            buildingPoints[index] = new BuildingPoint();
            buildingPoints[index].x = building[0];
            buildingPoints[index].isStart = true;
            buildingPoints[index].height = building[2];
            
            buildingPoints[index + 1] = new BuildingPoint();
            buildingPoints[index + 1].x = building[1];
            buildingPoints[index + 1].isStart = false;
            buildingPoints[index + 1].height = building[2];
            index += 2;
        }
        Arrays.sort(buildingPoints);
        
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Collections.reverseOrder());
        pq.offer(0);
        int preMax = 0;
        for (BuildingPoint point : buildingPoints) {
            if (point.isStart) {
                pq.offer(point.height);
            } else {
                pq.remove(point.height);
            }
            int curMax = pq.peek();
            if (curMax != preMax) {
                res.add(new int[]{point.x, curMax});
                preMax = curMax;
            }
        }
        return res;
    }
}
class BuildingPoint implements Comparable<BuildingPoint> {
    int x;
    int height;
    boolean isStart;
    public BuildingPoint() {
        
    }
    public BuildingPoint(int x, int height, boolean isStart) {
        this.x = x;
        this.height= height;
        this.isStart = isStart;
    }
    
    @Override
    public int compareTo(BuildingPoint p) {
        // first compare to x, start point
        // if two share same start, then with higher height comes first
        // if two share same end, then with lower heigh comes first
        // 目的是为了要让在同一点的max尽可能先保持在里面
        if (this.x != p.x) {
            return this.x - p.x;
        } else {
            return (this.isStart ? -this.height : this.height) - (p.isStart ? -p.height  : p.height);
        }
    }
}