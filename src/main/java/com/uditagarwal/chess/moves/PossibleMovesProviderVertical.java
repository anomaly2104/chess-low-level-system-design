package com.uditagarwal.chess.moves;

import com.uditagarwal.chess.model.Board;
import com.uditagarwal.chess.model.Cell;
import com.uditagarwal.chess.model.Piece;

import java.util.ArrayList;
import java.util.List;


public class PossibleMovesProviderVertical extends PossibleMovesProvider {
    private VerticalMoveDirection verticalMoveDirection;

    public PossibleMovesProviderVertical(int maxSteps, MoveBaseCondition baseCondition, VerticalMoveDirection verticalMoveDirection) {
        super(maxSteps, baseCondition);
        this.verticalMoveDirection = verticalMoveDirection;
    }

    @Override
    protected List<Cell> possibleMovesAsPerCurrentType(Piece piece, Board board) {
        List<Cell> result = new ArrayList<>(findAllNextMoves(piece.getCurrentCell(), board::getUpCell));
        if (this.verticalMoveDirection == VerticalMoveDirection.BOTH) {
            result.addAll(findAllNextMoves(piece.getCurrentCell(), board::getDownCell));
        }
        return result;
    }
}
