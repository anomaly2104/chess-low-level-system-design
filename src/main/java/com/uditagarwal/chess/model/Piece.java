package com.uditagarwal.chess.model;

import com.uditagarwal.chess.exceptions.InvalidMoveException;
import com.uditagarwal.chess.moves.PossibleMovesProvider;
import lombok.Getter;
import lombok.NonNull;
import sun.jvm.hotspot.gc.shared.Generation;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Piece {
    private boolean isKilled = false;
    private final Color color;
    private final List<PossibleMovesProvider> movesProviders;
    private Cell currentCell;
    private Integer numMoves = 0;

    public Piece(@NonNull final Color color, @NonNull final List<PossibleMovesProvider> movesProviders) {
        this.color = color;
        this.movesProviders = movesProviders;
    }

    public void killIt() {
        this.isKilled = true;
    }

    public void move(Cell toCell, Board board) {
        if (isKilled) {
            throw new InvalidMoveException();
        }
        List<Cell> nextPossibleCells = nextPossibleCells(board);
        if (!nextPossibleCells.contains(toCell)) {
            throw new InvalidMoveException();
        }

        killPieceInCell(toCell);
        this.currentCell.setCurrentPiece(null);
        this.currentCell = toCell;
        this.numMoves ++;
    }

    private void killPieceInCell(Cell targetCell) {
        //TODO: use killing strategy here and also check that piece here should be of opponent.
        if (targetCell.getCurrentPiece() != null) {
            targetCell.getCurrentPiece().killIt();
        }
    }

    public List<Cell> nextPossibleCells(Board board) {
        List<Cell> result = new ArrayList<>();
        for (PossibleMovesProvider movesProvider: this.movesProviders) {
            List<Cell> cells = movesProvider.possibleMoves(this, board);
            if (cells != null) {
                result.addAll(cells);
            }
        }
        return result;
    }
}
