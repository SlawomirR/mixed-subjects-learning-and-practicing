package wycash_multicurrency_demo;

class Bank {

    Money reduce(Expression source, String usd) {
        Sum sum = (Sum) source;
        return sum.reduce(usd);
    }
}
