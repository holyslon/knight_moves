package com.onikiychuk.xmexersize;

import java.util.stream.Stream;

class KnightFigure {
    BoardPosition[] availableMoves(BoardPosition position) {
        return Stream.of(
                position.moveLeft(2).moveUp(1),
                position.moveLeft(2).moveDown(1),
                position.moveRight(2).moveUp(1),
                position.moveRight(2).moveDown(1),
                position.moveUp(2).moveLeft(1),
                position.moveUp(2).moveRight(1),
                position.moveDown(2).moveLeft(1),
                position.moveDown(2).moveRight(1)).
                filter(BoardPosition::isValid).
                toArray(BoardPosition[]::new);
    }
}
