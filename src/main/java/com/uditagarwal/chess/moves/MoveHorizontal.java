package com.uditagarwal.chess.moves;

import com.uditagarwal.chess.model.Cell;

public class MoveHorizontal extends Move {

    public MoveHorizontal(int maxSteps, MoveBaseCondition moveBaseCondition) {
        super(maxSteps, moveBaseCondition);
    }

    protected boolean isValidMove(Cell fromCell, Cell toCell) {
        return fromCell.getY() == toCell.getY();
    }

    protected int getSteps(Cell fromCell, Cell toCell) {
        return Math.abs(fromCell.getX() - toCell.getX());
    }
}
