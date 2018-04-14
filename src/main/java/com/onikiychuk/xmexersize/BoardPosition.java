package com.onikiychuk.xmexersize;

import java.util.Arrays;
import java.util.Objects;

public class BoardPosition {
    private static final String[] COLUMNS = {"a", "b", "c", "d", "e", "f", "g", "h"};
    private static final String[] ROWS = {"1", "2", "3", "4", "5", "6", "7", "8"};
    private static final BoardPosition invalid = new BoardPosition(-1, -1);

    static boolean ValidColumn(String value){
        if (value == null) {
            return false;
        }
        return Arrays.stream(COLUMNS).anyMatch(value::equals);
    }

    static boolean ValidRow(String value){
        if (value == null) {
            return false;
        }
        return Arrays.stream(ROWS).anyMatch(value::equals);
    }

    private int column;
    private int row;

    private BoardPosition(int column, int row) {

        this.column = column;
        this.row = row;
    }

    public BoardPosition(String column, String row) {
        this(Arrays.asList(COLUMNS).indexOf(column), Arrays.asList(ROWS).indexOf(row));
    }

    static BoardPosition invalid() {
        return invalid;
    }

    String column() {
        return COLUMNS[column];
    }

    String row() {
        return ROWS[row];
    }

    @Override
    public String toString() {
        if (isValid()) {
            return String.format("%s%s", column(), row());
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
