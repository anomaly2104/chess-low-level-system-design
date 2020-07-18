package com.uditagarwal.chess.helpers;

import com.google.common.collect.ImmutableList;
import com.uditagarwal.chess.conditions.*;
import com.uditagarwal.chess.model.*;
import com.uditagarwal.chess.moves.*;

import java.util.ArrayList;
import java.util.List;

import static com.uditagarwal.chess.model.Color.WHITE;
import static com.uditagarwal.chess.model.PieceType.*;
import static com.uditagarwal.chess.moves.VerticalMoveDirection.BOTH;
import static com.uditagarwal.chess.moves.VerticalMoveDirection.UP;

public class TestHelpers {

    public static Board createBoard() {
        Cell[][] cells = new Cell[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
        return new Board(8, cells);
    }

    public static List<Piece> piecesSet(Color color, Board board, int mainPiecesRownNum, int pawnPiecesRowNum, VerticalMoveDirection pawnDirection) {
        List<Piece> allPieces = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            Piece pawn = pawn(color, pawnDirection);
            addPieceToBoard(board, pawn, pawnPiecesRowNum, i);
            allPieces.add(pawn);
        }

        Piece king = king(color);
        addPieceToBoard(board, king, mainPiecesRownNum, 3);
        Piece queen = queen(color);
        addPieceToBoard(board, queen, mainPiecesRownNum, 4);
        Piece rook1 = rook(color);
        addPieceToBoard(board, rook1, mainPiecesRownNum, 0);
        Piece rook2 = rook(color);
        addPieceToBoard(board, rook2, mainPiecesRownNum, 7);
        Piece bishop1 = bishop(color);
        addPieceToBoard(board, bishop1, mainPiecesRownNum, 2);
        Piece bishop2 = bishop(color);
        addPieceToBoard(board, bishop2, mainPiecesRownNum, 5);
        Piece knight1 = knight(color);
        addPieceToBoard(board, knight1, mainPiecesRownNum, 1);
        Piece knight2 = knight(color);
        addPieceToBoard(board, knight2, mainPiecesRownNum, 6);

        ImmutableList<Piece> mainPieces = ImmutableList.of(king, queen, rook1, rook2, bishop1, bishop2, knight1, knight2);
        allPieces.addAll(mainPieces);
        return allPieces;
    }

    private static void addPieceToBoard(Board board, Piece piece, int rowNum, int colNum) {
        Cell cell = board.getCellAtLocation(rowNum, colNum);
        piece.setCurrentCell(cell);
        cell.setCurrentPiece(piece);
    }

    public static Piece randomPiece() {
        return pawn(WHITE, BOTH);
    }

    public static Piece testPiece(Color color, PieceType pieceType) {
        return new Piece(color, ImmutableList.of(), pieceType);
    }

    public static Piece pawn(Color color, VerticalMoveDirection pawnDirection) {
        ImmutableList<PossibleMovesProvider> pawnMoveProviders = ImmutableList.of(
            new PossibleMovesProviderVertical(1, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), defaultBaseBlocker(), pawnDirection),
            new PossibleMovesProviderVertical(2, new MoveBaseConditionFirstMove(), defaultMoveFurtherCondition(), defaultBaseBlocker(), pawnDirection)
        );
        return new Piece(color, pawnMoveProviders, PAWN);
    }

    public static Piece king(Color color) {
        ImmutableList<PossibleMovesProvider> pawnMoveProviders = ImmutableList.of(
            new PossibleMovesProviderVertical(1, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), defaultBaseBlocker(), BOTH),
            new PossibleMovesProviderHorizontal(1, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), defaultBaseBlocker()),
            new PossibleMovesProviderDiagonal(1, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), defaultBaseBlocker())
        );
        return new Piece(color, pawnMoveProviders, KING);
    }

    public static Piece queen(Color color) {
        ImmutableList<PossibleMovesProvider> pawnMoveProviders = ImmutableList.of(
                new PossibleMovesProviderVertical(8, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), defaultBaseBlocker(), BOTH),
                new PossibleMovesProviderHorizontal(8, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), defaultBaseBlocker()),
                new PossibleMovesProviderDiagonal(8, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), defaultBaseBlocker())
        );
        return new Piece(color, pawnMoveProviders, QUEEN);
    }

    public static Piece rook(Color color) {
        ImmutableList<PossibleMovesProvider> pawnMoveProviders = ImmutableList.of(
            new PossibleMovesProviderVertical(8, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), defaultBaseBlocker(), BOTH),
            new PossibleMovesProviderHorizontal(8, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), defaultBaseBlocker())
        );
        return new Piece(color, pawnMoveProviders, ROOK);
    }

    public static Piece bishop(Color color) {
        ImmutableList<PossibleMovesProvider> pawnMoveProviders = ImmutableList.of(
            new PossibleMovesProviderDiagonal(8, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), defaultBaseBlocker())
        );
        return new Piece(color, pawnMoveProviders, BISHOP);
    }

    public static Piece knight(Color color) {
        ImmutableList<PossibleMovesProvider> pawnMoveProviders = ImmutableList.of(
                new PossibleMovesProviderDiagonal(1, new NoMoveBaseCondition(), defaultMoveFurtherCondition(), null)
        );
        return new Piece(color, pawnMoveProviders, KNIGHT);
    }

    private static PieceMoveFurtherConditionDefault defaultMoveFurtherCondition() {
        return new PieceMoveFurtherConditionDefault();
    }

    private static PieceCellOccupyBlocker defaultBaseBlocker() {
        return PieceCellOccupyBlockerFactory.defaultBaseBlocker();
    }
}
