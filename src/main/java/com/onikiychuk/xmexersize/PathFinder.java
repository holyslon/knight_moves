package com.onikiychuk.xmexersize;

import java.util.ArrayDeque;
import java.util.ArrayList;

import static java.util.Comparator.comparingInt;

/**
 * Implements algorithm for searching all paths from start position to end position for given figure.
 */
class PathFinder {
    private final KnightFigure figure;
    private final int maxPathLength;

    /**
     * Creates new path finder
     *
     * @param figure           figure that we will calculate path for
     * @param maxNumberOfMoves maximum numbers of move that we can do in search
     */
    PathFinder(KnightFigure figure, int maxNumberOfMoves) {
        this.figure = figure;
        maxPathLength = maxNumberOfMoves + 1; //we add 1 because initial position are also inside path
    }

    /**
     * Finds paths between given positions
     *
     * @param startPosition start position
     * @param endPosition   end position
     * @return sorted array of paths. Shortest path came first. If there is no path - return empty array. Never returns null.
     */
    Path[] find(BoardPosition startPosition, BoardPosition endPosition) {

        var queue = new ArrayDeque<Path>();
        queue.add(new Path(startPosition));
        var result = new ArrayList<Path>();
        while (!queue.isEmpty()) {
            var path = queue.removeFirst();
            if (path.length() > maxPathLength) {
                break;
            }
            if (path.last().equals(endPosition)) {
                result.add(path);
            } else {
                var moves = figure.availableMoves(path.last());
                for (var move : moves) {
                    queue.addLast(path.addPosition(move));
                }
            }
        }

        return result.stream().
                filter(p -> p.last().equals(endPosition)).
                sorted(comparingInt(Path::length)).
                toArray(Path[]::new);

    }
}
