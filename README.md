# Matrix Animation On Java 

_A simple animation inspired by Matrix the movie and written in Java for the Command Line Prompt._

## Build

### Pre-Requirements

_Install Java OpenJDK 15.0.2_

* On Fedora - 33

```
dnf install java-latest-openjdk
```

### Complie

```
cd MatrixAnimation
./build.sh
```
## Run

For GNU/Linux use:

```
cd MatrixAnimation
java -cp ./bin MatrixAnimation $COLUMNS $LINES
```

_Other systems, replace $COLUMNS for a mutiple of two, and $LINES for a desired row number._

## License 

MIT.
