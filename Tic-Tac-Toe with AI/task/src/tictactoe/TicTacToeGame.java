package tictactoe;

import tictactoe.ai.EasyAI;
import tictactoe.ai.MediumAI;
import tictactoe.ai.HardAI;

import java.util.*;

public class TicTacToeGame {

    public static String playerOne = "";
    public static String playerTwo = "";
    public static String[][] grid =

                    {{"_", "_", "_"},
                    {"_", "_", "_"},
                    {"_", "_", "_"}};

    public static String winner = "";

    static boolean gameFinished = false;
    static boolean turn;
    static Scanner scanner = new Scanner(System.in);


    public static void drawGrid() {

        System.out.println("\n---------");

        System.out.print("| ");
        System.out.print(grid[0][0] + " ");
        System.out.print(grid[0][1] + " ");
        System.out.print(grid[0][2] + " ");
        System.out.println("|");

        System.out.print("| ");
        System.out.print(grid[1][0] + " ");
        System.out.print(grid[1][1] + " ");
        System.out.print(grid[1][2] + " ");
        System.out.println("|");

        System.out.print("| ");
        System.out.print(grid[2][0] + " ");
        System.out.print(grid[2][1] + " ");
        System.out.print(grid[2][2] + " ");
        System.out.println("|");

        System.out.println("---------");

    }

    public static void start() {

        System.out.println("\nWelcome to Tic Tac Toe game!\n");

        System.out.println("Coordinates grid: " +
                "\n(1 1) (1 2) (1 3)" +
                "\n(2 1) (2 2) (2 3)" +
                "\n(3 1) (3 2) (3 3)");

        //drawGrid();
        game();
    }

    public static String checkResult(String[][] grid) {

        boolean xWins =

                        ("X".equals(grid[0][0]) && "X".equals(grid[0][1]) && "X".equals(grid[0][2])) ||
                        ("X".equals(grid[1][0]) && "X".equals(grid[1][1]) && "X".equals(grid[1][2])) ||
                        ("X".equals(grid[2][0]) && "X".equals(grid[2][1]) && "X".equals(grid[2][2])) ||

                        ("X".equals(grid[0][0]) && "X".equals(grid[1][0]) && "X".equals(grid[2][0])) ||
                        ("X".equals(grid[0][1]) && "X".equals(grid[1][1]) && "X".equals(grid[2][1])) ||
                        ("X".equals(grid[0][2]) && "X".equals(grid[1][2]) && "X".equals(grid[2][2])) ||

                        ("X".equals(grid[0][0]) && "X".equals(grid[1][1]) && "X".equals(grid[2][2])) ||
                        ("X".equals(grid[0][2]) && "X".equals(grid[1][1]) && "X".equals(grid[2][0]));


        boolean oWins =

                        ("O".equals(grid[0][0]) && "O".equals(grid[0][1]) && "O".equals(grid[0][2])) ||
                        ("O".equals(grid[1][0]) && "O".equals(grid[1][1]) && "O".equals(grid[1][2])) ||
                        ("O".equals(grid[2][0]) && "O".equals(grid[2][1]) && "O".equals(grid[2][2])) ||

                        ("O".equals(grid[0][0]) && "O".equals(grid[1][0]) && "O".equals(grid[2][0])) ||
                        ("O".equals(grid[0][1]) && "O".equals(grid[1][1]) && "O".equals(grid[2][1])) ||
                        ("O".equals(grid[0][2]) && "O".equals(grid[1][2]) && "O".equals(grid[2][2])) ||

                        ("O".equals(grid[0][0]) && "O".equals(grid[1][1]) && "O".equals(grid[2][2])) ||
                        ("O".equals(grid[0][2]) && "O".equals(grid[1][1]) && "O".equals(grid[2][0]));

        boolean draw = !xWins && !oWins && Arrays.stream(grid).flatMap(Arrays::stream).noneMatch(e -> e.equals("_"));

        if (xWins) return "X";
        if (oWins) return "O";
        if (draw) return "draw";

        return "";
    }

    public static void game() {

        while (true) {

            System.out.println("\nInput command");

            Scanner scanner = new Scanner(System.in);

            String commandPattern = "(exit|start (easy|medium|hard|user) (easy|medium|hard|user))";

            String mainCommand = scanner.nextLine();

            if (!mainCommand.matches(commandPattern)) {
                System.out.println("\nBad parameters!");
                continue;
            }

            if (mainCommand.equals("exit")) {
                break;
            }

            String[] mainCommandArray = mainCommand.split(" ");
            playerOne = mainCommandArray[1];
            playerTwo = mainCommandArray[2];

            turn = true;

            grid = new String[][]{{"_", "_", "_"},
                    {"_", "_", "_"},
                    {"_", "_", "_"}};

            drawGrid();
            gameFinished = false;

            while (!gameFinished) {

                if (Arrays.stream(grid).flatMap(Arrays::stream).noneMatch(e -> e.equals("_"))) {
                    break;
                }

                String cellValue = turn ? "X" : "O";

                String inputCoordinates = "";

                if (turn) {
                    inputCoordinates = getCoordinates(playerOne);
                } else {
                    inputCoordinates = getCoordinates(playerTwo);
                }

                String pattern = "[1-3] [1-3]";

                if (inputCoordinates.matches(pattern)) {

                    String[] coordinates = inputCoordinates.split(" ");

                    int x = Integer.parseInt(coordinates[0]) - 1;
                    int y = Integer.parseInt(coordinates[1]) - 1;

                    if (!grid[x][y].equals("X") && !grid[x][y].equals("O")) {

                        grid[x][y] = cellValue;
                        turn = !turn;
                        drawGrid();

                        String result = checkResult(grid);
                        switch (result) {
                            case "X":
                                System.out.println("\nX wins");
                                gameFinished = true;
                                break;
                            case "O":
                                System.out.println("\n0 wins");
                                gameFinished = true;
                                break;
                            case "draw":
                                System.out.println("\nDraw");
                                gameFinished = true;

                        }

                    } else {

                        System.out.println("\nThis cell is occupied! Choose another one!");

                    }

                } else {

                    System.out.println("\nYou should enter numbers!");

                }

            }
        }
    }

    public static String getCoordinates(String player) {

        String inputCoordinates = "";

        switch (player) {
            case "user":
                System.out.println("\nEnter the coordinates:");
                inputCoordinates = playerTurn();
                break;
            case "easy":
                System.out.println("\nMaking move level \"easy\"");
                inputCoordinates = EasyAI.turn();
                break;
            case "medium":
                System.out.println("\nMaking move level \"medium\"");
                inputCoordinates = MediumAI.turn();
                break;
            case "hard":
                System.out.println("\nMaking move level \"hard\"");
                inputCoordinates = HardAI.turn();
                break;
        }

        return inputCoordinates;
    }

    public static String playerTurn() {

        return scanner.nextLine();

    }
}






