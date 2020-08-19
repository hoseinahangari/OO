package main.expression.function.basicfunction;

import main.expression.Expression;
import main.expression.literal.Value;
import main.expression.literal.Variable;
import main.expression.function.Function;
import main.expression.operator.impl.Multiply;

public class Cos extends Function {

    public Cos(Expression expression) {
        super(expression);
    }

    @Override
    public Double eval() {
        return Math.cos(super.expression.eval());
    }

    @Override
    public Expression derive(Variable variable) {
        Expression uPrine = expression.derive(variable);
        Expression fPrineU = new Multiply(new Value(-1D), new Sin(expression));
        return new Multiply(uPrine, fPrineU);
    }
}
