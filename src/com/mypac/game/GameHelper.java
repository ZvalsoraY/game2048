package com.mypac.game;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class GameHelper {
    public List<Integer> moveAndMergeEqual(List<Integer> list) {
        var reslistsize = list.size();
        List<Integer> reslist = new ArrayList<Integer>(reslistsize);

        if(list.isEmpty()){
            return reslist;
        }

        List<Integer> listextnull = new ArrayList<>();
        for (Integer i : list) {
            if (i != null){
                listextnull.add(i);
            }
        }
        var listextnullsize = listextnull.size();

        for (int i = 0; i < reslistsize; i++) {
            if(i < listextnullsize){
                var curval = listextnull.get(i);
                if (i < listextnullsize - 1 && curval == listextnull.get(i+1)){
                    reslist.add(curval * 2);
                    i++;
                    reslistsize ++;///
                } else {
                    reslist.add(curval);
                }
            } else {
                reslist.add(null);
            }

        }
        //ListIterator<Integer> iteratorini = list.listIterator();

        return reslist;
    }
}