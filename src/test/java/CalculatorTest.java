import com.github.javafaker.Faker;
import org.example.models.Calculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.jupiter.params.provider.ValueSources;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private Calculator calc = new Calculator();

    @ParameterizedTest
    @CsvSource({
            "1, 2, 3",
            "0, 0, 0",
            "-1, -1, -2",
            "1000, 2000, 3000"
    })
    public void testAdd(int num1, int num2, int expected) {
        assertEquals(expected, calc.add(num1, num2));
    }

    @Test
    public void testAddMaxLimit() {
        long value = Integer.MAX_VALUE;
        int num1 = 1;
        int result = (int) value + num1;
        assertEquals(result, calc.add((int)value, num1));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 1, 1",
            "0, 0, 0",
            "-1, -1, 0",
            "2000, 1000, 1000"
    })
    public void testSubtract(int num1, int num2, int expected) {
        assertEquals(expected, calc.subtract(num1, num2));
    }

    @Test
    public void testAddMinLimit() {
        long value = Integer.MIN_VALUE;
        int num1 = 1;
        int result = (int) value - num1;
        assertEquals(result, calc.subtract((int)value, num1));
    }

    @ParameterizedTest
    @CsvSource({
            "2, 3, 6",
            "0, 10, 0",
            "-1, -2, 2",
            "1000, 3, 3000"
    })
    public void testMultiply(int num1, int num2, int expected) {
        assertEquals(expected, calc.multiply(num1, num2));
    }

    @ParameterizedTest
    @ValueSource(ints = {-10, 10, 1, -1})
    public void testMultiplyLimit(int num1) {
        long maxValue = Integer.MAX_VALUE;
        int result = (int) maxValue * num1;
        assertEquals(result, calc.multiply((int)maxValue, num1));

        long minValue = Integer.MIN_VALUE;
        int result2 = (int) minValue * num1;
        assertEquals(result2, calc.multiply((int)minValue, num1));
    }

    @ParameterizedTest
    @CsvSource({
            "6, 3, 2",
            "10, 2, 5",
            "100, 10, 10"
    })

    public void testDivide(double num1, double num2, double expected) {
        assertEquals(expected, calc.divide(num1, num2));
    }

    @Test
    public void testDivideByZero() {
        ArithmeticException ae = assertThrows(ArithmeticException.class, () -> {
            calc.divide(1, 0);
        });
        assertEquals("Division by zero", ae.getMessage());
    }
}
