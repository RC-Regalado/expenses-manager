package com.rc.rastreador;

import org.junit.Test;

import static org.junit.Assert.*;

import java.text.Collator;

import com.rc.rastreador.expenses.Event;
import com.rc.rastreador.expenses.Expense;
import com.rc.rastreador.expenses.Action;
import com.rc.rastreador.utils.Collector;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExpensesUnitTest {
    @Test
    public void OneLeafCollect() {
        Collector collector = new Collector();

        new Expense("Test", 3.5f).collectData(collector);

        assertEquals(3.5f, collector.getData(), 0.1f);
    }

    @Test
    public void ActionTree() {
        Event root = new Action("Root");

        root.addLeaf(new Expense("Root 1", 2.5f));
        root.addLeaf(new Expense("Root 2", 2.5f));
        root.addLeaf(new Expense("Root 3", 2.5f));

        Collector collector = new Collector();

        root.collectData(collector);

        assertEquals(7.5f, collector.getData(), 0.1f);
    }
}
