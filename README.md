# Matrix Animation On Java 

_A simple animation inspired by Matrix the movie and written in Java for the Command Line Prompt._

## Build

### Pre-Requirements

_Install Java OpenJDK 14.0.2+_

* On Fedora 33

```
dnf install java-latest-openjdk
```

* On Ubuntu 20.04

```
apt-get install openjdk-14-jdk openjdk-14-jre
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

