import org.example.models.Calculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private Calculator calc = new Calculator();

    @Test
    public void testAdd() {
        assertEquals(calc.add(1, 2), 3);
    }

    @Test
    public void testSubtract() {
        // Your test code here
        assertEquals(calc.subtract(2, 1), 1);
    }

    @Test
    public void testMultiply() {
        // Your test code here
        assertEquals(calc.multiply(2, 3), 6);
    }

    @Test
    public void testDivide() {
        // Your test code here
        assertEquals(calc.divide(6, 3), 2);
    }

    @Test
    public void testDivideByZero() {
        // Your test code here
        ArithmeticException ae = assertThrows(ArithmeticException.class, () -> {
            calc.divide(0, 0);
        });
        assertEquals("Division by zero", ae.getMessage());
    }
}
