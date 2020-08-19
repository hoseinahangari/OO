package main.expression.literal;

import main.expression.Expression;

public class Value extends Expression {

    private Double value;

    public Value(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public Double eval() {
        return value;
    }

    @Override
    public Expression derive(Variable variable) {
        return new Value(0D);
    }
}
