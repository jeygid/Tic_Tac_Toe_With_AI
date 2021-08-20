package tictactoe.ai;

import tictactoe.TicTacToeGame;

import java.util.Arrays;

public class HardAI {

    static String[][] grid = new String[3][3];
    static String player;
    static String enemy;
    static boolean turn = true;

    public static String turn() {

        for (int m = 0; m < 3; m++) {
            grid[m] = Arrays.copyOf(TicTacToeGame.grid[m], 3);
        }

        if (TicTacToeGame.playerOne.equals("hard") && TicTacToeGame.playerTwo.equals("hard")) {

            if (turn) {

                player = "X";
                enemy = "O";

            } else {

                player = "O";
                enemy = "X";

            }

        } else if (TicTacToeGame.playerOne.equals("hard")) {

            player = "X";
            enemy = "O";

        } else if (TicTacToeGame.playerTwo.equals("hard")) {

            player = "O";
            enemy = "X";

        }

            int bestScore = Integer.MIN_VALUE;

            int k = 0;
            int l = 0;

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {

                    if (grid[i][j].equals("_")) {

                        grid[i][j] = player;

                        int score = minimax(0, false);

                        grid[i][j] = "_";

                        if (score > bestScore) {
                            bestScore = score;
                            k = i;
                            l = j;
                        }

                    }
                }
            }
            turn = !turn;
            return (k + 1) + " " + (l + 1);
        }

        static int minimax(int depth, boolean isMaximizing){

            int result = 0;
            String res = TicTacToeGame.checkResult(grid);

            // Return scores depend on who's current player
            if (!res.equals("")) {

                switch (res) {

                    case "X":

                        if (player.equals("X")) {
                            return 10;
                        } else {
                            return -10;
                        }

                    case "O":

                        if (player.equals("O")) {
                            return 10;
                        } else {
                            return -10;
                        }

                    case "draw":
                        return result;
                }

            }

            if (isMaximizing) {

                int bestScore = Integer.MIN_VALUE;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (grid[i][j].equals("_")) {

                            grid[i][j] = player;

                            int score = minimax(depth + 1, !isMaximizing);

                            bestScore = Math.max(score, bestScore);

                            grid[i][j] = "_";

                        }
                    }
                }
                return bestScore;

            } else {

                int bestScore = Integer.MAX_VALUE;

                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        if (grid[i][j].equals("_")) {

                            grid[i][j] = enemy;

                            int score = minimax(depth + 1, !isMaximizing);

                            bestScore = Math.min(score, bestScore);

                            grid[i][j] = "_";
                        }
                    }
                }
                return bestScore;
            }


        }

    }

