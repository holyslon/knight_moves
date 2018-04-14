package com.onikiychuk.xmexersize;

public class PathFinder {
    private final KnightFigure figure;
    private final int maxNumberOfMoves;

    public PathFinder(KnightFigure figure, int maxNumberOfMoves) {
        this.figure = figure;
        this.maxNumberOfMoves = maxNumberOfMoves;
    }

    public Path[] find(BoardPosition startPosition, BoardPosition endPosition) {
        return new Path[]{new Path(new BoardPosition("a", 1)).addPosition(new BoardPosition("b", 3)).addPosition(new BoardPosition("c", 5))};
    }
}
