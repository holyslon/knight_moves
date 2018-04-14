package com.onikiychuk.xmexersize;

public class BoardPosition {
    private String column;
    private int row;

    public BoardPosition(String column, int row) {
        this.row = row;
        this.column = column;
    }

    public String column() {
        return column;
    }

    public int row() {
        return row;
    }

    @Override
    public String toString() {
        return String.format("%s%d", column, row);
    }
}
