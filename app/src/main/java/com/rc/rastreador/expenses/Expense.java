package com.rc.rastreador.expenses;

public class Expense extends Event {
    public Expense(String name) {
        this.name = name;
        this.cost = 0;
    }

    public Expense(String name, float cost) {
        this.name = name;
        this.cost = cost;
    }


}
