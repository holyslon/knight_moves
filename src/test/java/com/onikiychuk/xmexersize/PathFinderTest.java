package com.onikiychuk.xmexersize;

import org.testng.annotations.Test;

import static com.onikiychuk.xmexersize.Matchers.path;
import static com.onikiychuk.xmexersize.Matchers.position;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;

public class PathFinderTest {

    @Test
    public void thatWeCanFindSimplePath() {
        var startPosition = new BoardPosition("a", 1);
        var endPosition = new BoardPosition("c", 5);

        var figure = new KnightFigure();

        var paths = new PathFinder(figure, 3).find(startPosition, endPosition);

        assertThat(paths, arrayContainingInAnyOrder(
                path(position("a", 1), position("b", 3), position("c", 5))));
    }
}
