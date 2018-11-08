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
        game = new Game();
        String sign;
        TextView text;

        if (savedInstanceState != null) {
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

            int textPlayerOne = (int) savedInstanceState.getSerializable("textPlayerOne");
            TextView viewOne = (TextView) findViewById(R.id.playerOne);
            viewOne.setVisibility(textPlayerOne);

            int textPlayerTwo = (int) savedInstanceState.getSerializable("textPlayerTwo");
            TextView viewTwo = (TextView) findViewById(R.id.playerTwo);
            viewTwo.setVisibility(textPlayerTwo);

            int textPlayerDraw = (int) savedInstanceState.getSerializable("textPlayerDraw");
            TextView viewDraw = (TextView) findViewById(R.id.playerDraw);
            viewDraw.setVisibility(textPlayerDraw);

            if(textPlayerOne == View.VISIBLE || textPlayerTwo == View.VISIBLE
                    || textPlayerDraw == View.VISIBLE) {
                buttonOut();
                TextView textNewGame = (TextView) findViewById(R.id.pressNewGame);
                textNewGame.setVisibility(View.VISIBLE);
            }
        }
    }

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

    public void drawWinner(GameState winner) {
        TextView textNewGame = (TextView) findViewById(R.id.pressNewGame);
        switch (winner) {
            case IN_PROGRESS:
                break;
            case PLAYER_ONE:
                // show player 1 won
                TextView textOne = (TextView) findViewById(R.id.playerOne);
                textOne.setVisibility(View.VISIBLE);
                textNewGame.setVisibility(View.VISIBLE);
                buttonOut();
                break;
            case PLAYER_TWO:
                // show player 2 won
                TextView textTwo = (TextView) findViewById(R.id.playerTwo);
                textTwo.setVisibility(View.VISIBLE);
                textNewGame.setVisibility(View.VISIBLE);
                buttonOut();
                break;
            case DRAW:
                // show game was draw
                TextView textDraw = (TextView) findViewById(R.id.playerDraw);
                textDraw.setVisibility(View.VISIBLE);
                textNewGame.setVisibility(View.VISIBLE);
                buttonOut();
                break;
        }
    }

    public void tileClicked(View view) {
        int id = view.getId();
        int row = 0;
        int column = 0;
        TileState state;
        GameState winner;

        switch (id) {
            case R.id.button1:
                state = game.choose(row, column);
                drawSign(state, id);
                winner = game.won(row, column);
                drawWinner(winner);
                break;

            case R.id.button2:
                row = 0;
                column = 1;
                state = game.choose(row, column);
                drawSign(state, id);
                winner = game.won(row, column);
                drawWinner(winner);
                break;

            case R.id.button3:
                row = 0;
                column = 2;
                state = game.choose(row, column);
                drawSign(state, id);
                winner = game.won(row, column);
                drawWinner(winner);
                break;

            case R.id.button4:
                row = 1;
                column = 0;
                state = game.choose(row, column);
                drawSign(state, id);
                winner = game.won(row, column);
                drawWinner(winner);
                break;

            case R.id.button5:
                row = 1;
                column = 1;
                state = game.choose(row, column);
                drawSign(state, id);
                winner = game.won(row, column);
                drawWinner(winner);
                break;

            case R.id.button6:
                row = 1;
                column = 2;
                state = game.choose(row, column);
                drawSign(state, id);
                winner = game.won(row, column);
                drawWinner(winner);
                break;

            case R.id.button7:
                row = 2;
                column = 0;
                state = game.choose(row, column);
                drawSign(state, id);
                winner = game.won(row, column);
                drawWinner(winner);
                break;

            case R.id.button8:
                row = 2;
                column = 1;
                state = game.choose(row, column);
                drawSign(state, id);
                winner = game.won(row, column);
                drawWinner(winner);
                break;

            case R.id.button9:
                row = 2;
                column = 2;
                state = game.choose(row, column);
                drawSign(state, id);
                winner = game.won(row, column);
                drawWinner(winner);
                break;
        }
    }

    public void resetClicked(View view) {
        game = new Game();
        setContentView(R.layout.activity_main);
    }


    public String putState(int id) {
        TextView State = (TextView)findViewById(id);
        String saveText = State.getText().toString();
        return saveText;
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

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
