package com.uditagarwal.chess.conditions;

import com.uditagarwal.chess.model.Piece;

public class NoMoveBaseCondition implements MoveBaseCondition {
    public boolean isBaseConditionFullfilled(Piece piece) {
        return true;
    }
}
