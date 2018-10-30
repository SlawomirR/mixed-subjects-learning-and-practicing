package wycash_multicurrency_demo;

class Sum implements Expression {

    Expression augend;
    Expression addend;

    Sum(Expression augend, Expression addend) {
        this.addend = addend;
        this.augend = augend;
    }

    public Money reduce(Bank bank, String usd) {
        int amount = augend.reduce(bank, usd).amount + addend.reduce(bank, usd).amount;
        return new Money(amount, usd);
    }

    @Override
    public Expression times(int multiplier) {
        return new Sum(augend.times(multiplier), addend.times(multiplier));
    }

    @Override
    public Expression plus(Expression addend) {
        return new Sum(this, addend);
    }
}
