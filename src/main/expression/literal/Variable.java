package main.expression.literal;


import main.expression.Expression;

public class Variable extends Expression {
    private String name;
    private Value value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Variable(String name) {
        this.name = name;
        super.addToVariables(this);
    }

    @Override
    public Expression eval(Variable variable, Double d) {
        return super.eval(variable, d);
    }

    @Override
    public Double eval() {
        return this.value.getValue();
    }

    @Override
    public Expression derive(Variable variable) {
        if(variable.getName()==name)
            return new Value(1D);
        return new Value(0D);
    }
}
