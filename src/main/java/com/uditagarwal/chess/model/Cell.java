package com.uditagarwal.chess.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

/**
 * Model class representing the single cell of a board. A cell has a location in the grid which is represented by x
 * and y location.
 */
@Getter
public class Cell {

    private int x;
    private int y;

    public Cell(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Setter
    private Piece currentPiece;

    public boolean isFree() {
        return currentPiece == null;
    }
}
