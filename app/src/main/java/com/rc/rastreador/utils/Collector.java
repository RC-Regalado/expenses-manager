package com.rc.rastreador.utils;

public class Collector {
    private float data;

    public Collector() {
        data = 0;
    }

    public void add(float data){
        this.data += data;
    }

    public float getData() {
        return data;
    }
}
