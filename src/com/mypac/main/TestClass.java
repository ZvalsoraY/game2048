package com.mypac.main;

import com.mypac.board.Board;
import com.mypac.board.SquareBoard;
import com.mypac.game.Game;
import com.mypac.game.Game2048;

public class TestClass {
    public static void main(String[] args) {

        Board board = new SquareBoard(4);
        //Game game2048 = new Game2048(board);
        Game game2048 = new Game2048();
        System.out.println(game2048.canMove());

    }

}
