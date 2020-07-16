package com.uditagarwal.chess.moves;

import com.uditagarwal.chess.model.Board;
import com.uditagarwal.chess.model.Cell;
import com.uditagarwal.chess.model.Piece;

import java.util.List;

public class PossibleMovesProviderDiagonal extends PossibleMovesProvider {

    public PossibleMovesProviderDiagonal(int maxSteps, MoveBaseCondition baseCondition) {
        super(maxSteps, baseCondition);
    }

    @Override
    protected List<Cell> possibleMovesAsPerCurrentType(Piece piece, Board board) {
        return null;
    }
}
