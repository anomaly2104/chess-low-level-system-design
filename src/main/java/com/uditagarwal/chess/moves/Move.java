package com.uditagarwal.chess.moves;

import com.uditagarwal.chess.model.Cell;
import com.uditagarwal.chess.model.Piece;

public abstract class Move {
    final private int maxSteps;
    final private MoveBaseCondition moveBaseCondition;

    public Move (int maxSteps, MoveBaseCondition moveBaseCondition) {
        this.maxSteps = maxSteps;
        this.moveBaseCondition = moveBaseCondition;
    }

    public boolean isAllowed(Piece pieceToBeMoved, Cell toCell) {
        if (pieceToBeMoved.getCurrentCell().equals(toCell)) {
            return false;
        }
        if (moveBaseCondition.isBaseConditionFullfilled(pieceToBeMoved)) {
            return false;
        }
        if (getSteps(pieceToBeMoved.getCurrentCell(), toCell) > maxSteps) {
            return false;
        }
        return isValidMove(pieceToBeMoved.getCurrentCell(), toCell);
    }

    protected abstract boolean isValidMove(Cell fromCell, Cell toCell);
    protected abstract int getSteps(Cell fromCell, Cell toCell);
}
