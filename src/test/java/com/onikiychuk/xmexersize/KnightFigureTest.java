package com.onikiychuk.xmexersize;

import org.testng.annotations.Test;

import static com.onikiychuk.xmexersize.Matchers.position;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;

public class KnightFigureTest {
    @Test
    public void shouldReturnCorrectNewMovesForA1() {
        var figure = new KnightFigure();

        var availableMoves = figure.availableMoves(new BoardPosition("a", 1));
        assertThat(availableMoves, arrayContainingInAnyOrder(
                position("b", 3),
                position("c", 2)));
    }
}
