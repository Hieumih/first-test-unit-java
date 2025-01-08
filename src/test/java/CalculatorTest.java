import com.github.javafaker.Faker;
import org.example.models.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private Calculator calc = new Calculator();

    @Test
    public void testAdd() {
        Faker faker = new Faker();
        int num1 = faker.number().numberBetween(0, 100);
        int num2 = faker.number().numberBetween(0, 100);
        int result = num1 + num2;
        assertEquals(result, calc.add(num1, num2));
    }

    @Test
    public void testSubtract() {
        // Your test code here
        Faker faker = new Faker();
        int num1 = faker.number().numberBetween(0, 100);
        int num2 = faker.number().numberBetween(0, 100);
        int result = num1 - num2;
        assertEquals(result, calc.subtract(num1, num2));
    }

    @Test
    public void testMultiply() {
        // Your test code here
        Faker faker = new Faker();
        int num1 = faker.number().numberBetween(0, 100);
        int num2 = faker.number().numberBetween(0, 100);
        int result = num1 * num2;
        assertEquals(result, calc.multiply(num1, num2));
    }

    @Test
    public void testDivide() {
        // Your test code here
        Faker faker = new Faker();
        long num1 = faker.number().numberBetween((long) 0, 100);
        long num2 =  faker.number().numberBetween((long) 0, 100);
        double result = (double) num1 / num2;
        assertEquals(result, calc.divide(num1, num2));
    }

    @Test
    public void testMultiplyOverLimit() {
        int maxLimit = Integer.MAX_VALUE;

        Faker faker = new Faker();
        int num1 = faker.number().numberBetween(2, maxLimit);

        int result = num1 * maxLimit;
        int result2 = calc.multiply(maxLimit, num1);

        assertEquals(result, result2);

    }

    @Test
    public void testDivideByZero() {
        // Your test code here
        Faker faker = new Faker();
        int num1 = faker.number().randomDigit();

        ArithmeticException ae = assertThrows(ArithmeticException.class, () -> {
            calc.divide(num1, 0);
        });
        assertEquals("Division by zero", ae.getMessage());
    }
}
