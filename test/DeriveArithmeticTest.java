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
public class DeriveArithmeticTest {

    // cosx
    @Test
    public void cosX(){
        Variable x = new Variable("x");
        Expression cosx = new Cos(x);
        Expression derived = cosx.derive(x);
        Expression xValue = derived.eval(x, 10D);
        assertEquals(0.54402, xValue.eval(), 1E-5);
    }

    //cosx - 1 / y
    @Test
    public void cosXMin1DevideY(){
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Expression cosxMin1 = new Subtract(new Cos(x), new Value(1D));
        Expression exp = new Devide(cosxMin1, y);
        exp.eval(y, 10D);
        Expression derived = exp.derive(x);
        Expression xDerivedValued = derived.eval(x, 10D);
        assertEquals(0.05440, xDerivedValued.eval(), 1E-5);
    }

    // (cos(x-1) - 1 / siny
    @Test
    public void testCosXMin1Min1DevideSinY() {
        Variable x = new Variable("x");
        Variable y = new Variable("y");
        Expression cosxMin1Min1 = new Subtract(new Cos(new Subtract(x, new Value(1D))), new Value(1D));
        Expression exp = new Devide(cosxMin1Min1, new Sin(y));
        exp.eval(y, 10D);
        Expression derived = exp.derive(x);
        Expression xDerivedValued = derived.eval(x, 10D);
        assertEquals(0.75754, xDerivedValued.eval(), 1E-5);
    }
}
