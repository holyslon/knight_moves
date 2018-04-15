# xmexersize

This is test exercise for XM.

This exercise is done with Java 10. If you dont have it on your machine - just use docker way.

#Run

- Docker way:
    - Run all just using `make`
    - Build backend docker image with `make build_backend`
    - Build ui docker image with `make build_ui`
    - Run backend interactive with `make run_backend`
    - Run ui interactive with `make run_ui`
    - Run both backend and ui in detached mode `make run_all`
    - Stop detached containers with `make stop`
- Local machine way (you should have jdk 10 and maven 3 installed for that):
    - You can run app via `mvn compile exec:java -Dexec.args="a1 b3"`
    - You can run tests via `mvn test`
    - You can run build fat-jar with Spring Boot app via mvn `mvn package` and run it `java -jar target/xmexersize-0.0.1-SNAPSHOT.jar`

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


