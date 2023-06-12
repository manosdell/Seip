## Unit Testing

This module contains classes and methods that offer math operations file handling.
It also contains extensive unit tests for each class and method, using the JUnit framework.

### Package Structure

The package structure of the module is the following:

1. math - Contains the classes MyMath, ArrayOperations and ArithmeticOperations with math operations
2. io - Contains the classes FileIO with file handling operations

### Jacoco

Run the following command to generate the Jacoco report:

``` mvn package jacoco:report ```

Which will generate the report in the following directory:

``` target/site/jacoco/```