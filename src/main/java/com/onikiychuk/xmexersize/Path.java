package com.onikiychuk.xmexersize;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class Path implements Iterable<BoardPosition> {
    private final ArrayList<BoardPosition> storage = new ArrayList<>();

    private Path(List<BoardPosition> previous, BoardPosition newPosition) {
        storage.addAll(previous);
        storage.add(newPosition);
    }

    public Path(BoardPosition newPosition) {
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

    public Path addPosition(BoardPosition position) {
        return new Path(this.storage, position);
    }
}
