package com.mypac.game;

import com.mypac.board.Board;
import com.mypac.direction.Direction;

import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static java.util.Arrays.asList;

public class Game2048 implements Game{

    GameHelper helper = new GameHelper();
    Board board;
    Random random = new Random();

    public Game2048(Board board) {
        this.board = board;
    }

    /**
     * Initiates the start of the game.
     */
    @Override
    public void init() {
        board.fillBoard(new ArrayList<>(Arrays.asList(null, 2, 4, 8)));

    }

    /**
     * Checks can we make a game move or not.
     * @return
     */
    @Override
    public boolean canMove() {
        return !board.availableSpace().isEmpty();
    }

    /**
     * Makes a game move in the indicated direction.
     * @param direction indicated direction
     * @return bool result of the move success ont not.
     */
    @Override
    public boolean move(Direction direction) {
        if (canMove() != false){
            switch (direction){
                case RIGHT -> {
                    helper.moveAndMergeEqual()
                }
                case LEFT -> {

                }
                case FORWARD -> {

                }
                case BACK -> {

                }
            }
            return true;
        }
        return false;
    }

    @Override
    public void addItem() {

    }

    @Override
    public Board getGameBoard() {
        return board;
    }

    @Override
    public boolean hasWin() {
        return false;
    }
}
