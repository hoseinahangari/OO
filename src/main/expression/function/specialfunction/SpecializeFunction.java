package main.expression.function.specialfunction;

import main.expression.Expression;
import main.expression.literal.Variable;
import main.expression.function.Function;

public class SpecializeFunction extends Function {


    public SpecializeFunction(Expression expression) {
        super(expression);
    }

    @Override
    public Double eval() {
        return expression.eval();
    }

    @Override
    public Expression derive(Variable variable) {
        return expression.derive(variable);
    }
}
