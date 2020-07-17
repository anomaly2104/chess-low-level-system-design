package com.uditagarwal.chess.conditions;

import com.uditagarwal.chess.model.Board;
import com.uditagarwal.chess.model.Cell;
import com.uditagarwal.chess.model.Piece;
import com.uditagarwal.chess.model.PieceType;

import java.util.ArrayList;
import java.util.List;

import static com.uditagarwal.chess.conditions.PieceCellOccupyBlockerFactory.kingCheckEvaluationBlockers;

/**
 * This tells whether making piece move to a cell will attract check for king.
 */
public class PieceCellOccupyBlockerKingCheck implements PieceCellOccupyBlocker {

    @Override
    public boolean isCellNonOccupiableForPiece(final Cell cell, final Piece piece, final Board board) {
        Cell pieceOriginalCell = piece.getCurrentCell();
        piece.setCurrentCell(cell);
        boolean playerGettingCheckByMove = board.isPlayerOnCheck(piece.getPlayer());
        piece.setCurrentCell(pieceOriginalCell);
        return playerGettingCheckByMove;
    }
}
