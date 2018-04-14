package com.onikiychuk.xmexersize;

import org.testng.annotations.Test;

import static com.onikiychuk.xmexersize.Matchers.position;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;

@SuppressWarnings("unchecked")
public class KnightFigureTest {
    @Test
    public void shouldReturnCorrectNewMovesForA1() {
        var figure = new KnightFigure();

        var availableMoves = figure.availableMoves(new BoardPosition("a", "1"));
        assertThat(availableMoves, arrayContainingInAnyOrder(
                position("b", "3"),
                position("c", "2")));
    }

    @Test
    public void shouldReturnCorrectNewMovesForD3() {
        var figure = new KnightFigure();

        var availableMoves = figure.availableMoves(new BoardPosition("d", "3"));
        assertThat(availableMoves, arrayContainingInAnyOrder(
                position("c", "1"),
                position("e", "1"),
                position("b", "2"),
                position("b", "4"),
                position("c", "5"),
                position("e", "5"),
                position("f", "2"),
                position("f", "4")));
    }

}
