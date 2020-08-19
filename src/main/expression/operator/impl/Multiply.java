package main.expression.operator.impl;

import main.expression.Expression;
import main.expression.literal.Variable;
import main.expression.operator.BinaryOperator;

public class Multiply extends BinaryOperator {

    public Multiply(Expression exp1, Expression exp2) {
        super(exp1, exp2);
    }

    @Override
    public Double eval() {
        return super.exp1.eval() * super.exp2.eval();
    }

    @Override
    public Expression derive(Variable variable) {
        Expression fPrineG = new Multiply(super.exp1.derive(variable), super.exp2);
        Expression gPrineF = new Multiply(super.exp1, super.exp2.derive(variable));
        return new Sum(fPrineG, gPrineF);
    }
}
