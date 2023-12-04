package com.mypac.game;

import com.mypac.board.Board;
import com.mypac.direction.Direction;
import com.mypac.key.Key;

import javax.swing.event.ChangeListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
                    for (int j = 0; j < board.getWidth(); j++) {
                        //helper.moveAndMergeEqual(board.getRow(j))
                    }
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

    /**
     * Adds a new element to the game.
     */
    @Override
    public void addItem() {
        List<Key> freeSpaceKeys = board.availableSpace();
        if(!freeSpaceKeys.isEmpty()){
            Key keySpace = freeSpaceKeys.get(random.nextInt(freeSpaceKeys.size()));
            int n = random.nextInt(10) + 1;
            if(n == 10){
                board.addItem(keySpace,4);
            } else {
                board.addItem(keySpace,2);
            }
        }

    }

    /**
     * Getting the playing field.
     * @return board Board
     */
    @Override
    public Board getGameBoard() {
        return board;
    }

    /**
     * Winning the game.
     * @return true if win.
     */
    @Override
    public boolean hasWin() {
        return board.hasValue(2048);
    }
}
