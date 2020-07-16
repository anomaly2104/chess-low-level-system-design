package com.uditagarwal.chess.moves;

import com.uditagarwal.chess.model.Cell;

public class MoveKnight extends Move {

    public MoveKnight(int maxSteps, MoveBaseCondition moveBaseCondition) {
        super(maxSteps, moveBaseCondition);
    }

    protected boolean isValidMove(Cell fromCell, Cell toCell) {
        int xDiff = Math.abs(fromCell.getX() - toCell.getX());
        int yDiff = Math.abs(fromCell.getY() - toCell.getY());
        return (xDiff == 1 && yDiff == 2) || (xDiff == 2 && yDiff == 1);
    }

    // Knight always moves 3
    protected int getSteps(Cell fromCell, Cell toCell) {
        return 3;
    }
}
