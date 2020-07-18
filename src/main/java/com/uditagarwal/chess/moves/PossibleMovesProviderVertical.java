package com.uditagarwal.chess.moves;

import com.uditagarwal.chess.conditions.MoveBaseCondition;
import com.uditagarwal.chess.conditions.PieceCellOccupyBlocker;
import com.uditagarwal.chess.conditions.PieceMoveFurtherCondition;
import com.uditagarwal.chess.model.Board;
import com.uditagarwal.chess.model.Cell;
import com.uditagarwal.chess.model.Piece;

import java.util.ArrayList;
import java.util.List;


public class PossibleMovesProviderVertical extends PossibleMovesProvider {
    private VerticalMoveDirection verticalMoveDirection;

    public PossibleMovesProviderVertical(int maxSteps, MoveBaseCondition baseCondition,
                                         PieceMoveFurtherCondition moveFurtherCondition) {
        super(maxSteps, baseCondition, moveFurtherCondition);
    }


    @Override
    protected List<Cell> possibleMovesAsPerCurrentType(Piece piece, Board board, List<PieceCellOccupyBlocker> cellOccupyBlockers) {
        List<Cell> result = new ArrayList<>(findAllNextMoves(piece, board::getUpCell, board, cellOccupyBlockers));
        if (this.verticalMoveDirection == VerticalMoveDirection.BOTH) {
            result.addAll(findAllNextMoves(piece, board::getDownCell, board, cellOccupyBlockers));
        }
        return result;
    }
}
