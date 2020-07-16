package com.uditagarwal.chess.moves;

import com.uditagarwal.chess.model.Board;
import com.uditagarwal.chess.model.Cell;
import com.uditagarwal.chess.model.Piece;

import java.util.ArrayList;
import java.util.List;

interface NextCellProvider {
    public Cell nextCell(Cell cell);
}

public abstract class PossibleMovesProvider {
    int maxSteps;
    MoveBaseCondition baseCondition;

    public PossibleMovesProvider (int maxSteps, MoveBaseCondition baseCondition) {
        this.maxSteps = maxSteps;
        this.baseCondition = baseCondition;
    }

    public List<Cell> possibleMoves(Piece piece, Board inBoard) {
        if (baseCondition.isBaseConditionFullfilled(piece)) {
            return possibleMovesAsPerCurrentType(piece, inBoard);
        }
        return null;
    }

    protected List<Cell> findAllNextMoves(Cell startCell, NextCellProvider nextCellProvider) {
        List<Cell> result = new ArrayList<>();
        Cell nextCell = nextCellProvider.nextCell(startCell);
        int numSteps = 1;
        while (nextCell != null && numSteps <= maxSteps) {
            result.add(nextCell);
            nextCell = nextCellProvider.nextCell(nextCell);
            numSteps++;
        }
        return result;
    }

    protected abstract List<Cell> possibleMovesAsPerCurrentType(Piece piece, Board board);
}
