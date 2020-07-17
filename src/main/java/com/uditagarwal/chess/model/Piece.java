package com.uditagarwal.chess.model;

import com.uditagarwal.chess.conditions.PieceCellOccupyBlocker;
import com.uditagarwal.chess.exceptions.InvalidMoveException;
import com.uditagarwal.chess.moves.PossibleMovesProvider;
import com.uditagarwal.gameplay.Player;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Piece {
    private boolean isKilled = false;
    private final Color color;
    private final List<PossibleMovesProvider> movesProviders;
    private Integer numMoves = 0;
    Player player;
    PieceType pieceType;

    @Setter
    @NonNull
    private Cell currentCell;

    public Piece(@NonNull final Color color, @NonNull final List<PossibleMovesProvider> movesProviders,
                 @NonNull final Player player, @NonNull final PieceType pieceType, @NonNull final Cell currentCell) {
        this.color = color;
        this.movesProviders = movesProviders;
        this.player = player;
        this.pieceType = pieceType;
        this.currentCell = currentCell;
    }

    public void killIt() {
        this.isKilled = true;
    }

    public void move(Cell toCell, Board board, List<PieceCellOccupyBlocker> cellOccupyBlockers) {
        if (isKilled) {
            throw new InvalidMoveException();
        }
        List<Cell> nextPossibleCells = nextPossibleCells(board, cellOccupyBlockers);
        if (!nextPossibleCells.contains(toCell)) {
            throw new InvalidMoveException();
        }

        killPieceInCell(toCell);
        this.currentCell.setCurrentPiece(null);
        this.currentCell = toCell;
        this.numMoves ++;
    }

    private void killPieceInCell(Cell targetCell) {
        if (targetCell.getCurrentPiece() != null) {
            targetCell.getCurrentPiece().killIt();
        }
    }

    public List<Cell> nextPossibleCells(Board board, List<PieceCellOccupyBlocker> cellOccupyBlockers) {
        List<Cell> result = new ArrayList<>();
        for (PossibleMovesProvider movesProvider: this.movesProviders) {
            List<Cell> cells = movesProvider.possibleMoves(this, board, cellOccupyBlockers);
            if (cells != null) {
                result.addAll(cells);
            }
        }
        return result;
    }

    public boolean isPieceFromSamePlayer(Piece piece) {
        return piece.getPlayer().equals(this.player);
    }
}
