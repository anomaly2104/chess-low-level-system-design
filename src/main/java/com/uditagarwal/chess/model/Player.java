package com.uditagarwal.chess.model;

import com.uditagarwal.chess.exceptions.PieceNotFoundException;
import com.uditagarwal.chess.model.PieceType;
import com.uditagarwal.gameplay.contracts.PlayerMove;
import com.uditagarwal.chess.model.Piece;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class Player {
    List<Piece> pieces;

    public Player(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public Piece getPiece(PieceType pieceType) {
        for (Piece piece :getPieces()) {
            if (piece.getPieceType() == pieceType) {
                return piece;
            }
        }
        throw new PieceNotFoundException();
    }
    abstract public PlayerMove makeMove();
}
