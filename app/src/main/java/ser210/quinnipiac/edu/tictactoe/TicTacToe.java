package ser210.quinnipiac.edu.tictactoe;

import java.util.Random;

/**
 * Created by juliannashevchenko on 2/14/18.
 */

public class TicTacToe implements ITicTacToe {

    public static final char HUMAN_PLAYER = 'X';
    public static final char COMPUTER_PLAYER = 'O';
    private Random randomMove;

    private char board[] = {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY};
    /**
     * clear board and set current player
     */
    public TicTacToe() {
        // Put random here to ensure computer makes new moves each game
        randomMove = new Random();
    }

    @Override
    public void clearBoard() {
        // Clears board by setting all cells to empty
        for (int i = 0; i < board.length; i++)
            board[i] = EMPTY;
    }

    @Override
    public void setMove(char player, int location) {
        // Prints player's symbol so long as the space is empty
        if (location >= 0 && location <= 8 && board[location] == EMPTY) {
            board[location] = player;
        }

    }

    @Override
    public int getComputerMove() {
        // Generate random move for computer... dummy AI!
        int move;
        do {
            move = randomMove.nextInt(board.length);
        } while (board[move] == COMPUTER_PLAYER || board[move] == HUMAN_PLAYER);
        return move;
    }

    @Override
    public int checkForWinner() {
        // Check horizontally for win
        for (int i = 0; i <= 6; i += 3) {
            if (board[i] == HUMAN_PLAYER && board[i + 1] == HUMAN_PLAYER
                    && board[i + 2] == HUMAN_PLAYER)
                return 2;
            if (board[i] == COMPUTER_PLAYER
                    && board[i + 1] == COMPUTER_PLAYER
                    && board[i + 2] == COMPUTER_PLAYER)
                return 3;
        }

        // Check vertically for win
        for (int i = 0; i <= 2; i++) {
            if (board[i] == HUMAN_PLAYER && board[i + 3] == HUMAN_PLAYER
                    && board[i + 6] == HUMAN_PLAYER)
                return 2;
            if (board[i] == COMPUTER_PLAYER
                    && board[i + 3] == COMPUTER_PLAYER
                    && board[i + 6] == COMPUTER_PLAYER)
                return 3;
        }

        // Check diagonally for win
        if ((board[0] == HUMAN_PLAYER && board[4] == HUMAN_PLAYER && board[8] == HUMAN_PLAYER)
                || (board[2] == HUMAN_PLAYER && board[4] == HUMAN_PLAYER && board[6] == HUMAN_PLAYER))
            return 2;
        if ((board[0] == COMPUTER_PLAYER && board[4] == COMPUTER_PLAYER && board[8] == COMPUTER_PLAYER)
                || (board[2] == COMPUTER_PLAYER
                && board[4] == COMPUTER_PLAYER && board[6] == COMPUTER_PLAYER))
            return 3;

        // Still playing...
        for (int i = 0; i < board.length; i++) {
            if (board[i] != HUMAN_PLAYER && board[i] != COMPUTER_PLAYER)
                return 0;
        }

        // Check for tie
        return 1;
    }

    /**
     * Print the game board
     * 1D
     */
    public void printBoard() {
        System.out.println();
        System.out.println("  " + board[0] + " | " + board[1] + " | " + board[2]);
        System.out.println("-----------");
        System.out.println("  " + board[3] + " | " + board[4] + " | " + board[5]);
        System.out.println("-----------");
        System.out.println("  " + board[6] + " | " + board[7] + " | " + board[8]);
        System.out.println();
    }

    /**
     * Print a cell with the specified "content"
     *
     * @param content
     *            either CROSS, NOUGHT or EMPTY
     */
    public void printCell(int content) {
        switch (content) {
            case EMPTY:
                System.out.print("   ");
                break;
            case NOUGHT:
                System.out.print(" O ");
                break;
            case CROSS:
                System.out.print(" X ");
                break;
        }
    }

}
