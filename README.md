# xmexersize

This is test exercise for XM.

#Run

- You can run app via `mvn compile exec:java -Dexec.args="a1 b3"`
- You can run tests via `mvn test`
- You can run build fat-jar with Spring Boot app via mvn `mvn package` and run it `java -jar target/xmexersize-0.0.1-SNAPSHOT.jar`
- You can build Docker image via `make build` and run app in Docker container via `make run` (Docker can be downloaded [here](https://www.docker.com/community-edition#/download))

#Future development

## Additional figures
We can add additional figures by extracting interface from `KnightFigure` class.
```java
interface Figure {
    BoardPosition[] availableMoves(BoardPosition position);
}
```
and implement this interface for other figures. For example for Pawn (we ignore first touch rule for simplicity)
```java
class PawnFigure implements Figure {
    enum Direction{
        Up, Down
    }
    private final Direction direction;
    PawnFigure(PawnFigure.Direction direction) {
        this.direction = direction;
    }
    @Override
    BoardPosition[] availableMoves(BoardPosition position) {
        BoardPosition newPosition;
        if (direction == Direction.Up) {
            newPosition = position.moveUp(1);
        } else {
            newPosition = position.moveDown(1);
        }
        if (newPosition.isValid()) {
            return new BoardPosition[] {newPosition};
        }
        return new BoardPosition[0];
    }
}
```
## Add other tasks
We can write another task class (like `PathFinder`).


