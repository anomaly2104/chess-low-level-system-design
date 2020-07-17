package com.uditagarwal.chess.moves;

import com.uditagarwal.chess.conditions.PieceCellOccupyBlocker;
import com.uditagarwal.chess.conditions.PieceMoveFurtherCondition;
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
    PieceMoveFurtherCondition moveFurtherCondition;

    public PossibleMovesProvider(int maxSteps, MoveBaseCondition baseCondition, PieceMoveFurtherCondition moveFurtherCondition) {
        this.maxSteps = maxSteps;
        this.baseCondition = baseCondition;
        this.moveFurtherCondition = moveFurtherCondition;
    }

    public List<Cell> possibleMoves(Piece piece, Board inBoard, List<PieceCellOccupyBlocker> cellOccupyBlockers) {
        if (baseCondition.isBaseConditionFullfilled(piece)) {
            return possibleMovesAsPerCurrentType(piece, inBoard, cellOccupyBlockers);
        }
        return null;
    }

    protected List<Cell> findAllNextMoves(Piece piece, NextCellProvider nextCellProvider, Board board, List<PieceCellOccupyBlocker> cellOccupyBlockers) {
        List<Cell> result = new ArrayList<>();
        Cell nextCell = nextCellProvider.nextCell(piece.getCurrentCell());
        int numSteps = 1;
        while (nextCell != null && numSteps <= maxSteps) {
            if (checkIfCellCanBeOccupied(piece, nextCell, board, cellOccupyBlockers)) {
                result.add(nextCell);
            }
            if (!moveFurtherCondition.canPieceMoveFurtherFromCell(piece, nextCell, board)) {
                break;
            }

            nextCell = nextCellProvider.nextCell(nextCell);
            numSteps++;
        }
        return result;
    }

    private boolean checkIfCellCanBeOccupied(Piece piece, Cell cell, Board board, List<PieceCellOccupyBlocker> cellOccupyBlockers) {
        for (PieceCellOccupyBlocker cellOccupyBlocker : cellOccupyBlockers) {
            if (cellOccupyBlocker.isCellNonOccupiableForPiece(cell, piece, board)) {
                return false;
            }
        }
        return true;
    }

    protected abstract List<Cell> possibleMovesAsPerCurrentType(Piece piece, Board board, List<PieceCellOccupyBlocker> cellOccupyBlockers);
}
