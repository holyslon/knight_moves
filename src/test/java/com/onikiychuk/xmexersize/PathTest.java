package com.onikiychuk.xmexersize;

import org.testng.annotations.Test;

import static com.onikiychuk.xmexersize.Matchers.position;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class PathTest {

    @Test
    public void thatReturnsLastPosition() {
        var path = new Path(new BoardPosition("a", "1")).
                addPosition(new BoardPosition("b", "1")).
                addPosition(new BoardPosition("c", "1"));
        assertThat(path.last(), position("c", "1"));
    }

    @Test
    public void thatReturnsLastPositionFor1PositionPath() {
        var path = new Path(new BoardPosition("a", "1"));
        assertThat(path.last(), position("a", "1"));
    }

    @Test
    public void thatReturnsLength() {
        var path = new Path(new BoardPosition("a", "1")).
                addPosition(new BoardPosition("b", "1")).
                addPosition(new BoardPosition("c", "1"));
        assertThat(path.length(), is(3));
    }

    @Test
    public void thatReturnsLengthFor1PositionPath() {
        var path = new Path(new BoardPosition("a", "1"));
        assertThat(path.length(), is(1));
    }


}