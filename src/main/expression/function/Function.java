package main.expression.function;

import main.expression.Expression;
import main.expression.literal.Variable;

public abstract class Function extends Expression{
    protected Expression expression;

    public Function(Expression expression) {
        this.expression = expression;
        expression.getVariables().stream().forEach(this::addToVariables);
    }

    @Override
    public Expression eval(Variable variable, Double d) {
        expression.eval(variable, d);
        return super.eval(variable, d);
    }
}
