package com.hyzsnt.onekeyhelp.module.index.bean;

import java.util.Comparator;

/**
 * Created by gao on 2016/12/18.
 */

public class PinyinComparator implements Comparator<SortCity> {


    @Override
    public int compare(SortCity o1, SortCity o2) {

        if (o1.getSortLetters().equals("@")
                || o2.getSortLetters().equals("#")) {
            return -1;
        } else if (o1.getSortLetters().equals("#")
                || o2.getSortLetters().equals("@")) {
            return 1;
        } else {
            return o1.getSortLetters().compareTo(o2.getSortLetters());
        }

    }
}
