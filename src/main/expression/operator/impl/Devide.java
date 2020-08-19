package main.expression.operator.impl;

import main.expression.Expression;
import main.expression.literal.Variable;
import main.expression.operator.BinaryOperator;

public class Devide extends BinaryOperator {

    public Devide(Expression exp1, Expression exp2) {
        super(exp1, exp2);
    }

    @Override
    public Double eval() {
        return super.exp1.eval()/super.exp2.eval();
    }

    @Override
    public Expression derive(Variable variable) {
        Expression fprineG = new Multiply(super.exp1.derive(variable), super.exp2);
        Expression gPrineF = new Multiply(super.exp1, super.exp2.derive(variable));
        Expression fPrineGMinGPrineF = new Subtract(fprineG, gPrineF);
        Expression gPower2 = new Multiply(super.exp2, super.exp2);
        return new Devide(fPrineGMinGPrineF, gPower2);
    }
}
