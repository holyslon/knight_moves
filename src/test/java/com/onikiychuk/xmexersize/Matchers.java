package com.onikiychuk.xmexersize;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

class Matchers {
    static Matcher<? super BoardPosition> position(String column, String row) {
        return new TypeSafeMatcher<>() {


            @Override
            protected void describeMismatchSafely(BoardPosition item, Description mismatchDescription) {
                mismatchDescription.appendText(" was ").appendValue(item);
            }

            @Override
            protected boolean matchesSafely(BoardPosition position) {
                return position.isValid() && position.row().equals(row) && position.column().equals(column);
            }

            @Override
            public void describeTo(Description description) {
                description.appendText(String.format("%s%d", column, row));
            }
        };
    }

    static Matcher<? super BoardPosition> invalidPosition() {
        return new TypeSafeMatcher<>() {


            @Override
            protected void describeMismatchSafely(BoardPosition item, Description mismatchDescription) {
                mismatchDescription.appendText(" was ").appendValue(item);
            }

            @Override
            protected boolean matchesSafely(BoardPosition position) {
                return !position.isValid();
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("position should be invalid position");
            }
        };
    }


    @SafeVarargs
    static Matcher<? super Path> path(Matcher<? super BoardPosition>... positions) {
        var baseMatcher = org.hamcrest.Matchers.contains(positions);
        return new TypeSafeMatcher<>() {
            @Override
            protected boolean matchesSafely(Path boardPositions) {
                return baseMatcher.matches(boardPositions);
            }

            @Override
            public void describeTo(Description description) {
                baseMatcher.describeTo(description);
            }

            @Override
            protected void describeMismatchSafely(Path item, Description mismatchDescription) {
                baseMatcher.describeMismatch(item, mismatchDescription);
            }
        };
    }
}
