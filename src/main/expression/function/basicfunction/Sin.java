package main.expression.function.basicfunction;

import main.expression.Expression;
import main.expression.literal.Variable;
import main.expression.function.Function;
import main.expression.operator.impl.Multiply;

public class Sin extends Function {


    public Sin(Expression expression) {
        super(expression);
    }

    @Override
    public Double eval() {
        return Math.sin(super.expression.eval());
    }

    @Override
    public Expression derive(Variable variable) {
        Expression uPrine = expression.derive(variable);
        Expression fPrineU =  new Cos(expression);
        return new Multiply(uPrine, fPrineU);
    }
}
