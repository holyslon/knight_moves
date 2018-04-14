package com.onikiychuk.xmexersize;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

public class ConsoleApp {

    private static BoardPosition parse(String value) {
        BoardPositionEditor editor = new BoardPositionEditor();
        editor.setAsText(value);
        return (BoardPosition) editor.getValue();
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
                map(Path::toString).
                collect(joining("\n"));
        System.out.print(stringPaths);
        System.out.println();
    }
}
