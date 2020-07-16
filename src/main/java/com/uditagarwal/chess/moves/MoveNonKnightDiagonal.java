package com.uditagarwal.chess.moves;

import com.uditagarwal.chess.model.Cell;

public class MoveNonKnightDiagonal extends Move {

    public MoveNonKnightDiagonal(int maxSteps, MoveBaseCondition moveBaseCondition) {
        super(maxSteps, moveBaseCondition);
    }

    protected boolean isValidMove(Cell fromCell, Cell toCell) {
        int xDiff = Math.abs(fromCell.getX() - toCell.getX());
        int yDiff = Math.abs(fromCell.getY() - toCell.getY());

        return xDiff == yDiff;
    }

    protected int getSteps(Cell fromCell, Cell toCell) {
        return Math.abs(fromCell.getX() - toCell.getX());
    }
}
