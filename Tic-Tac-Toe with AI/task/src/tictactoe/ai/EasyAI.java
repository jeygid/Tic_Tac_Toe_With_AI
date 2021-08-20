package tictactoe.ai;

import tictactoe.TicTacToeGame;

import java.util.ArrayList;
import java.util.Random;

public class EasyAI {

    public static String turn() {

        String[][] grid = TicTacToeGame.grid;

        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid.length; j++) {
                if (grid[i][j].equals("_")) {
                    list.add((i + 1) + " " + (j + 1));
                }
            }
        }

        Random rand = new Random();
        String coordinates = list.get(rand.nextInt(list.size()));

        return coordinates;

    }

}
