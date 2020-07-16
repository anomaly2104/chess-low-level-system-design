package com.uditagarwal.gameplay;

import com.uditagarwal.gameplay.contracts.PlayerMove;
import com.uditagarwal.chess.model.Board;

import java.util.List;

public class GameController {

    public static void gameplay(List<Player> players, Board board) {
        int currentPlayer = 0;
        while (true) {
            Player player = players.get(currentPlayer);
            PlayerMove playerMove = player.makeMove();
            playerMove.getPiece().move(playerMove.getToCell(), board);
            currentPlayer = (currentPlayer + 1) % players.size();
        }
    }
}
