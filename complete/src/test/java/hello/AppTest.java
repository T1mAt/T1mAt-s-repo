package hello;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {

    @Test
    public void testPassingExpression() {
        Expression expression = new ExpressionBuilder("1+1").build();
        double result = expression.evaluate();
        assertEquals(2, result, "Expected result is 2");
    }

    @Test
    public void testFailingExpression() {
        Expression expression = new ExpressionBuilder("5-1").build();
        double result = expression.evaluate();
        assertEquals(2, result, "Expected result is 2, but it will fail");
    }
}
