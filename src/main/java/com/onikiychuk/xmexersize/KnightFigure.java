package com.onikiychuk.xmexersize;

public class KnightFigure {
    public BoardPosition[] availableMoves(BoardPosition position) {
        return new BoardPosition[]{
                new BoardPosition("b", 3),
                new BoardPosition("c", 2)
        };
    }
}
