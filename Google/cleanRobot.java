/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

https://leetcode.com/explore/interview/card/google/61/trees-and-graphs/1340/

class Solution {
    public void cleanRoom(Robot robot) {
        Set<String> visited = new HashSet<>();
        dfs(robot, visited, 0, 0, 0);
    }

    // 0 up 90 right, 180 down, 270 left
    private void dfs(Robot robot, Set<String> visited, int row, int col, int dir) {
        String temp = row + "->" + col;
        if (!visited.add(temp)) {
            return;
        }
        robot.clean();
        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                int x = row;
                int y = col;
                switch (dir) {
                    case 0 :
                        x = row - 1;
                        break;
                    case 90:
                        y = col + 1;
                        break;
                    case 180:
                        x = row + 1;
                        break;
                    case 270:
                        y = col - 1;
                        break;
                }
                dfs(robot, visited, x, y, dir);
                goBack(robot);
            }
            robot.turnRight();
            dir += 90;
            dir %= 360;
        }
    }
    
    private void goBack(Robot robot) {
        robot.turnLeft();
        robot.turnLeft();
        robot.move();
        robot.turnLeft();
        robot.turnLeft();
    }
}