package com.uditagarwal.chess.model;

import com.uditagarwal.chess.conditions.PieceCellOccupyBlocker;
import com.uditagarwal.chess.conditions.PieceCellOccupyBlockerFactory;
import com.uditagarwal.gameplay.Player;
import lombok.Getter;

import java.util.List;

import static com.uditagarwal.chess.conditions.PieceCellOccupyBlockerFactory.kingCheckEvaluationBlockers;

@Getter
public class Board {
    int boardSize;
    Cell[][] cells;

    public Board(int boardSize, Cell[][] cells) {
        this.boardSize = boardSize;
        this.cells = cells;
    }

    public Cell getLeftCell(Cell cell) {
        return getCellAtLocation(cell.getX() - 1, cell.getY());
    }

    public Cell getRightCell(Cell cell) {
        return getCellAtLocation(cell.getX() + 1, cell.getY());
    }

    public Cell getUpCell(Cell cell) {
        return getCellAtLocation(cell.getX(), cell.getY() + 1);
    }

    public Cell getDownCell(Cell cell) {
        return getCellAtLocation(cell.getX(), cell.getY() - 1);
    }

    public Cell getCellAtLocation(int x, int y) {
        if (x >= boardSize || x < 0) {
            return null;
        }
        if (y >= boardSize || y < 0) {
            return null;
        }

        return cells[x][y];
    }

    public boolean isPlayerOnCheck(Player player) {
        return checkIfPieceCanBeKilled(player.getPiece(PieceType.KING), kingCheckEvaluationBlockers());
    }

    public boolean checkIfPieceCanBeKilled(Piece targetPiece, List<PieceCellOccupyBlocker> cellOccupyBlockers) {
        for (int i = 0; i < getBoardSize(); i++) {
            for (int j = 0; j < getBoardSize(); j++) {
                Piece currentPiece = getCellAtLocation(i, j).getCurrentPiece();
                if (!currentPiece.isPieceFromSamePlayer(targetPiece)) {
                    List<Cell> nextPossibleCells = currentPiece.nextPossibleCells(this, cellOccupyBlockers);
                    if (nextPossibleCells.contains(targetPiece.getCurrentCell())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
