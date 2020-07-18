package com.uditagarwal.chess.helpers;

import java.util.ArrayList;
import java.util.List;

/**
 * Helper class related to {@link List}.
 */
public class ListHelpers {

    /**
     * Helper method to remove duplicate objects from a list.
     *
     * @param list List from which duplicated have to be removed.
     * @return List without duplicates.
     */
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
