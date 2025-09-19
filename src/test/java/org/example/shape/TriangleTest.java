package org.example.shape;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.example.shape.Triangle.Type.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TriangleTest {

    @ParameterizedTest(name = "{index}: ({0} {1} {2})->{3}")
    @MethodSource("testArguments")
    public void testTriangle(int a, int b, int c, Triangle.Type expected) {
        Triangle.Type actual = Triangle.classify(a, b, c);

        assertEquals(expected, actual);
    }

    public static Stream<Arguments> testArguments() {
        return Stream.of(
                Arguments.of(0, 0, 0, INVALID),
                Arguments.of(1, 0, 0, INVALID),
                Arguments.of(1, 1, 0, INVALID),
                Arguments.of(1, 2, 3, INVALID),
                Arguments.of(1, 3, 2, INVALID),
                Arguments.of(3, 1, 2, INVALID),
                Arguments.of(2, 3, 4, SCALENE),
                Arguments.of(1, 1, 1, EQUILATERAL),
                Arguments.of(2, 2, 1, ISOSCELES),
                Arguments.of(2, 1, 2, ISOSCELES),
                Arguments.of(1, 2, 2, ISOSCELES),
                Arguments.of(2, 2, 5, INVALID),
                Arguments.of(2, 5, 2, INVALID),
                Arguments.of(5, 2, 2, INVALID)
        );
    }
}