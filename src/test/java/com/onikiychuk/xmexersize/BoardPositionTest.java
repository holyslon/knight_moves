package com.onikiychuk.xmexersize;


import org.testng.annotations.Test;

import static com.onikiychuk.xmexersize.Matchers.invalidPosition;
import static com.onikiychuk.xmexersize.Matchers.position;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardPositionTest {

    @Test
    public void thatWeCanSetUpPosition() {
        var position = new BoardPosition("a", "1");

        assertThat(position, is(position("a", "1")));
    }

    @Test
    public void thatA1IsValidPosition() {
        var position = new BoardPosition("a", "1");

        assertThat(position.isValid(), is(true));
    }

    @Test
    public void thatA10IsInvalidPosition() {
        var position = new BoardPosition("a", "10");

        assertThat(position, is(invalidPosition()));
    }

    @Test
    public void thatInvalidIsInvalidPosition() {
        var position = BoardPosition.invalid();

        assertThat(position, is(invalidPosition()));
    }

    @Test
    public void thatWeCanMoveUpFromA1() {
        var position = new BoardPosition("a", "1").moveUp(1);
        assertThat(position, is(position("a", "2")));
    }

    @Test
    public void thatWeCantMoveDownFromA1() {
        var position = new BoardPosition("a", "1").moveDown(1);
        assertThat(position, is(invalidPosition()));
    }

    @Test
    public void thatWeCantMoveLeftFromA1() {
        var position = new BoardPosition("a", "1").moveLeft(1);
        assertThat(position, is(invalidPosition()));
    }

    @Test
    public void thatWeCanMoveRightFromA1() {
        var position = new BoardPosition("a", "1").moveRight(1);
        assertThat(position, is(position("b", "1")));
    }

    @Test
    public void thatWeCantMoveRightFromH8() {
        var position = new BoardPosition("h", "8").moveRight(1);
        assertThat(position, is(invalidPosition()));
    }

    @Test
    public void thatWeCantMoveUpFromH8() {
        var position = new BoardPosition("h", "8").moveUp(1);
        assertThat(position, is(invalidPosition()));
    }

    @Test
    public void thatWeCanMoveDownFromH8() {
        var position = new BoardPosition("h", "8").moveDown(1);
        assertThat(position, is(position("h", "7")));
    }

    @Test
    public void thatWeCanMoveLeftFromH8() {
        var position = new BoardPosition("h", "8").moveLeft(1);
        assertThat(position, is(position("g", "8")));
    }


    @Test
    public void thatWeCanMoveDownFromD5() {
        var position = new BoardPosition("d", "5").moveDown(3);
        assertThat(position, is(position("d", "2")));
    }

    @Test
    public void thatWeCanMoveLeftFromD5() {
        var position = new BoardPosition("d", "5").moveLeft(3);
        assertThat(position, is(position("a", "5")));
    }

    @Test
    public void thatWeCanMoveUpFromD5() {
        var position = new BoardPosition("d", "5").moveUp(3);
        assertThat(position, is(position("d", "8")));
    }

    @Test
    public void thatWeCanMoveRightFromD5() {
        var position = new BoardPosition("d", "5").moveRight(3);
        assertThat(position, is(position("g", "5")));
    }
}
