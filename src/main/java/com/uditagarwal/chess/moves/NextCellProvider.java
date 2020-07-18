package com.uditagarwal.chess.moves;

import com.uditagarwal.chess.model.Cell;

interface NextCellProvider {
    public Cell nextCell(Cell cell);
}
