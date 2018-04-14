package com.onikiychuk.xmexersize;


import org.testng.annotations.Test;

import static com.onikiychuk.xmexersize.Matchers.position;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class BoardPositionTest {

    @Test
    public void thatWeCanSetUpPosition() {
        var position = new BoardPosition("a", 1);

        assertThat(position, is(position("a", 1)));
    }


}
