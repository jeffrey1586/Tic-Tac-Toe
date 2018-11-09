package com.example.mini_.myapplication;

import android.opengl.Visibility;
import android.service.quicksettings.Tile;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.Serializable;


public class MainActivity extends AppCompatActivity {

    Game game;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null){
            game = new Game();
        }

        String sign;
        TextView text;
        // check if there are any states saved.
        if (savedInstanceState != null) {

            // restore the previous game
            game = (Game) savedInstanceState.getSerializable("oldGame");

            // recovers the states of the nine buttons.
            sign = (String) savedInstanceState.getSerializable("buttonOne");
            text = (TextView) findViewById(R.id.button1);
            text.setText(sign);
            sign = (String) savedInstanceState.getSerializable("buttonTwo");
            text = (TextView) findViewById(R.id.button2);
            text.setText(sign);
            sign = (String) savedInstanceState.getSerializable("buttonThree");
            text = (TextView) findViewById(R.id.button3);
            text.setText(sign);
            sign = (String) savedInstanceState.getSerializable("buttonFour");
            text = (TextView) findViewById(R.id.button4);
            text.setText(sign);
            sign = (String) savedInstanceState.getSerializable("buttonFive");
            text = (TextView) findViewById(R.id.button5);
            text.setText(sign);
            sign = (String) savedInstanceState.getSerializable("buttonSix");
            text = (TextView) findViewById(R.id.button6);
            text.setText(sign);
            sign = (String) savedInstanceState.getSerializable("buttonSeven");
            text = (TextView) findViewById(R.id.button7);
            text.setText(sign);
            sign = (String) savedInstanceState.getSerializable("buttonEight");
            text = (TextView) findViewById(R.id.button8);
            text.setText(sign);
            sign = (String) savedInstanceState.getSerializable("buttonNine");
            text = (TextView) findViewById(R.id.button9);
            text.setText(sign);

            // if end of game was reached, recover the winner text (or draw).
            int textPlayerOne = (int) savedInstanceState.getSerializable("textPlayerOne");
            TextView viewOne = (TextView) findViewById(R.id.playerOne);
            viewOne.setVisibility(textPlayerOne);
            int textPlayerTwo = (int) savedInstanceState.getSerializable("textPlayerTwo");
            TextView viewTwo = (TextView) findViewById(R.id.playerTwo);
            viewTwo.setVisibility(textPlayerTwo);
            int textPlayerDraw = (int) savedInstanceState.getSerializable("textPlayerDraw");
            TextView viewDraw = (TextView) findViewById(R.id.playerDraw);
            viewDraw.setVisibility(textPlayerDraw);

            // if end of game was reached, this will recover restart text en disable buttons.
            if(textPlayerOne == View.VISIBLE || textPlayerTwo == View.VISIBLE
                    || textPlayerDraw == View.VISIBLE) {
                TextView textNewGame = (TextView) findViewById(R.id.pressNewGame);
                textNewGame.setVisibility(View.VISIBLE);
                buttonOut();
            }
        }
    }

    // this method disables all the game buttons.
    public void buttonOut() {
        Button but1 = (Button) findViewById(R.id.button1);
        but1.setEnabled(false);
        Button but2 = (Button) findViewById(R.id.button2);
        but2.setEnabled(false);
        Button but3 = (Button) findViewById(R.id.button3);
        but3.setEnabled(false);
        Button but4 = (Button) findViewById(R.id.button4);
        but4.setEnabled(false);
        Button but5 = (Button) findViewById(R.id.button5);
        but5.setEnabled(false);
        Button but6 = (Button) findViewById(R.id.button6);
        but6.setEnabled(false);
        Button but7 = (Button) findViewById(R.id.button7);
        but7.setEnabled(false);
        Button but8 = (Button) findViewById(R.id.button8);
        but8.setEnabled(false);
        Button but9 = (Button) findViewById(R.id.button9);
        but9.setEnabled(false);
    }

    // this method may draw a 'X' or 'O' on the pressed button.
    public void drawSign(TileState state, int id) {
        switch (state) {
            case CROSS:
                TextView textCross = (TextView) findViewById(id);
                textCross.setText("X");
                break;
            case CIRCLE:
                TextView textCircle = (TextView) findViewById(id);
                textCircle.setText("O");
                break;
            case INVALID:
                break;
        }
    }

    //this method checks if there is a winner.
    public void drawWinner(GameState winner) {
        TextView textNewGame = (TextView) findViewById(R.id.pressNewGame);
        TextView text;
        switch (winner) {
            case IN_PROGRESS:
                break;
            case PLAYER_ONE:
                // show player 1 won
                text = (TextView) findViewById(R.id.playerOne);
                text.setVisibility(View.VISIBLE);
                textNewGame.setVisibility(View.VISIBLE);
                buttonOut();
                break;
            case PLAYER_TWO:
                // show player 2 won
                text = (TextView) findViewById(R.id.playerTwo);
                text.setVisibility(View.VISIBLE);
                textNewGame.setVisibility(View.VISIBLE);
                buttonOut();
                break;
            case DRAW:
                // show game was draw
                text = (TextView) findViewById(R.id.playerDraw);
                text.setVisibility(View.VISIBLE);
                textNewGame.setVisibility(View.VISIBLE);
                buttonOut();
                break;
        }
    }

    // this method is called when one of the game buttons is pressed.
    public void tileClicked(View view) {
        int id = view.getId();
        TileState state;
        GameState winner;

        switch (id) {
            case R.id.button1:
                state = game.choose(0, 0);
                drawSign(state, id);
                winner = game.won(0, 0);
                drawWinner(winner);
                break;
            case R.id.button2:
                state = game.choose(0, 1);
                drawSign(state, id);
                winner = game.won(0, 1);
                drawWinner(winner);
                break;
            case R.id.button3:
                state = game.choose(0, 2);
                drawSign(state, id);
                winner = game.won(0, 2);
                drawWinner(winner);
                break;
            case R.id.button4:
                state = game.choose(1, 0);
                drawSign(state, id);
                winner = game.won(1, 0);
                drawWinner(winner);
                break;
            case R.id.button5:
                state = game.choose(1, 1);
                drawSign(state, id);
                winner = game.won(1, 1);
                drawWinner(winner);
                break;
            case R.id.button6:
                state = game.choose(1,2);
                drawSign(state, id);
                winner = game.won(1,2);
                drawWinner(winner);
                break;
            case R.id.button7:
                state = game.choose(2, 0);
                drawSign(state, id);
                winner = game.won(2, 0);
                drawWinner(winner);
                break;
            case R.id.button8:
                state = game.choose(2, 1);
                drawSign(state, id);
                winner = game.won(2, 1);
                drawWinner(winner);
                break;
            case R.id.button9:
                state = game.choose(2, 2);
                drawSign(state, id);
                winner = game.won(2, 2);
                drawWinner(winner);
                break;
        }
    }

    // this method is called when the reset button is pressed.
    public void resetClicked(View view) {
        game = new Game();
        setContentView(R.layout.activity_main);
    }

    // this method is used to get the text of any button.
    public String putState(int id) {
        TextView State = (TextView)findViewById(id);
        String saveText = State.getText().toString();
        return saveText;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // this saves the current states of the buttons.
        String saveTextOne = putState(R.id.button1);
        outState.putSerializable("buttonOne", saveTextOne);
        String saveTextTwo = putState(R.id.button2);
        outState.putSerializable("buttonTwo", saveTextTwo);
        String saveTextThree = putState(R.id.button3);
        outState.putSerializable("buttonThree", saveTextThree);
        String saveTextFour = putState(R.id.button4);
        outState.putSerializable("buttonFour", saveTextFour);
        String saveTextFive = putState(R.id.button5);
        outState.putSerializable("buttonFive", saveTextFive);
        String saveTextSix = putState(R.id.button6);
        outState.putSerializable("buttonSix", saveTextSix);
        String saveTextSeven = putState(R.id.button7);
        outState.putSerializable("buttonSeven", saveTextSeven);
        String saveTextEight = putState(R.id.button8);
        outState.putSerializable("buttonEight", saveTextEight);
        String saveTextNine = putState(R.id.button9);
        outState.putSerializable("buttonNine", saveTextNine);

        // save the game in outState
        outState.putSerializable("oldGame", game);

        // saves the state of the text views.
        TextView textOne = (TextView) findViewById(R.id.playerOne);
        int text1 = textOne.getVisibility();
        outState.putSerializable("textPlayerOne", text1);
        TextView textTwo = (TextView) findViewById(R.id.playerTwo);
        int text2 = textTwo.getVisibility();
        outState.putSerializable("textPlayerTwo", text2);
        TextView textDraw = (TextView) findViewById(R.id.playerDraw);
        int text0 = textDraw.getVisibility();
        outState.putSerializable("textPlayerDraw", text0);
    }
}
