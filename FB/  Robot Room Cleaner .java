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
class Solution {
    public void cleanRoom(Robot robot) {
        if (robot == null) {
            return;
        }
        Set<String> set = new HashSet<>();
        dfs(robot, 0, 0, set, 0);
    }
    private void dfs(Robot robot, int row, int col, Set<String> visited, int curDir) {
        String temp = row + "->" + col;
        if (!visited.add(temp)) {
            return;
        }
        robot.clean();
        for (int x = 0; x < 4; x++) {
            if (robot.move()) {
                int i = row;
                int j = col;
                switch (curDir) {
                    case 0:
                        i--;
                        break;
                    case 90:
                        j++;
                        break;
                    case 180:
                        i++;
                        break;
                    case 270:
                        j--;
                        break;
                }
                dfs(robot, i, j, visited, curDir);
                goBack(robot);
            }
            robot.turnRight();
            curDir += 90;
            curDir %= 360;
        }
    }
    private void goBack(Robot robot) {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}