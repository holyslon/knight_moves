package com.onikiychuk.xmexersize;

import java.util.Arrays;

public class BoardPosition {
    private static final String[] COLUMNS = {"a", "b", "c", "d", "e", "f", "g", "h"};
    private static final int[] ROWS = {1, 2, 3, 4, 5, 6, 7, 8};
    private static final BoardPosition invalid = new BoardPosition(-1, -1);

    private int column;
    private int row;

    private BoardPosition(int column, int row) {

        this.column = column;
        this.row = row;
    }

    BoardPosition(String column, int row) {
        this(Arrays.binarySearch(COLUMNS, column), Arrays.binarySearch(ROWS, row));
    }

    static BoardPosition invalid() {
        return invalid;
    }

    String column() {
        return COLUMNS[column];
    }

    int row() {
        return ROWS[row];
    }

    @Override
    public String toString() {
        if (isValid()) {
            return String.format("%s%d", column(), row());
        }
        return "invalid";
    }

    boolean isValid() {
        return column >= 0 &&
                row >= 0 &&
                column < COLUMNS.length &&
                row < ROWS.length;
    }

    BoardPosition moveUp(int i) {
        return new BoardPosition(this.column, this.row + i);
    }

    BoardPosition moveDown(int i) {
        return new BoardPosition(this.column, this.row - i);
    }

    BoardPosition moveLeft(int i) {
        return new BoardPosition(this.column - i, this.row);
    }

    BoardPosition moveRight(int i) {
        return new BoardPosition(this.column + i, this.row);
    }
}
