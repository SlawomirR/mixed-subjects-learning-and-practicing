package wycash_multicurrency_demo;

class Sum implements Expression {

    Money augend;
    Money addend;

    Sum(Money augend, Money addend) {
        this.addend = addend;
        this.augend = augend;
    }

    Money reduce(String usd) {
        int amount = augend.amount + addend.amount;
        return new Money(amount, usd);
    }
}
