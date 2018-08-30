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
        dfs(robot, 0, 0, new HashSet<String>(), 0);
    }
    private void dfs(Robot robot, int row, int col, HashSet<String> visited, int cleanDir) {
        String temp = row + "->" + col;
        if (!(visited.add(temp))) {
            return;
        }
        robot.clean();
        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                int x = row;
                int y = col;
                switch (cleanDir) {
                    case 0:
                        x--;
                        break;
                    case 90:
                        y++;
                        break;
                    case 180:
                        x++;
                        break;
                    case 270:
                        y--;
                        break;
                }
                dfs(robot, x, y, visited, cleanDir);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
            cleanDir += 90;
            cleanDir %= 360;
        }
    }
}