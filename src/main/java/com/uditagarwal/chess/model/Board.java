package com.uditagarwal.chess.model;

import lombok.Getter;

import java.util.List;

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
}
