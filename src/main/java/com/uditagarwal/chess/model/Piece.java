package com.uditagarwal.chess.model;

import com.uditagarwal.chess.exceptions.InvalidMoveException;
import com.uditagarwal.chess.moves.PossibleMovesProvider;
import lombok.Getter;
import lombok.NonNull;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Piece {
    private boolean isKilled = false;
    private Color color;
    private List<PossibleMovesProvider> movesProviders;
    private Cell currentCell;
    private Integer numMoves;

    public Piece(@NonNull final Color color, @NonNull final List<PossibleMovesProvider> movesProviders) {
        this.color = color;
        this.movesProviders = movesProviders;
    }

    public void killIt() {
        this.isKilled = true;
    }

    public void move(Cell toCell, Board board) {
        List<Cell> nextPossibleCells = nextPossibleCells(board);
        if (!nextPossibleCells.contains(toCell)) {
            throw new InvalidMoveException();
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
