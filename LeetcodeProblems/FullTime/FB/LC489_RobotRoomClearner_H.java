package FullTime.FB;

import java.util.HashSet;
import java.util.Set;

/**
 * Backtracking: 1. clockwise travel 2. goBack()
 *
 * time: O(4^(N-M)), N is num of cells in the room, M is num of obstacles
 * space: O(N-M)
 */
public class LC489_RobotRoomClearner_H {

    interface Robot {
        // returns true if next cell is open and robot moves into the cell.
        // returns false if next cell is obstacle and robot stays on the current cell.
        boolean move();

        // Robot will stay on the same cell after calling turnLeft/turnRight.
        // Each turn will be 90 degrees.
        void turnLeft();
        void turnRight();

        // Clean the current cell.
        void clean();
    }

    private int[][] dirs = {{-1,0},{0,1},{1,0},{0,-1}};
    private Robot robot;

    public void cleanRoom(Robot robot) {
        this.robot = robot;
        Set<String> visited = new HashSet<>();
        backtracking(visited, 0,0, 0);
    }

    public void backtracking(Set<String> visited, int row, int col, int d) {
        robot.clean();
        visited.add(row + "-" + col);

        for (int i = 0; i < 4; i++) {
            int k = (i + d) % 4;
            int nextRow = row + dirs[k][0];
            int nextCol = col + dirs[k][1];

            if (!visited.contains(nextRow + "-" + nextCol) && robot.move()) {
                backtracking(visited, nextRow, nextCol, k);
                goBack();
            }
            robot.turnRight();
        }
    }

    public void goBack() {
        robot.turnRight();
        robot.turnRight();
        robot.move();
        robot.turnRight();
        robot.turnRight();
    }
}
