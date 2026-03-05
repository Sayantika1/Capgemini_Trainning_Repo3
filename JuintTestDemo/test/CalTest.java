import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalTest {
    @Test
    void multiplyShouldReturnProductOfTwoNumbers()
    {
        Calculator calculator=new Calculator();
        int result=calculator.multiply(5,10);
        Assertions.assertEquals(50,result);

    }
}
