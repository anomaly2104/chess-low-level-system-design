package com.uditagarwal.chess.conditions;

import com.uditagarwal.chess.model.Board;
import com.uditagarwal.chess.model.Piece;

public interface MoveBaseCondition {
    boolean isBaseConditionFullfilled(Piece piece);
}
