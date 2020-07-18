package com.uditagarwal.chess.model;

import com.uditagarwal.chess.exceptions.PieceNotFoundException;
import com.uditagarwal.gameplay.contracts.PlayerMove;
import lombok.Getter;

import java.util.List;

/**
 * Abstract model class representing a player. This is abstract because we are not sure how player is going to make his
 * move. If the player is a local player, then he can move locally. A player can also be a network based player.
 * So, depending on the type of player, he can make move in its own way.
 */
@Getter
public abstract class Player {
    List<Piece> pieces;

    public Player(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public Piece getPiece(PieceType pieceType) {
        for (Piece piece : getPieces()) {
            if (piece.getPieceType() == pieceType) {
                return piece;
            }
        }
        throw new PieceNotFoundException();
    }

    abstract public PlayerMove makeMove();
}
