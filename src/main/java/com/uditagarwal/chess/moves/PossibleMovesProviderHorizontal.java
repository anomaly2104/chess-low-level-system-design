package com.uditagarwal.chess.moves;

import com.uditagarwal.chess.model.Board;
import com.uditagarwal.chess.model.Cell;
import com.uditagarwal.chess.model.Piece;

import java.util.ArrayList;
import java.util.List;

public class PossibleMovesProviderHorizontal extends PossibleMovesProvider {

    public PossibleMovesProviderHorizontal(int maxSteps, MoveBaseCondition baseCondition) {
        super(maxSteps, baseCondition);
    }

    protected List<Cell> possibleMovesAsPerCurrentType(Piece piece, final Board board) {
        List<Cell> result = new ArrayList<>();
        result.addAll(findAllNextMoves(piece.getCurrentCell(), board::getLeftCell));
        result.addAll(findAllNextMoves(piece.getCurrentCell(), board::getRightCell));
        return result;
    }
}
