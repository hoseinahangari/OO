package main.expression.operator.impl;

import main.expression.Expression;
import main.expression.literal.Variable;
import main.expression.operator.BinaryOperator;

public class Sum extends BinaryOperator {
    public Sum(Expression exp1, Expression exp2) {
       super(exp1, exp2);
    }

    @Override
    public Double eval() {
        return super.exp1.eval() + super.exp2.eval();
    }

    @Override
    public Expression derive(Variable variable) {
        return new Sum(exp1.derive(variable), exp2.derive(variable));
    }
}
