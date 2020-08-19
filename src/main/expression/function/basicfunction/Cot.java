package main.expression.function.basicfunction;

import main.expression.Expression;
import main.expression.literal.Value;
import main.expression.literal.Variable;
import main.expression.function.Function;
import main.expression.operator.impl.Devide;
import main.expression.operator.impl.Multiply;

public class Cot extends Function {

    public Cot(Expression expression) {
        super(expression);
    }

    @Override
    public Double eval() {
        return 1/Math.tan(super.expression.eval());
    }

    @Override
    public Expression derive(Variable variable) {
        Expression fPrineU = new Multiply(new Value(-1D), new Devide(new Value(1D), new Multiply(new Sin(super.expression), new Sin(super.expression))));
        Expression uPrine = super.expression.derive(variable);
        return new Multiply(fPrineU, uPrine);
    }
}
