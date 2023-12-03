package com.mypac.board;

import com.mypac.key.Key;
import com.mypac.game.Game2048;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class SquareBoard extends Board{

    public SquareBoard(int size) {
        super(size, size);
    }

    /**
     * Filling the board from List.
     * @param list nubers for board filling
     */
    @Override
    public void fillBoard(List<Integer> list) {
        board.clear();
        int ilist = 0;
        int listsize = list.size();
        for (int i = 0; i < width; i++){
            for (int j = 0; j < height; j++){
                if(ilist < listsize){
                    board.put(new Key(i, j), list.get(ilist++));
                } else{
                    board.put(new Key(i, j), null); //make error or break
                }
            }
        }

    }

    /**
     * Provide list free spaces for board.
     * @return ArrayList of free spaces
     */
    @Override
    public List<Key> availableSpace() {
        List<Key> listkeyspace = new ArrayList<Key>();
        for (var entry : board.entrySet()) {
            if (entry.getValue() == null){
                listkeyspace.add(entry.getKey());
            }
        }
        return listkeyspace;
    }

    /**
     * Add element on the board by key.
     * @param key
     * @param value
     */
    @Override
    public void addItem(Key key, Integer value) {
        board.put(key, value);
    }

    /**
     * Find key by coordinate.
     * @param i
     * @param j
     * @return key if it was found or null
     */
    @Override
    public Key getKey(int i, int j) {
        var checkkey = new Key(i,j);
        if (board.containsKey(checkkey)){
            return checkkey;
        }
        return null;
    }

    /**
     * Provide value by key.
     * @param key
     * @return
     */
    @Override
    public Integer getValue(Key key) {
        return board.get(key);
    }

    /**
     * Key column by which values can be selected.
     * @param j number of column
     * @return ArrayList of key by j column
     */
    @Override
    public List<Key> getColumn(int j) {
        List<Key> listkeycol = new ArrayList<Key>();
        for(int i = 0; i < width; i++){
            listkeycol.add(getKey(i, j)); // check getKey
        }
        return listkeycol;
    }

    /**
     * String of keys by which you can then select values.
     * @param i number of row
     * @return ArrayList of key by i row
     */
    @Override
    public List<Key> getRow(int i) {
        List<Key> listkeyrow = new ArrayList<Key>();
        for (int j = 0; j < height; j++){
            listkeyrow.add(getKey(i, j)); // check getKey
        }
        return listkeyrow;
    }

    /**
     * Checking for the presence of this value in the board field.
     * @param value
     * @return
     */
    @Override
    public boolean hasValue(Integer value) {
        return board.containsValue(value);
    }

    /**
     * String of values by string of keys
     * @param keys
     * @return ArrayList of values
     */
    @Override
    public List<Integer> getValues(List<Key> keys) {
        List<Integer> values = new ArrayList<Integer>();
        for (ListIterator<Key> keysiterator = keys.listIterator(); keysiterator.hasNext(); ) {
            //Key elementkey = keysiterator.next();
            values.add(board.get(keysiterator.next()));
        }
        return values;
    }
}
