package com.uditagarwal.chess.conditions;

import com.google.common.collect.ImmutableList;

import java.util.List;

/**
 * Factory class to give cell occupy blockers for different scenarios.
 */
public class PieceCellOccupyBlockerFactory {

    public static PieceCellOccupyBlocker defaultBaseBlocker() {
        return new PieceCellOccupyBlockerSelfPiece();
    }

    public static List<PieceCellOccupyBlocker> defaultAdditionalBlockers() {
        return ImmutableList.of(new PieceCellOccupyBlockerKingCheck());
    }

    public static List<PieceCellOccupyBlocker> kingCheckEvaluationBlockers() {
        return ImmutableList.of();
    }
}
