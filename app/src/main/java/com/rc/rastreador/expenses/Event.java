package com.rc.rastreador.expenses;

/*
* Usando la lógica de la estructura LinkedList
* Y al igual que car y cdr en lisp este posee dos miembros que almacenan la información
* En este caso el nombre del dato y su costo
 */

import com.rc.rastreador.utils.Collector;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Event {
    protected List<Event> leafs;

    protected Date date;
    protected String name;
    protected float cost;

    public Event() {
        this.leafs = new ArrayList<>();
    }

    public void collectData(Collector collector){
        if (leafs == null){
            collector.add(cost);
            return;
        }

        for (Event leaf : leafs)
            leaf.collectData(collector);

        cost = collector.getData();
    }

    public void addLeaf(Event leaf) {
        if (this instanceof Expense) throw new RuntimeException("Expenses couldn't have leafs;");

        leafs.add(leaf);
    }
}
