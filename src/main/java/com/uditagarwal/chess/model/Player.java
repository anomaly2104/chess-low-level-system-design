package com.uditagarwal.chess.model;

import com.uditagarwal.chess.exceptions.PieceNotFoundException;
import com.uditagarwal.chess.model.PieceType;
import com.uditagarwal.gameplay.contracts.PlayerMove;
import com.uditagarwal.chess.model.Piece;

import java.util.List;

public abstract  class Player {

    List<Piece> pieces;
    public Piece getPiece(PieceType pieceType) {
        for (Piece piece :pieces) {
            if (piece.getPieceType() == pieceType) {
                return piece;
            }
        }
        throw new PieceNotFoundException();
    }
    abstract public PlayerMove makeMove();
}
