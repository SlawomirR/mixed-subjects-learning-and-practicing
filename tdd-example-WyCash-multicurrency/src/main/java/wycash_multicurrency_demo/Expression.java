package wycash_multicurrency_demo;

interface Expression {

    Money reduce(Bank bank, String usd);

    Expression times(int multiplier);

    Expression plus(Expression addend);
}
