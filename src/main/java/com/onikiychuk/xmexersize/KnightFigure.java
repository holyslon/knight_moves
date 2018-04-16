package com.onikiychuk.xmexersize;

import java.util.stream.Stream;

/**
 * Represents Knight figure.
 */
class KnightFigure {
    /**
     * Provide list of valid board positions that knight figure can move from current position.
     *
     * @param position current figure position. If there is no available moves - returns empty array. Never returns null.
     * @return list of valid ({@link BoardPosition#isValid()}) position that figure able to moves from current position.
     */
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
