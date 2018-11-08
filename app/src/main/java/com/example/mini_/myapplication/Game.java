package com.example.mini_.myapplication;

import android.service.quicksettings.Tile;
import android.widget.Button;

import java.io.Serializable;

public class Game implements Serializable {

    final private int BOARD_SIZE = 3;
    private TileState[][] board;

    private Boolean playerOneTurn;  // true if player 1's turn, false if player 2's turn
    private int movesPlayed;
    private Boolean gameOver;

    public Game() {
        board = new TileState[BOARD_SIZE][BOARD_SIZE];
        for(int i=0; i<BOARD_SIZE; i++)
            for(int j=0; j<BOARD_SIZE; j++)
                board[i][j] = TileState.BLANK;

        playerOneTurn = true;
        gameOver = false;
    }

    public TileState choose(int row, int column) {
        TileState state = board[row][column];
        if (state == TileState.BLANK) {
            if (playerOneTurn) {
                board[row][column] = TileState.CROSS;
                playerOneTurn = false;
                return TileState.CROSS;
            } else {
                board[row][column] = TileState.CIRCLE;
                playerOneTurn = true;
                return TileState.CIRCLE;
            }
        } else {
            return TileState.INVALID;
        }
    }

    public GameState won(int curRow, int curColumn) {
        // Check if player one or two has won the game.
        TileState cross = TileState.CROSS;
        TileState circle = TileState.CIRCLE;
        int n = 3;

        // check if any horizontal wins are made.
        int countCross = 0;
        int countCircle = 0;
        for (int col = 0; col < n; ++col) {
            if (board[curRow][col] == cross) {
                countCross++;
                if (countCross == n) {
                    return GameState.PLAYER_ONE;
                }
            }
            if (board[curRow][col] == circle) {
                countCircle++;
                if (countCircle == n) {
                    return GameState.PLAYER_TWO;
                }
            }
        }

        // check if any vertical wins are made.
        countCross = 0;
        countCircle = 0;
        for (int row = 0; row < n; ++row) {
            if (board[row][curColumn] == cross) {
                countCross++;
                if (countCross == n) {
                    return GameState.PLAYER_ONE;
                }
            }
            if (board[row][curColumn] == circle) {
                countCircle++;
                if (countCircle == n) {
                    return GameState.PLAYER_TWO;
                }
            }
        }

        // check if any diagonal from 0,0 to 2,2 is made.
        countCross = 0;
        countCircle = 0;
        for (int diag = 0; diag < n; ++diag) {
            if (board[diag][diag] == cross) {
                countCross++;
                if (countCross == n) {
                    return GameState.PLAYER_ONE;
                }
            }
            if (board[diag][diag] == circle) {
                countCircle++;
                if (countCircle == n) {
                    return GameState.PLAYER_TWO;
                }
            }
        }

        // check if any diagonal from 2,0 to 0,2 is made.
        countCross = 0;
        countCircle = 0;
        int rowCross = 0;
        int colCross = 2;
        int rowCircle = 0;
        int colCircle = 2;
        for (int ok = 0; ok < n; ++ok) {
            if (board[rowCross][colCross] == cross) {
                countCross++;
                rowCross++;
                colCross--;
                if (countCross == n) {
                    return GameState.PLAYER_ONE;
                }
            }
            if (board[rowCircle][colCircle] == circle) {
                countCircle++;
                rowCircle++;
                colCircle--;
                if (countCircle == n) {
                    return GameState.PLAYER_TWO;
                }
            }
        }

        // check for a draw
        int countDraw = 0;
        for (int searchRow = 0; searchRow < n; ++searchRow) {
            for (int searchCol = 0; searchCol < n; ++searchCol) {
                if (board[searchRow][searchCol] != TileState.BLANK)
                    countDraw++;
            }
        }
        if (countDraw == 9) {
            return GameState.DRAW;
        }

        // if none of the above is reached, the game is still going
        return GameState.IN_PROGRESS;
    }
}
