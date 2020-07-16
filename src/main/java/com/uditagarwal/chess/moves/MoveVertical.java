package com.uditagarwal.chess.moves;

import com.uditagarwal.chess.model.Cell;

enum MoveVerticalDirection {
    UP,
    BOTH
}

public class MoveVertical extends Move {

    private MoveVerticalDirection direction;

    public MoveVertical(int maxSteps, MoveBaseCondition moveBaseCondition, MoveVerticalDirection direction) {
        super(maxSteps, moveBaseCondition);
        this.direction = direction;
    }

    protected boolean isValidMove(Cell fromCell, Cell toCell) {
        if (direction == MoveVerticalDirection.BOTH) {
            return fromCell.getX() == toCell.getX();
        }

        return fromCell.getX() == toCell.getX() && fromCell.getY() < toCell.getY();
    }

    protected int getSteps(Cell fromCell, Cell toCell) {
        return Math.abs(fromCell.getY() - toCell.getY());
    }
}
