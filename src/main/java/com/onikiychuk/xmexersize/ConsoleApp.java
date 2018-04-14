package com.onikiychuk.xmexersize;

import java.util.stream.StreamSupport;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class ConsoleApp {

    private static BoardPosition parse(String value) {
        if (value.length() != 2) {
            return new BoardPosition("0", 0);
        }
        try {
            var row = Integer.parseInt(value.substring(1));
            return new BoardPosition(value.substring(0, 1), row);
        } catch (NumberFormatException ex) {
            return new BoardPosition("0", 0);
        }
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.print("Usage: app start_position end_position");
            return;
        }
        var start = parse(args[0]);
        var end = parse(args[1]);

        var figure = new KnightFigure();

        var paths = new PathFinder(figure, 3).find(start, end);

        var stringPaths = stream(paths).
                map(p -> StreamSupport.stream(p.spliterator(), false).map(BoardPosition::toString).collect(joining(" "))).
                collect(joining("\n"));
        System.out.print(stringPaths);

    }
}
