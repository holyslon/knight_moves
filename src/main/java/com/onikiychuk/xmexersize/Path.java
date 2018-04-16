package com.onikiychuk.xmexersize;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

import static java.util.stream.Collectors.joining;

/**
 * Collection of board positions ({@link BoardPosition}) in particular order, that represent path that figure make on the board.
 * Path is immutable in its nature.
 */
public class Path implements Iterable<BoardPosition> {
    private final ArrayList<BoardPosition> storage = new ArrayList<>();

    private Path(List<BoardPosition> previous, BoardPosition newPosition) {
        storage.addAll(previous);
        storage.add(newPosition);
    }

    /**
     * Create new path
     *
     * @param newPosition start position
     */
    Path(BoardPosition newPosition) {
        this(List.of(), newPosition);
    }

    @Override
    public Iterator<BoardPosition> iterator() {
        return storage.iterator();
    }

    @Override
    public void forEach(Consumer<? super BoardPosition> action) {
        storage.forEach(action);
    }

    @Override
    public Spliterator<BoardPosition> spliterator() {
        return storage.spliterator();
    }

    /**
     * Creates new path, that extend current one with given position
     *
     * @param position new position
     * @return path, that extend current one with given position
     */
    Path addPosition(BoardPosition position) {
        return new Path(this.storage, position);
    }

    @Override
    public String toString() {
        return storage.stream().map(BoardPosition::toString).collect(joining(" "));
    }

    /**
     * get last position of path
     *
     * @return last position of path
     */
    BoardPosition last() {
        return storage.get(storage.size() - 1);
    }

    /**
     * get length of the path
     *
     * @return length of the path
     */
    int length() {
        return storage.size();
    }
}
