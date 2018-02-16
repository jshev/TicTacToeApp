package ser210.quinnipiac.edu.tictactoe;

import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    char turn = TTT2.HUMAN_PLAYER;
    int win = 0;


    boolean isPressedPlayer = false;
    boolean isPressedComputer = false;
    ImageButton[] buttons = {butt0, butt1, butt2, butt3, butt4, butt5, butt6, butt7, butt8};

    int clicks;
    int lastClicks;

    public static TicTacToe TTT2 = new TicTacToe();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String welcomeText = intent.getStringExtra(EXTRA_WELCOME);
        TextView welcomeView = (TextView) findViewById(R.id.welcome);
        welcomeView.setText(welcomeText);

        butt0 = (ImageButton) findViewById(R.id.button0);
        butt0.setOnClickListener(imageButtonHandler);
        butt0.setTag(Integer.valueOf(0));

        butt1 = (ImageButton) findViewById(R.id.button1);
        butt1.setOnClickListener(imageButtonHandler);
        butt0.setTag(Integer.valueOf(1));

        butt2 = (ImageButton) findViewById(R.id.button2);
        butt2.setOnClickListener(imageButtonHandler);
        butt0.setTag(Integer.valueOf(2));

        butt3 = (ImageButton) findViewById(R.id.button3);
        butt3.setOnClickListener(imageButtonHandler);
        butt0.setTag(Integer.valueOf(3));

        butt4 = (ImageButton) findViewById(R.id.button4);
        butt4.setOnClickListener(imageButtonHandler);
        butt0.setTag(Integer.valueOf(4));

        butt5 = (ImageButton) findViewById(R.id.button5);
        butt5.setOnClickListener(imageButtonHandler);
        butt0.setTag(Integer.valueOf(5));

        butt6 = (ImageButton) findViewById(R.id.button6);
        butt6.setOnClickListener(imageButtonHandler);
        butt0.setTag(Integer.valueOf(6));

        butt7 = (ImageButton) findViewById(R.id.button7);
        butt7.setOnClickListener(imageButtonHandler);
        butt0.setTag(Integer.valueOf(7));

        butt8 = (ImageButton) findViewById(R.id.button8);
        butt8.setOnClickListener(imageButtonHandler);
        butt0.setTag(Integer.valueOf(8));

        playGame();
    }

    View.OnClickListener imageButtonHandler = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ImageButton butt = (ImageButton) view;
            // TextView winView = (TextView) findViewById(R.id.whoWon);

            switch (butt.getId()) {
                case R.id.button0:
                    // butt.setImageResource(R.drawable.cross);
                    setImageButton(0, isPressedPlayer);
                    TTT2.setMove(TTT2.HUMAN_PLAYER, 0);
                    turn = TTT2.COMPUTER_PLAYER;
                    break;
                case R.id.button1:
                    // butt.setImageResource(R.drawable.cross);
                    TTT2.setMove(TTT2.HUMAN_PLAYER, 1);
                    setImageButton(1, isPressedPlayer);
                    turn = TTT2.COMPUTER_PLAYER;
                    break;
                case R.id.button2:
                    // butt.setImageResource(R.drawable.cross);
                    TTT2.setMove(TTT2.HUMAN_PLAYER, 2);
                    setImageButton(2, isPressedPlayer);
                    turn = TTT2.COMPUTER_PLAYER;
                    break;
                case R.id.button3:
                    // butt.setImageResource(R.drawable.cross);
                    TTT2.setMove(TTT2.HUMAN_PLAYER, 3);
                    setImageButton(3, isPressedPlayer);
                    turn = TTT2.COMPUTER_PLAYER;
                    break;
                case R.id.button4:
                    // butt.setImageResource(R.drawable.cross);
                    TTT2.setMove(TTT2.HUMAN_PLAYER, 4);
                    setImageButton(4, isPressedPlayer);
                    turn = TTT2.COMPUTER_PLAYER;
                    break;
                case R.id.button5:
                    // butt.setImageResource(R.drawable.cross);
                    TTT2.setMove(TTT2.HUMAN_PLAYER, 5);
                    setImageButton(5, isPressedPlayer);
                    turn = TTT2.COMPUTER_PLAYER;
                    break;
                case R.id.button6:
                    // butt.setImageResource(R.drawable.cross);
                    TTT2.setMove(TTT2.HUMAN_PLAYER, 6);
                    setImageButton(6, isPressedPlayer);
                    turn = TTT2.COMPUTER_PLAYER;
                    break;
                case R.id.button7:
                    // butt.setImageResource(R.drawable.cross);
                    TTT2.setMove(TTT2.HUMAN_PLAYER, 7);
                    setImageButton(7, isPressedPlayer);
                    turn = TTT2.COMPUTER_PLAYER;
                    break;
                case R.id.button8:
                    // butt.setImageResource(R.drawable.cross);
                    TTT2.setMove(TTT2.HUMAN_PLAYER, 8);
                    setImageButton(8, isPressedPlayer);
                    turn = TTT2.COMPUTER_PLAYER;
                    break;
            }

            // playGame(view);

            /*while (win == 0) {
                if (turn == TTT2.COMPUTER_PLAYER) {
                    TTT2.setMove(TTT2.COMPUTER_PLAYER, TTT2.getComputerMove());
                    int tagValue = (Integer) butt.getTag();
                    if (tagValue == TTT2.getComputerMove()) {
                        butt.setImageResource(R.drawable.nought);
                    }
                    turn = TTT2.HUMAN_PLAYER;
                }
                win = TTT2.checkForWinner();
            }

            if (TTT2.checkForWinner()==2) {
                String winText = "'X' won! Play again?";
                winView.setText(winText);
            } else if (TTT2.checkForWinner()==3) {
                String winText2 = "'O' won! Play again?";
                winView.setText(winText2);
            } else if (TTT2.checkForWinner()==1) {
                String winText3 = "It's a TIE! Play again?";
                winView.setText(winText3);
            }*/

        }
    };

    public void playGame() {
        //ImageButton butt = (ImageButton) view;
        final TextView winView = (TextView) findViewById(R.id.whoWon);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                while (win == 0) {
                    if (turn == TTT2.HUMAN_PLAYER) {
                        // probably the missing link...
                    } else {
                        TTT2.setMove(TTT2.COMPUTER_PLAYER, TTT2.getComputerMove());
                /*int tagValue = (Integer) butt.getTag();
                if (tagValue == TTT2.getComputerMove()) {
                    butt.setImageResource(R.drawable.nought);
                } */
                        setImageButton(TTT2.getComputerMove(), isPressedComputer);
                        turn = TTT2.HUMAN_PLAYER;
                    }
                    win = TTT2.checkForWinner();
                }

                if (TTT2.checkForWinner() == 2) {
                    String winText = "'X' won! Play again?";
                    winView.setText(winText);
                } else if (TTT2.checkForWinner() == 3) {
                    String winText2 = "'O' won! Play again?";
                    winView.setText(winText2);
                } else if (TTT2.checkForWinner() == 1) {
                    String winText3 = "It's a TIE! Play again?";
                    winView.setText(winText3);
                }
            }
        });

        /*while (win == 0) {
            if (turn == TTT2.HUMAN_PLAYER) {
                // probably the missing link...
            } else {
                TTT2.setMove(TTT2.COMPUTER_PLAYER, TTT2.getComputerMove());
                *//*int tagValue = (Integer) butt.getTag();
                if (tagValue == TTT2.getComputerMove()) {
                    butt.setImageResource(R.drawable.nought);
                } *//*
                setImageButton(TTT2.getComputerMove(), isPressedComputer);
                turn = TTT2.HUMAN_PLAYER;
            }
            win = TTT2.checkForWinner();
        }

        if (TTT2.checkForWinner()==2) {
            String winText = "'X' won! Play again?";
            winView.setText(winText);
        } else if (TTT2.checkForWinner()==3) {
            String winText2 = "'O' won! Play again?";
            winView.setText(winText2);
        } else if (TTT2.checkForWinner()==1) {
            String winText3 = "It's a TIE! Play again?";
            winView.setText(winText3);
        }*/
    }

    public void setImageButton(int whichButt, boolean isPressed) {

        /*ImageButton butt = (ImageButton) view;
        for each (butt in buttons) {
            if (isPressedComputer) {
                butt.setImageResource(R.drawable.nought);
            } else if (isPressedPLayer) {
                butt.setImageResource(R.drawable.cross);
            } else {
                butt.setImageResource(R.drawable.empty);
            }
        }*/

        switch (whichButt) {
            case 0:
                if (isPressed == isPressedComputer) {
                    butt0.setImageResource(R.drawable.nought);
                } else if (isPressed == isPressedPlayer) {
                    butt0.setImageResource(R.drawable.cross);
                } else {
                    butt0.setImageResource(R.drawable.empty);
                }
                break;
            case 1:
                if (isPressed == isPressedComputer) {
                    butt1.setImageResource(R.drawable.nought);
                } else if (isPressed == isPressedPlayer) {
                    butt1.setImageResource(R.drawable.cross);
                } else {
                    butt1.setImageResource(R.drawable.empty);
                }
                break;
            case 2:
                if (isPressed == isPressedComputer) {
                    butt2.setImageResource(R.drawable.nought);
                } else if (isPressed == isPressedPlayer) {
                    butt2.setImageResource(R.drawable.cross);
                } else {
                    butt2.setImageResource(R.drawable.empty);
                }
                break;
            case 3:
                if (isPressed == isPressedComputer) {
                    butt3.setImageResource(R.drawable.nought);
                } else if (isPressed == isPressedPlayer) {
                    butt3.setImageResource(R.drawable.cross);
                } else {
                    butt3.setImageResource(R.drawable.empty);
                }
                break;
            case 4:
                if (isPressed == isPressedComputer) {
                    butt4.setImageResource(R.drawable.nought);
                } else if (isPressed == isPressedPlayer) {
                    butt4.setImageResource(R.drawable.cross);
                } else {
                    butt4.setImageResource(R.drawable.empty);
                }
                break;
            case 5:
                if (isPressed == isPressedComputer) {
                    butt5.setImageResource(R.drawable.nought);
                } else if (isPressed == isPressedPlayer) {
                    butt5.setImageResource(R.drawable.cross);
                } else {
                    butt5.setImageResource(R.drawable.empty);
                }
                break;
            case 6:
                if (isPressed == isPressedComputer) {
                    butt6.setImageResource(R.drawable.nought);
                } else if (isPressed == isPressedPlayer) {
                    butt6.setImageResource(R.drawable.cross);
                } else {
                    butt6.setImageResource(R.drawable.empty);
                }
                break;
            case 7:
                if (isPressed == isPressedComputer) {
                    butt7.setImageResource(R.drawable.nought);
                } else if (isPressed == isPressedPlayer) {
                    butt7.setImageResource(R.drawable.cross);
                } else {
                    butt7.setImageResource(R.drawable.empty);
                }
                break;
            case 8:
                if (isPressed == isPressedComputer) {
                    butt8.setImageResource(R.drawable.nought);
                } else if (isPressed == isPressedPlayer) {
                    butt8.setImageResource(R.drawable.cross);
                } else {
                    butt8.setImageResource(R.drawable.empty);
                }
                break;
        }
    }
}