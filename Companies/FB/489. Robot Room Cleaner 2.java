class Solution {
    public void cleanRoom(Robot robot) {
        if (robot == null) {
            return;
        }
        Set<String> set = new HashSet<>();
        helper(robot, 0, 0, 0, set);
    }
    private void helper(Robot robot, int row, int col, int facing, Set<String> set) {
        String path = "" + row + "->" + col;
        if (!set.add(path)) {
            return;
        }
        robot.clean();
        for (int i = 0; i < 4; i++) {
            if (robot.move()) {
                int x = row;
                int y = col;
                if (facing == 0) {
                    x--;
                } else if (facing == 90) {
                    y++;
                } else if (facing == 180) {
                    x++;
                } else {
                    y--;
                }
                helper(robot, x, y, facing, set);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
            facing += 90;
            facing %= 360;
        }
    }
}