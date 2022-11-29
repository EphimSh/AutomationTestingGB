package JUnitExample;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

public class TriangleTest {
    private static final Logger logger = LoggerFactory.getLogger(TriangleTest.class);
    Triangle triangle;

    public Boolean isATriangleSide(int a) {
        return a > 0;
    }

    public Boolean isAnAreaOfATriangle(int a) {
        int b = a + 1;
        int c = a + 2;
        double semiPerimeter = (a + b + c) / 2.0;
        return Math.sqrt((semiPerimeter * ((semiPerimeter - a) * (semiPerimeter - b) * (semiPerimeter - c)))) > 0;
    }


    @BeforeEach
    void createNewTriangle() {
        triangle = new Triangle(3, 4, 5);
        assertTrue(true);
    }

    @ParameterizedTest(name = "can only be initialized with positive numbers")
    @ValueSource(ints = {4, 5, 6})
    void canBeInitialized(int argument) {
        logger.info("Testing data: " + argument);
        assertTrue(isATriangleSide(argument));
    }

    @ParameterizedTest(name = "zero and negative numbers cannot be a triangle side value")
    @ValueSource(ints = {-1, 0})
    void cannotBeInitialized(int argument) {
        logger.info("Testing data: " + argument);
        assertFalse(isATriangleSide(argument));
    }

    @Test
    @Tag("sumOfTwoAlwaysBiggerThanThird")
    @DisplayName("sum of two sides is bigger than third side value")
    void sumOfTwoSidesAlwaysBiggerThanThird() {
        logger.info("Checking if sum of two is bigger than third");
        assumeTrue((
                triangle.getA() + triangle.getC() > triangle.getB()) ||
                triangle.getA() + triangle.getB() > triangle.getC() ||
                triangle.getB() + triangle.getC() > triangle.getA());
        assertTrue(true);
    }

    @ParameterizedTest(name = "the area of a triangle cannot be negative or zero value")
    @ValueSource(ints = {-1, 0})
        //As we use Heron's formula to calculate the area of a triangle, we should be strict about it's sides
        //So if one of the sides of a triangle would have negative or zero value; calculation will be failed
    void areaOfATriangleCannotBeNegativeOrZeroValue(int argument) {
        logger.info("Testing data: " + argument);
        assertFalse(isAnAreaOfATriangle(argument));
    }

    @ParameterizedTest(name = "only positive numbers can be used")
    @ValueSource(ints = {3,4,5})
    void areaOfATriangleCanBeCalculatedOnlyWithPositiveOperands(int argument){
        logger.info("Testing data: " + argument);
        assertTrue(isAnAreaOfATriangle(argument));

    }

}
