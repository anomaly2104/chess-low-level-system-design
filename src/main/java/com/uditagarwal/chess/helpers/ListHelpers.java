package com.uditagarwal.chess.helpers;

import java.util.ArrayList;
import java.util.List;

public class ListHelpers {
    public static <T> List<T> removeDuplicates(List<T> list) {
        List<T> newList = new ArrayList<T>();
        for (T element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }
}
