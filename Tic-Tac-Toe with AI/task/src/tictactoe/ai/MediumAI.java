package tictactoe.ai;

import tictactoe.TicTacToeGame;

public class MediumAI {

    public static String turn() {

        String playerOne = TicTacToeGame.playerOne;
        String playerTwo = TicTacToeGame.playerTwo;
        String[][] grid = TicTacToeGame.grid;

        String me = "";
        String enemy = "";
        String sign = "";

        if (playerOne.equals("medium")) {
            me = "X";
            enemy = "0";
        } else if (playerTwo.equals("medium")) {
            me = "O";
            enemy = "X";
        }

        String coordinates = "";
        sign = enemy;

        for (int i = 0; i <= 1; i++) {

            //Top line
            if (sign.equals(grid[0][0]) && sign.equals(grid[0][1]) && "_".equals(grid[0][2])) coordinates = "1 3";
            if (sign.equals(grid[0][1]) && sign.equals(grid[0][2]) && "_".equals(grid[0][0])) coordinates = "1 1";
            if (sign.equals(grid[0][0]) && sign.equals(grid[0][2]) && "_".equals(grid[0][1])) coordinates = "1 2";

            //Middle line
            if (sign.equals(grid[1][0]) && sign.equals(grid[1][1]) && "_".equals(grid[1][2])) coordinates = "2 3";
            if (sign.equals(grid[1][1]) && sign.equals(grid[1][2]) && "_".equals(grid[1][0])) coordinates = "2 1";
            if (sign.equals(grid[1][0]) && sign.equals(grid[1][2]) && "_".equals(grid[1][1])) coordinates = "2 2";

            //Bottom line
            if (sign.equals(grid[2][0]) && sign.equals(grid[2][1]) && "_".equals(grid[2][2])) coordinates = "3 3";
            if (sign.equals(grid[2][1]) && sign.equals(grid[2][2]) && "_".equals(grid[2][0])) coordinates = "3 1";
            if (sign.equals(grid[2][0]) && sign.equals(grid[2][2]) && "_".equals(grid[2][1])) coordinates = "3 2";

            //First row
            if (sign.equals(grid[0][0]) && sign.equals(grid[1][0]) && "_".equals(grid[2][0])) coordinates = "3 1";
            if (sign.equals(grid[1][0]) && sign.equals(grid[2][0]) && "_".equals(grid[0][0])) coordinates = "1 1";
            if (sign.equals(grid[0][0]) && sign.equals(grid[2][0]) && "_".equals(grid[1][0])) coordinates = "2 1";

            //Second row
            if (sign.equals(grid[0][1]) && sign.equals(grid[1][1]) && "_".equals(grid[2][1])) coordinates = "3 2";
            if (sign.equals(grid[1][1]) && sign.equals(grid[2][1]) && "_".equals(grid[0][1])) coordinates = "1 2";
            if (sign.equals(grid[0][1]) && sign.equals(grid[2][1]) && "_".equals(grid[1][2])) coordinates = "2 3";

            //Third row
            if (sign.equals(grid[0][2]) && sign.equals(grid[1][2]) && "_".equals(grid[2][2])) coordinates = "3 3";
            if (sign.equals(grid[1][2]) && sign.equals(grid[2][2]) && "_".equals(grid[0][2])) coordinates = "1 3";
            if (sign.equals(grid[0][2]) && sign.equals(grid[2][2]) && "_".equals(grid[1][2])) coordinates = "2 3";

            //Diagonal from left top corner to right bottom corner
            if (sign.equals(grid[0][0]) && sign.equals(grid[1][1]) && "_".equals(grid[2][2])) coordinates = "3 3";
            if (sign.equals(grid[0][0]) && sign.equals(grid[2][2]) && "_".equals(grid[1][1])) coordinates = "2 2";
            if (sign.equals(grid[1][1]) && sign.equals(grid[2][2]) && "_".equals(grid[0][0])) coordinates = "1 1";

            //Diagonal from right top corner to left bottom corner
            if (sign.equals(grid[0][2]) && sign.equals(grid[2][0]) && "_".equals(grid[1][1])) coordinates = "2 2";
            if (sign.equals(grid[1][1]) && sign.equals(grid[0][2]) && "_".equals(grid[2][0])) coordinates = "3 1";
            if (sign.equals(grid[1][1]) && sign.equals(grid[2][0]) && "_".equals(grid[0][2])) coordinates = "1 3";

            sign = me;

        }

        if ("".equals(coordinates)) coordinates = EasyAI.turn();

        return coordinates;
    }

}
