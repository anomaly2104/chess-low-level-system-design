package com.uditagarwal.gameplay.contracts;

import com.uditagarwal.chess.model.Cell;
import com.uditagarwal.chess.model.Piece;
import lombok.Getter;

@Getter
public class PlayerMove {

    Piece piece;
    Cell toCell;
}
