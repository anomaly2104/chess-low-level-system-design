package com.uditagarwal.gameplay;

import com.uditagarwal.chess.model.Player;
import com.uditagarwal.gameplay.contracts.PlayerMove;
import com.uditagarwal.chess.model.Board;

import java.util.List;

import static com.uditagarwal.chess.conditions.PieceCellOccupyBlockerFactory.defaultAdditionalBlockers;

public class GameController {

    public static void gameplay(List<Player> players, Board board) {
        int currentPlayer = 0;
        while (true) {
            Player player = players.get(currentPlayer);
            //TODO: Check if current player has any move possible. If no move possible, then its checkmate.
            PlayerMove playerMove = player.makeMove();
            playerMove.getPiece().move(player, playerMove.getToCell(), board, defaultAdditionalBlockers());
            currentPlayer = (currentPlayer + 1) % players.size();
        }
    }
}
