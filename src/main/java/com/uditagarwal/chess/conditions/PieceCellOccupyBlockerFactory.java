package com.uditagarwal.chess.conditions;

import com.google.common.collect.ImmutableList;
import com.uditagarwal.chess.model.Piece;

import java.util.List;

public class PieceCellOccupyBlockerFactory {

    public static List<PieceCellOccupyBlocker> defaultBlockers() {
        return ImmutableList.of(new PieceCellOccupyBlockerSelfPiece(), new PieceCellOccupyBlockerKingCheck());
    }

    public static List<PieceCellOccupyBlocker> kingCheckEvaluationBlockers() {
        return ImmutableList.of(new PieceCellOccupyBlockerSelfPiece());
    }
}
