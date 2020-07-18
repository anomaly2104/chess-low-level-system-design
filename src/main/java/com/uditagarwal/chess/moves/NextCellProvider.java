package com.uditagarwal.chess.moves;

import com.uditagarwal.chess.model.Cell;

/**
 * Given a cell, it will provide next cell which we can reach to.
 */
interface NextCellProvider {
    Cell nextCell(Cell cell);
}
