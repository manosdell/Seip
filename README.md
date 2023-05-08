# SEIP Lab Assignments

This repository contains all the practical assignments of the Software
Engineering in Practice (SEiP) course's lab.

## Project Structure

This repository contains a Maven parent project, which in turn
contains the module [Grades Histogram](gradeshistogram).

### Grades Histogram

This project creates a Histogram (XYLineChart) from a given .txt file containing grades.
The grades must either be integers or float and only one in each line.

## How to execute

1. Clone the repository
2. In order to build the Grades Histogram module you need to execute the following command:
``` mvn package ```. This command creates an executable jar file inside the (```gradeshistogram/target```) directory.
3. Execute the following command (if the file is named grades.txt): 
``` 
java -jar gradeshistogram\target\gradeshistogram-1.0-SNAPSHOT-jar-with-dependencies.jar gradeshistogram\src\main\resources\grades.txt
```
Note that the gradeshistogram-1.0-SNAPSHOT.jar is not executable.
