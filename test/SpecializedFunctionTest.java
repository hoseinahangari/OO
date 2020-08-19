import main.expression.Expression;
import main.expression.literal.Value;
import main.expression.literal.Variable;
import main.expression.function.basicfunction.Sin;
import main.expression.operator.impl.Multiply;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class SpecializedFunctionTest {
    @Test
    public void specializedFunction(){
        Variable x = new Variable("x");
        Expression specializedFunction = new Sin(new Multiply(x, new Value(2D)));
        specializedFunction.eval(x, 10D);
        assertEquals(0.91294, specializedFunction.eval(), 1E-5);
    }
}
