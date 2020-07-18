package com.uditagarwal.chess.model;

import com.uditagarwal.chess.conditions.PieceCellOccupyBlocker;
import lombok.Getter;

import java.util.List;

import static com.uditagarwal.chess.conditions.PieceCellOccupyBlockerFactory.kingCheckEvaluationBlockers;

/**
 * Model object for a board of chess game. A board has a size and a grid of cells.
 */
@Getter
public class Board {
    int boardSize;
    Cell[][] cells;

    public Board(int boardSize, Cell[][] cells) {
        this.boardSize = boardSize;
        this.cells = cells;
    }

    /**
     * Helper method to return cell to the left of current cell.
     */
    public Cell getLeftCell(Cell cell) {
        return getCellAtLocation(cell.getX(), cell.getY() - 1);
    }

    /**
     * Helper method to return cell to the right of current cell.
     */
    public Cell getRightCell(Cell cell) {
        return getCellAtLocation(cell.getX(), cell.getY() + 1);
    }

    /**
     * Helper method to return cell to the up of current cell.
     */
    public Cell getUpCell(Cell cell) {
        return getCellAtLocation(cell.getX() + 1, cell.getY());
    }

    /**
     * Helper method to return cell to the down of current cell.
     */
    public Cell getDownCell(Cell cell) {
        return getCellAtLocation(cell.getX() - 1, cell.getY());
    }

    /**
     * Helper method to return cell at a given location.
     */
    public Cell getCellAtLocation(int x, int y) {
        if (x >= boardSize || x < 0) {
            return null;
        }
        if (y >= boardSize || y < 0) {
            return null;
        }

        return cells[x][y];
    }

    /**
     * Helper method to determine whether the player is on check on the current board.
     */
    public boolean isPlayerOnCheck(Player player) {
        return checkIfPieceCanBeKilled(player.getPiece(PieceType.KING), kingCheckEvaluationBlockers(), player);
    }

    /**
     * Method to check if the piece can be killed currently by the opponent as per the current board configuration.
     *
     * @param targetPiece        Piece which is to be checked.
     * @param cellOccupyBlockers Blockers which make cell non occupiable.
     * @param player             Player whose piece has to be checked.
     * @return Boolean indicating whether the piece is in danger or not.
     */
    public boolean checkIfPieceCanBeKilled(Piece targetPiece, List<PieceCellOccupyBlocker> cellOccupyBlockers, Player player) {
        for (int i = 0; i < getBoardSize(); i++) {
            for (int j = 0; j < getBoardSize(); j++) {
                Piece currentPiece = getCellAtLocation(i, j).getCurrentPiece();
                if (currentPiece != null && !currentPiece.isPieceFromSamePlayer(targetPiece)) {
                    List<Cell> nextPossibleCells = currentPiece.nextPossibleCells(this, cellOccupyBlockers, player);
                    if (nextPossibleCells.contains(targetPiece.getCurrentCell())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
