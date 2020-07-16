package com.uditagarwal.chess.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@EqualsAndHashCode
public class Cell {

    private int x;
    private int y;

    //TODO: Ensure that this does not get used in equals.
    @Setter
    private Piece currentPiece;


}
