package com.uditagarwal.chess.conditions;

import com.uditagarwal.chess.model.Board;
import com.uditagarwal.chess.model.Cell;
import com.uditagarwal.chess.model.Piece;

public interface PieceMoveFurtherCondition {

    boolean canPieceMoveFurtherFromCell(Piece piece, Cell cell, Board board);
}
