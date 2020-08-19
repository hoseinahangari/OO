package main.expression.operator;

import main.expression.Expression;
import main.expression.literal.Variable;

public abstract class BinaryOperator extends Expression{
    protected Expression exp1;
    protected Expression exp2;

    @Override
    public Expression eval(Variable variable, Double d) {
        exp1.eval(variable, d);
        exp2.eval(variable, d);
        return super.eval(variable, d);
    }

    public BinaryOperator(Expression exp1, Expression exp2) {
        this.exp1 = exp1;
        this.exp2 = exp2;

        exp1.getVariables().stream().forEach(this::addToVariables);
        exp2.getVariables().stream().forEach(this::addToVariables);
    }
}
