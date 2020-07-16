package com.uditagarwal.gameplay;

import com.uditagarwal.gameplay.contracts.PlayerMove;
import com.uditagarwal.chess.model.Piece;

import java.util.List;

public abstract  class Player {

    List<Piece> pieces;
    abstract public PlayerMove makeMove();
}
