package com.uditagarwal.chess.moves;

import com.uditagarwal.chess.conditions.MoveBaseCondition;
import com.uditagarwal.chess.conditions.PieceCellOccupyBlocker;
import com.uditagarwal.chess.conditions.PieceMoveFurtherCondition;
import com.uditagarwal.chess.model.Board;
import com.uditagarwal.chess.model.Cell;
import com.uditagarwal.chess.model.Piece;

import java.util.ArrayList;
import java.util.List;

public class PossibleMovesProviderHorizontal extends PossibleMovesProvider {

    public PossibleMovesProviderHorizontal(int maxSteps, MoveBaseCondition baseCondition,
                                           PieceMoveFurtherCondition moveFurtherCondition) {
        super(maxSteps, baseCondition, moveFurtherCondition);
    }

    protected List<Cell> possibleMovesAsPerCurrentType(Piece piece, final Board board, List<PieceCellOccupyBlocker> cellOccupyBlockers) {
        List<Cell> result = new ArrayList<>();
        result.addAll(findAllNextMoves(piece, board::getLeftCell, board, cellOccupyBlockers));
        result.addAll(findAllNextMoves(piece, board::getRightCell, board, cellOccupyBlockers));
        return result;
    }
}
