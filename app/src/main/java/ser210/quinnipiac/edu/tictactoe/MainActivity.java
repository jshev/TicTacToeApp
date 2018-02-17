package ser210.quinnipiac.edu.tictactoe;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_WELCOME = "welcome";
    ImageButton butt0;
    ImageButton butt1;
    ImageButton butt2;
    ImageButton butt3;
    ImageButton butt4;
    ImageButton butt5;
    ImageButton butt6;
    ImageButton butt7;
    ImageButton butt8;
    Button restart;
    int win = 0;
    int[] buttonIds = new int[9];
    public static TicTacToe TTT2 = new TicTacToe();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // gets welcome text from Login Activity
        Intent intent = getIntent();
        String welcomeText = intent.getStringExtra(EXTRA_WELCOME);
        TextView welcomeView = (TextView) findViewById(R.id.welcome);
        welcomeView.setText(welcomeText);

        // set array of imagebuttons
        buttonIds[0] = R.id.button0;
        buttonIds[1] = R.id.button1;
        buttonIds[2] = R.id.button2;
        buttonIds[3] = R.id.button3;
        buttonIds[4] = R.id.button4;
        buttonIds[5] = R.id.button5;
        buttonIds[6] = R.id.button6;
        buttonIds[7] = R.id.button7;
        buttonIds[8] = R.id.button8;

        // sets up all buttons and makes simple tags
        butt0 = (ImageButton) findViewById(R.id.button0);
        butt0.setOnClickListener(imageButtonHandler);
        butt0.setTag(Integer.valueOf(0));

        butt1 = (ImageButton) findViewById(R.id.button1);
        butt1.setOnClickListener(imageButtonHandler);
        butt1.setTag(Integer.valueOf(1));

        butt2 = (ImageButton) findViewById(R.id.button2);
        butt2.setOnClickListener(imageButtonHandler);
        butt2.setTag(Integer.valueOf(2));

        butt3 = (ImageButton) findViewById(R.id.button3);
        butt3.setOnClickListener(imageButtonHandler);
        butt3.setTag(Integer.valueOf(3));

        butt4 = (ImageButton) findViewById(R.id.button4);
        butt4.setOnClickListener(imageButtonHandler);
        butt4.setTag(Integer.valueOf(4));

        butt5 = (ImageButton) findViewById(R.id.button5);
        butt5.setOnClickListener(imageButtonHandler);
        butt5.setTag(Integer.valueOf(5));

        butt6 = (ImageButton) findViewById(R.id.button6);
        butt6.setOnClickListener(imageButtonHandler);
        butt6.setTag(Integer.valueOf(6));

        butt7 = (ImageButton) findViewById(R.id.button7);
        butt7.setOnClickListener(imageButtonHandler);
        butt7.setTag(Integer.valueOf(7));

        butt8 = (ImageButton) findViewById(R.id.button8);
        butt8.setOnClickListener(imageButtonHandler);
        butt8.setTag(Integer.valueOf(8));

        // restart button is visible but cannot be clicked
        restart = (Button) findViewById(R.id.resetbutton);
        restart.setEnabled(false);

    }

    View.OnClickListener imageButtonHandler = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ImageButton butt = (ImageButton) view;
            TextView winView = (TextView) findViewById(R.id.whoWon);

            // gets the button player clicked and sets move both in console and board
            // then disables that button
            int tagValue = (Integer) butt.getTag();
            TTT2.setMove(TTT2.HUMAN_PLAYER, tagValue);
            butt.setImageResource(R.drawable.cross);
            butt.setEnabled(false);

            // gets the move computer made and sets it on the board
            int move = TTT2.getComputerMove();
            TTT2.setMove(TTT2.COMPUTER_PLAYER, move);
            setMoveOnBoard(move);

            // check for winner from console version
            win = TTT2.checkForWinner();

            // informs player who won by changing textview
            // restart button can now be clicked
            if (TTT2.checkForWinner() == 2) {
                String winText = "'X' won! Play again?";
                winView.setText(winText);
                restart.setEnabled(true);
            } else if (TTT2.checkForWinner() == 3) {
                String winText2 = "'O' won! Play again?";
                winView.setText(winText2);
                restart.setEnabled(true);
            } else if (TTT2.checkForWinner() == 1) {
                String winText3 = "It's a TIE! Play again?";
                winView.setText(winText3);
                restart.setEnabled(true);
            }

        }

    };

    public void onClickRestart(View view) {
        // restarts game by resetting everything
        TextView winView = (TextView) findViewById(R.id.whoWon);
        win = 0;
        TTT2.clearBoard();
        for (int i = 0; i < buttonIds.length; i++) {
            ImageButton button = (ImageButton) findViewById(buttonIds[i]);
            button.setImageResource(R.drawable.empty);
            button.setEnabled(true);
        }
        winView.setText("");
        restart.setEnabled(false);
    }

    private void setMoveOnBoard(int move) {
        // places computer's move on board and disables that button
        ImageButton button = (ImageButton) findViewById(buttonIds[move]);
        button.setImageResource(R.drawable.nought);
        button.setEnabled(false);
    }

}