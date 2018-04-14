package com.onikiychuk.xmexersize;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

import static java.util.stream.Collectors.joining;

public class Path implements Iterable<BoardPosition> {
    private final ArrayList<BoardPosition> storage = new ArrayList<>();

    private Path(List<BoardPosition> previous, BoardPosition newPosition) {
        storage.addAll(previous);
        storage.add(newPosition);
    }

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

    Path addPosition(BoardPosition position) {
        return new Path(this.storage, position);
    }

    @Override
    public String toString() {
        return storage.stream().map(BoardPosition::toString).collect(joining(" "));
    }

    BoardPosition last() {
        return storage.get(storage.size() - 1);
    }

    int length() {
        return storage.size();
    }
}
