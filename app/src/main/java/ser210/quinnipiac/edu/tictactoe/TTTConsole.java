package ser210.quinnipiac.edu.tictactoe;

import java.util.Scanner;

/**
 * Created by juliannashevchenko on 2/14/18.
 */

public class TTTConsole {
    public static Scanner in = new Scanner(System.in); // the input Scanner

    public static TicTacToe TTTboard = new TicTacToe();

    /** The entry main method (the program starts here) */
    public static void main(String[] args) {

        int currentState = TicTacToe.PLAYING;
        /**
         * get player input here and call setMove(). user should input a
         * number between 0-8
         */

        char turn = TTTboard.HUMAN_PLAYER;    // player begins
        int win = 0;                // Set to 1, 2, or 3 when game is over

        // Keep looping until someone wins or a tie
        while (win == 0) {
            TTTboard.printBoard();
            if (turn == TTTboard.HUMAN_PLAYER) {
                System.out.println("Make your move: ");
                int spot = in.nextInt();
                TTTboard.setMove(TTTboard.HUMAN_PLAYER, (spot));
                turn = TTTboard.COMPUTER_PLAYER;
            } else {
                TTTboard.setMove(TTTboard.COMPUTER_PLAYER, TTTboard.getComputerMove());
                turn = TTTboard.HUMAN_PLAYER;
            }
            win = TTTboard.checkForWinner();
        }

/*			if (currentState == TTTboard.CROSS_WON) {
				System.out.println("'X' won! Bye!");
			} else if (currentState == TTTboard.NOUGHT_WON) {
				System.out.println("'O' won! Bye!");
			} else if (currentState == TTTboard.TIE) {
				System.out.println("It's a TIE! Bye!");
			}*/

        if (TTTboard.checkForWinner()==2) {
            TTTboard.printBoard();
            System.out.println("'X' won! Bye!");
        } else if (TTTboard.checkForWinner()==3) {
            TTTboard.printBoard();
            System.out.println("'O' won! Bye!");
        } else if (TTTboard.checkForWinner()==1) {
            TTTboard.printBoard();
            System.out.println("It's a TIE! Bye!");
        }
    }

}
