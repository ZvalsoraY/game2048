package com.mypac.game;

import com.mypac.board.Board;
import com.mypac.direction.Direction;

public interface Game {

    void init();
    boolean canMove();
    boolean move(Direction direction);
    void addItem();
    Board getGameBoard();
    boolean hasWin();

}
