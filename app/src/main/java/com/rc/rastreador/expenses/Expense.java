package com.rc.rastreador.expenses;

import java.util.Date;

public class Expense extends Event {
    public Expense(String name) {
        this.date = new Date();
        this.name = name;
        this.cost = 0;
    }

    public Expense(String name, float cost) {
        this.date = new Date();
        this.name = name;
        this.cost = cost;
    }


}
