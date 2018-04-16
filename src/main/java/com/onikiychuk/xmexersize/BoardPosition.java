package com.onikiychuk.xmexersize;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Objects;

/***
 * Class that represent position on the board.
 * Board position is immutable by nature.
 * Position can be valid (from a1 to h8) and invalid - all other positions.
 */
public class BoardPosition {
    private static final String[] COLUMNS = {"a", "b", "c", "d", "e", "f", "g", "h"};
    private static final String[] ROWS = {"1", "2", "3", "4", "5", "6", "7", "8"};
    private static final BoardPosition invalid = new BoardPosition(-1, -1);
    private final int column;
    private final int row;

    private BoardPosition(int column, int row) {

        this.column = column;
        this.row = row;
    }

    /**
     * Create new position for given column and row.
     * If column or/and row is invalid (see {@link com.onikiychuk.xmexersize.BoardPosition#validColumn(String)} and {@link com.onikiychuk.xmexersize.BoardPosition#validRow(String)}()})
     * whole position will be invalid
     *
     * @param column column
     * @param row    row
     */
    public BoardPosition(String column, String row) {
        this(Arrays.asList(COLUMNS).indexOf(column), Arrays.asList(ROWS).indexOf(row));
    }

    /**
     * Check that column is valid
     *
     * @param value column value
     * @return true if value between a and h, false otherwise
     */
    static boolean validColumn(String value) {
        if (value == null) {
            return false;
        }
        return Arrays.stream(COLUMNS).anyMatch(value::equals);
    }

    /**
     * Check that row is valid
     *
     * @param value row value
     * @return true if value between 1 and 8, false otherwise
     */
    static boolean validRow(String value) {
        if (value == null) {
            return false;
        }
        return Arrays.stream(ROWS).anyMatch(value::equals);
    }

    /***
     * Provide invalid position
     * @return invalid position
     */
    static BoardPosition invalid() {
        return invalid;
    }

    /***
     * Column getter
     * @return column
     */
    String column() {
        return COLUMNS[column];
    }

    /***
     * Row getter
     * @return row
     */
    String row() {
        return ROWS[row];
    }

    @JsonValue
    @Override
    public String toString() {
        if (isValid()) {
            return String.format("%s%s", column(), row());
        }
        return "invalid";
    }

    /***
     * Check that position is valid
     * @return true if position valid, false otherwise
     */
    boolean isValid() {
        return column >= 0 &&
                row >= 0 &&
                column < COLUMNS.length &&
                row < ROWS.length;
    }

    /**
     * Creates new position that will be higher that current for i cells
     * For example moveUp(3) for a1 returns a4 position.
     * If after move we get out from board - returns invalid position.
     *
     * @param i number of cells to move
     * @return new position
     */
    BoardPosition moveUp(int i) {
        return new BoardPosition(this.column, this.row + i);
    }

    /**
     * Creates new position that will be lower that current for i cells
     * For example moveDown(2) for d3 returns d1 position.
     * If after move we get out from board - returns invalid position.
     *
     * @param i number of cells to move
     * @return new position
     */
    BoardPosition moveDown(int i) {
        return new BoardPosition(this.column, this.row - i);
    }

    /**
     * Creates new position that will be shifted left from current for i cells
     * For example moveLeft(1) for b4 returns a4 position.
     * If after move we get out from board - returns invalid position.
     *
     * @param i number of cells to move
     * @return new position
     */
    BoardPosition moveLeft(int i) {
        return new BoardPosition(this.column - i, this.row);
    }

    /**
     * Creates new position that will be shifted right from current for i cells
     * For example moveUp(4) for c6 returns g6 position
     * If after move we get out from board - returns invalid position.
     *
     * @param i number of cells to move
     * @return new position
     */
    BoardPosition moveRight(int i) {
        return new BoardPosition(this.column + i, this.row);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardPosition that = (BoardPosition) o;
        return column == that.column &&
                row == that.row;
    }

    @Override
    public int hashCode() {
        return Objects.hash(column, row);
    }
}
