package com.onikiychuk.xmexersize;

import java.beans.PropertyEditorSupport;

/**
 * {@link java.beans.PropertyEditor} support for {@link com.onikiychuk.xmexersize.BoardPosition}
 */
public class BoardPositionEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        if (text.length() != 2) {
            throw new IllegalArgumentException(String.format("String '%s' too long or too short for board position", text));
        }
        var column = text.substring(0, 1);
        var row = text.substring(1, 2);
        if (!BoardPosition.validColumn(column)) {
            throw new IllegalArgumentException(String.format("String '%s' invalid column. Column should be letters from a to h", column));
        }
        if (!BoardPosition.validRow(row)) {
            throw new IllegalArgumentException(String.format("String '%s' invalid row. Column should be numbers from 1 to 8", row));
        }
        super.setValue(new BoardPosition(column, row));
    }
}
