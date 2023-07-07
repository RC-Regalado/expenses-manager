package com.rc.rastreador.expenses;

public class Action extends Event {
    public Action(String name) {
        this.name = name;
        this.cost = 0f;
    }

    public Action(Expense expense){
        this.name = expense.name;
        this.cost = expense.cost;
    }
}
