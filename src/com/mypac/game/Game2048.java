package com.mypac.game;

import com.mypac.board.Board;
import com.mypac.board.SquareBoard;
import com.mypac.direction.Direction;
import com.mypac.key.Key;

import java.util.*;

public class Game2048 implements Game{
    public static final int GAME_SIZE = 4;
    private final Board<Key, Integer> board = new SquareBoard<>(GAME_SIZE);

    GameHelper helper = new GameHelper();
    //Board board;
    Random random = new Random();

    /*public Game2048(Board board) {
        this.board = board;
    }*/

    /**
     * Initiates the start of the game.
     */
    @Override
    public void init() {
        //board.fillBoard(new ArrayList<>(Arrays.asList(null, 2, 4, 8)));
        board.fillBoard(Collections.nCopies(GAME_SIZE * GAME_SIZE, null));
        for (int i = 0; i < 2; i++) {
            addItem();
        }
    }

    /**
     * Checks can we make a game move or not.
     * @return
     */
    @Override
    public boolean canMove() {
        if (!board.availableSpace().isEmpty()){
            return true;
        }
        for (int i = 0; i < board.getHeight(); i++) {
            var rowCurrent = board.getValues(board.getRow(i));
            if (!rowCurrent.equals(helper.moveAndMergeEqual(rowCurrent))){
                return true;
            }
        }
        for (int j = 0; j < board.getWidth(); j++) {
            var column = board.getValues(board.getColumn(j));
            if (!column.equals(helper.moveAndMergeEqual(column))){
                return true;
            }
        }
        return false;
    }

    /**
     * Makes a game move in the indicated direction.
     * @param direction indicated direction
     * @return bool result of the move success ont not.
     */
    @Override
    /*public boolean move(Direction direction) {
        if (canMove() != false){
            switch (direction){
                case RIGHT -> {
                    for (int j = 0; j < board.getHeight(); j++) {
                        var x = helper.moveAndMergeEqual(board.getValues( board.getRow(j)));
                        Collections.reverse(x);
                        for (int i = 0; i < x.size(); i++) {
                            board.addItem(board.getKey(i,j),x.get(i));
                        }
                    }
                }
                case LEFT -> {
                    for (int j = 0; j < board.getHeight(); j++) {
                        var x = helper.moveAndMergeEqual(board.getValues( board.getRow(j)));
                        for (int i = 0; i < x.size(); i++) {
                            board.addItem(board.getKey(i,j),x.get(i));
                        }
                    }
                }
                case FORWARD -> {
                    for (int i = 0; i < board.getWidth(); i++) {
                        var y = helper.moveAndMergeEqual(board.getValues( board.getColumn(i)));
                        for (int j = 0; j < y.size(); j++) {
                            board.addItem(board.getKey(i,j),y.get(j));
                        }
                    }
                }
                case BACK -> {
                    for (int i = 0; i < board.getWidth(); i++){
                        var y = helper.moveAndMergeEqual(board.getValues( board.getColumn(i)));
                        Collections.reverse(y);
                        for (int j = 0; j < y.size(); j++) {
                            board.addItem(board.getKey(i,j),y.get(j));
                        }
                    }
                }
            }
            return true;
        }
        return false;
    }*/
    public boolean move(Direction direction) {
        if (canMove() != false){
            switch (direction){
                case RIGHT -> {
                    for (int j = 0; j < board.getHeight(); j++) {
                        /*var x = helper.moveAndMergeEqual(board.getValues( board.getRow(j)));
                        Collections.reverse(x);
                        for (int i = 0; i < x.size(); i++) {
                            board.addItem(board.getKey(i,j),x.get(i));
                        }*/
                    }
                }
                case LEFT -> {
                    for (int i = 0; i < board.getHeight(); i++) {
                        List<Integer> rowLeft = helper.moveAndMergeEqual(board.getValues( board.getRow(i)));
                        for (int j = 0; j < rowLeft.size(); j++) {
                            board.addItem(board.getKey(i,j),rowLeft.get(j));
                        }
                    }
                    addItem();
                }
                case FORWARD -> {
                    for (int j = 0; j < board.getWidth(); j++) {
                        List<Integer> colForward = helper.moveAndMergeEqual(board.getValues( board.getColumn(j)));
                        for (int i = 0; i < colForward.size(); i++) {
                            board.addItem(board.getKey(i,j),colForward.get(i));
                        }
                    }
                }
                case BACK -> {
                    for (int j = 0; j < board.getWidth(); j++){
                        List<Integer> colBack = helper.moveAndMergeEqual(board.getValues( board.getColumn(j)));
                        /*Collections.reverse(colBack);
                        for (int i = 0; i < colBack.size(); i++) {
                            board.addItem(board.getKey(i,j),colBack.get(i));
                        }*/
                        Collections.reverse(colBack);
                        for (int i = colBack.size() - 1; i >-1; i--) {
                            board.addItem(board.getKey(i,j),colBack.get(i));
                        }
                    }
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
            int n = random.nextInt(1,11) ;
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
