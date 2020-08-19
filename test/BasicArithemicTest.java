import main.expression.Expression;
import main.expression.literal.Value;
import main.expression.literal.Variable;
import main.expression.function.basicfunction.Cos;
import main.expression.function.basicfunction.Sin;
import main.expression.operator.impl.Devide;
import main.expression.operator.impl.Subtract;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class BasicArithemicTest {

    // (cosx - 1) / y
    @Test
    public void testCosXMin1DevideY() {
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Expression cosxMin1 = new Subtract(new Cos(x), new Value(1D));
        Expression exp = new Devide(cosxMin1, y);
        exp.eval(x, 10D);
        exp.eval(y, 10D);
        assertEquals(-0.18390, exp.eval(), 1E-5);
    }

    // (cos(x-1) - 1 / siny
    @Test
    public void testCosXMin1Min1DevideSinY() {
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Expression cosxMin1Min1 = new Subtract(new Cos(new Subtract(x, new Value(1D))), new Value(1D));
        Expression exp = new Devide(cosxMin1Min1, new Sin(y));
        exp.eval(x, 10D);
        exp.eval(y, 10D);
        assertEquals(3.51297, exp.eval(), 1E-5);
    }


}
