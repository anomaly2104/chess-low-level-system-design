package com.uditagarwal.chess.moves;

import com.uditagarwal.chess.model.Board;
import com.uditagarwal.chess.model.Piece;

public interface MoveBaseCondition {
    boolean isBaseConditionFullfilled(Piece piece);
}
