package wycash_multicurrency_demo;

import java.util.Hashtable;

class Bank {

    private Hashtable rates = new Hashtable();

    Money reduce(Expression source, String usd) {
        return source.reduce(this, usd);
    }

    int rate(String from, String to) {
        if (from.equals(to)) {
            return 1;
        }
        return (Integer) rates.get(new Pair(from, to));
    }

    void addRate(String from, String to, int rate) {
        rates.put(new Pair(from, to), rate);
    }
}
